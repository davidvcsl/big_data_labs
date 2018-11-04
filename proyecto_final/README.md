## Proyecto final de BigData - David González   

###Descripción de archivos en el directorio:

- proyecto_final.json: Notebook donde se encuentra el proyecto.
- new_oscars_trim.json: Json adaptado para spark (y el que se usa en el proyecto), basado en el json original (oscars_trim.json, también en el directorio). En el notebook está el código en python utilizado para la adaptación del nuevo json (no hace falta ejecutarlo)
- stopwords.txt: Stopwords extraídas del repositorio de fuxes: https://github.com/fuxes/twitter-sentiment-clustering/blob/master/server/constants.py. Notar que en el notebook se encuentra la variable fuxesStopWords que contiene un arreglo con las stopwords en cuestión.
- Manually-Annotated-Tweets.tsv: Tweets anotados manualmente para el análisis y clasificación de sentimientos
 

###Versiónes utilizadas para Spark y Zeppelin:

- **Spark**: Versión 2.1.0
- **Zeppelin**: Versión 0.7.3

###Obtener y visualizar los resultados:
- Ignorar la primera celda (ya que es sólo para mostrar como fue procesado el json)
- En la segunda celda modificar PATH con el directorio donde se ubica new_oscars_trim.json y ejecutarla.
- Ejecutar normalmente las siguientes tres celdas.
- Nuevamente modificar PATH, esta vez indicando el directorio donde se encuentra el archivo tsv con los tweets taggeados. Ejecutar la celda.
- Ejecutar las siguientes dos celdas normalmente. La tercer celda es opcional, ya que es para mostrar la distribución de los tweets en los clusters. Nuevamente, la cuarta celda también es opcional; en este caso se utiliza si se quiere agregar un nuevo tweet al dataset.
- Finalmente, en la última celda, elegir el número de burbujas a visualizar (se recomiendan menos de veinte par no saturar la pantalla), y luego seleccionar el cluster que se desea visualizar. La celda se ejecutará automáticamente luego de seleccionar el cluster, y luego se obtendrán las visualizaciones de las burbujas. 
	- Las burbujas pueden seleccionarse clickeando sobre ellas (notar que se resalta el borde de la burbuja en cuestión) y también se pueden arrastrar para acomodarlas de manera distinta.
	- Cada burbuja tiene como label una palabra y abajo de ésta tiene un número N. La palabra es tal que aparece repartida N veces en los tweets del cluster seleccionado.
	- Así mismo, cada burbuja tiene color rojo o verde, dependiendo si la mayoría de los tweets donde aparece la palabra de la burbuja son negativos o positivos respectivamente.
	- Al lado del gráfico de las burbujas se encuentra una tabla que muestra cinco tweets donde aparece la palabra de la burbuja seleccionada con sentimiento positivo, y cinco tweets donde aparece con sentimiento negativo.

---
Nota: El gráfico de las burbujas fue testeado en dos monitores distintos para asegurar la correcta visualización. Aún así puede que, dependiendo de la resolución del monitor, no se visualicen correctamente (por ejemplo, la tabla se puede superponer a las burbujas). En este caso los parámetros a modificar son:
- **width** (en .right, dentro de < style>, para modificar la tabla): Seteado en 550px. Achicarlo si la tabla se superpone a las burbujas
- **width** (dentro de function(), para modificar grafico de burbujas): Seteado en 400. Achicarlo también en caso de superposición.

---
Nota: El notebook quedó configurado de la forma que mejores resultados obtuve.
