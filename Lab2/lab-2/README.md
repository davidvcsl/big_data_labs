## Laboratorio 2: Web Analytics - David González, Alfredo Martínez.   

###Instrucciones para ejecutar el job:

- Situarse en el directorio Lab2/lab-2/Sessionization/
- Ejecutar sbt assembly
- Ejecutar el .jar con: 
	- DIRECTORIO_DE_SPARK/bin/spark-submit target/scala-2.11/Sessionization-assembly-1.0.jar directorio_con_los_logs directorio_de_salida 30
 
- Las tablas de hits y de sesiones serán guardadas en formato parquet con los nombres hits.parquet y sessions.parquet (respectivamente) dentro del directorio de salida especificado anteriormente.

###Instrucciones para ejecutar las métricas:

- Importar en un notebook de Zeppelin el archivo metricas.json ubicado en el directorio Lab2/lab-2/
- Modificar PATH con el directorio donde se encuentra hits.parquet y sessions.parquet
- Ejecutar las métricas


---
Nota: Los logs utilizados se encuentran en https://cs.famaf.unc.edu.ar/~damian/bigdata/curso/posgrado_optativa/lectivo/doc/lab-2/event-log.tar.gz
