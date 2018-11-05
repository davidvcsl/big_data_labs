# Proyecto Final
## Sentiment Analysis en Twitter.

El proyecto consiste en reproducir, utilizando Spark, el estudio realizado en la tesis de grado que se encuentra en este directorio.

Los alumnos de posgrado tendrán que agregar alguna mejora. Pueden elegir una y/o basarse en los trabajos futuros que propone la tesis.  

### Objetivos

El proyecto no es pautado de forma tal que los pasos para realizarlo no estarán explicitados.
La idea es que, tomando la tesis como hoja de ruta, se decida una arquitectura del sistema y se realicen los programas que la implementen.

Se contará con los docentes para consultar cualquier duda al respecto y se harán recomendaciones para llevar a cabo la tarea.

### Requerimientos

* Se debe utilizar la API Spark ML basada en Dataframe.
* En los programas finales se debe utilizar pipelines siempre que sea posible.
* Se deben cachear los dataframes/datasets siempre que sea necesario para aumentar la eficiencia.
* La parte visual tiene que correr en Zeppelin.
* La fecha de entrega limite del proyecto es el domingo 26 de noviembre. A esta fecha el proyecto debe estar en el repositorio del grupo en el directorio `proyecto_final`.
* En el directorio `proyecto_final` debe haber un archivo `README.md` que
    - describa los archivos en el directorio,
    - mencione las versiones de Spark y Zeppelin para ejecutar el proyecto,
    - explique como obtener y visualizar los resultados.
* Para aprobar el proyecto  se deberá realizar un coloquio grupal (de 45 minutos como máximo) en el cual se realizará una presentación del trabajo realizado junto con una demo de la implementación.
* La presentación debe estar en el repositorio del grupo en formato pdf o html antes del coloquio.
* Los coloquios se realizarán el día 12/12 a las 9 hs.

#### Recomendaciones

* Se recomienda seguir en orden las etapas (pipeline) que propone la tesis.
* Comenzar implementando las etapas con los algoritmos que ya brinda Spark, aunque sean distintos a los de la tesis.
* Para comenzar la primera etapa (recolección de datos y su pre-procesamiento) se sugiere computar las estadísticas sobre los tweets (que se explican en la sección 2.1 de la tesis) en Spark, y ver si los resultados son coinciden. 
* Para hacer esta etapa (tokenizador, vectorizacion, df, tf, etc.) en Spark ver [Extracting, transforming and selecting features](http://spark.apache.org/docs/latest/ml-features.html) y principalmente su sección [TF-IDF](http://spark.apache.org/docs/latest/ml-features.html#tf-idf).
* Ver si en la tesis se tokeniza a lowercase
* (continuará)

### Datos para sentiment análisis
* En carpeta [proyecto](posgrado_optativa/lectivo/doc/proyecto)
    - [tweets de los premios Oscar](posgrado_optativa/lectivo/doc/proyecto/oscars_dataset.tar.gz)
    - [movie review polaridad](posgrado_optativa/lectivo/doc/proyecto/review_polarity.tar.gz)
      que viene de: http://www.cs.cornell.edu/people/pabo/movie-review-data/
      por el paper: http://www.cs.cornell.edu/home/llee/papers/sentiment.pdf
    - [Lexicones con polaridad por palabras](posgrado_optativa/lectivo/doc/proyecto/lexicones).
    - [Tweets tageados](posgrado_optativa/lectivo/doc/proyecto/tagged_tweets).

### Otros materiales de ayuda

* [Repo](https://github.com/fuxes/twitter-sentiment-clustering) con código de la tesis.
* Ejemplo [Twitter Streaming Language Classifier](https://databricks.gitbooks.io/databricks-spark-reference-applications/content/twitter_classifier/index.html) de Databricks.
* [Spark stemming](https://github.com/master/spark-stemming).
* [Porter Stemming in Apache Spark ML](http://www.reorchestrate.com/porter-stemming-in-apache-spark-ml/).
* [Script](https://github.com/fuxes/twitter-sentiment-clustering/blob/master/server/spider.py) para extaer información de Twitter con [Tweepy](http://www.tweepy.org/).
* [Ejemplo de gráfico de burbujas](https://plnkr.co/edit/CnoTA0kyW7hWWjI6DspS?p=preview).

