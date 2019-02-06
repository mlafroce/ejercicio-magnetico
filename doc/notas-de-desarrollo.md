# Notas de desarrollo

## Configuración en general

### Backend

Se utiliza **Springboot** y se configuran los componentes mediante anotaciones. La jerarquía de paquetes es tal que la clase **Application** está por sobre todas las demás clases anotadas, de forma que pueda hacer un *scan* automático de los componentes sin necesidad de configurarlos.

La versión utilizada de spring boot incorpora *JPA*. Esto trajo bastantes complicaciones a la hora de configurar la persistencia, ya que en muchos tutoriales utilizan *Hibernate*, y habían varios ejemplos con código deprecado o incompatible.

La configuración de JPA se realiza de forma bastante automática, utilizando *h2* para tener una base de datos en memoria

### Frontend

Se utiliza Angular 1 y webpack.

Webpack permite tomar un punto de entrada (en este caso *app.module.js*), y realizar importaciones de otros archivos javascript en forma de cascada.

A su vez, Webpack ofrece un servidor de desarrollo que mientras está en ejecución recompíla el código cada vez que un archivo cambia, para desarrollar de forma más ágil.

**ATENCIÓN**: No logré asociar el template html con el controlador correspondiente, por lo que terminé metiendo el código del controlador en el index.html. Se que está mal, pero no llegué a tiempo.

## Cosas que faltaron

* **Documentación**: La documentación en general la hice muy a las apuradas, más que nada la documentación del proyecto. Me hubiera gustado agregar un gráfico para describir la arquitectura y ampliar un poco más esa sección.

* **Documentación de código**: Algunos métodos me parecían triviales y no los documentaba. Las clases que implementan interfaces no están documentadas, ya que las interfaces lo están.

* **Chequeo de errores**: El camino feliz anda bien, los chequeos de errores no están contemplados

* **Más feedback en la interfaz gráfica**: Ligado a lo que está arriba, le falta feedback al usuario cuando realiza acciones (por ejemplo, cuando quiere presupuestar y no tiene los datos completos)

* **Docker**

* **Lógica de modelo más compleja**: Los alquileres están modelados muy vagamente
