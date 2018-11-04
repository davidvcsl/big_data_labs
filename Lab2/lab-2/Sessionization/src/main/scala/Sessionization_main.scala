import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.SaveMode
import java.sql.Timestamp

object Sessionization {

    //Creamos las clases para las tablas de los .parquet
    case class table_columns (timestamp: java.sql.Timestamp, user_id: String, event_id: String, amount: String)
    case class session_columns (user_id: String, session_init: java.sql.Timestamp, session_end: java.sql.Timestamp, renders_amount: BigInt, checkout_amount: BigInt, plays_amount: BigInt, amount: String)

    def main(args: Array[String]) {

        if (args.length != 3) {
          Console.err.println("Need three arguments: <file in directory> <file out directory> <session expiration time (in minutes)>")
          sys.exit(1)
        }

        val fIn = args(0).toString
        val fOut = args(1)
        val exp_time = args(2).toInt

        val spark = SparkSession
          .builder()
          .appName("Sessionization")
          .config("spark.some.config.option", "algun-valor")
          .getOrCreate()

        import spark.implicits._

        //Cargamos el archivo a la tabla
        val table = spark.read.option("delimiter", "\t").csv(fIn).toDF("timestamp", "user_id", "event_id", "amount").as[table_columns]

        //Window que particiona por usuario y ordena por tiempo
        val byUser = Window.partitionBy('user_id).orderBy('timestamp)

        //Creamos una columna con la diferencia de timestamps (en segundos) entre una fila y la de arriba
        val table_tstamps_diff =  table.withColumn("diff", unix_timestamp($"timestamp") - unix_timestamp(lag($"timestamp",1,0) over byUser))

        //Creamos una columna con 1 si se supero el tiempo maximo de inactividad (i.e. una sesion nueva) y 0 c.c.
        val table_new_sessions = table_tstamps_diff.withColumn("new_session", when($"diff" >= exp_time * 60 , 1).otherwise(0)) 

        //Creamos tabla que indica el numero de sesion por usuario (user_numdesesion)
        val table_sessions = table_new_sessions.withColumn("session_number", concat($"user_id", concat(lit("_"), (sum($"new_session") over byUser))))

        //Creamos la tabla con los datos de las sesiones
        val new_table_time_sessions = table_sessions.select("*")
                                    .groupBy($"user_id", $"session_number")
                                    .agg(min($"timestamp").as("session_init"), max($"timestamp").as("session_end"), 
                                    sum(when($"event_id" === "12c6fc06c99a462375eeb3f43dfd832b08ca9e17", 1).otherwise(0)).as("renders_amount"), 
                                    sum(when($"event_id" === "bd307a3ec329e10a2cff8fb87480823da114f8f4", 1).otherwise(0)).as("plays_amount"), 
                                    sum(when($"event_id" === "7b52009b64fd0a2a49e6d8a939753077792b0554", 1).otherwise(0)).as("checkout_amount"), 
                                    sum($"amount").as("amount"))
                                    .drop($"session_number") //se descarta la columna con los numeros de sesion
                                    .as[session_columns] //pasamos a dataset

        //Guardamos las tablas en .parquet
        new_table_time_sessions.write.mode(SaveMode.Overwrite).save(fOut ++ "/sessions.parquet")
        table.write.mode(SaveMode.Overwrite).save(fOut ++ "/hits.parquet")
    }
}
