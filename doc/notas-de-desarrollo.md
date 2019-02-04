# Notas de desarrollo

## Backend

Se utiliza **Springboot** y se configuran los componentes mediante anotaciones. La jerarquía de paquetes es tal que la clase **Application** está por sobre todas las demás clases anotadas, de forma que pueda hacer un *scan* automático de los componentes sin necesidad de configurarlos.

La versión utilizada de spring boot incorpora *JPA*. Esto trajo bastantes complicaciones a la hora de configurar la persistencia, ya que en muchos tutoriales utilizan *Hibernate*, y habían varios ejemplos con código deprecado o incompatible.

La configuración de JPA se realiza

## Frontend

Se utiliza Angular 1 y webpack.

Webpack permite tomar un punto de entrada (en este caso *app.module.js*), y realizar importaciones de otros archivos javascript en forma de cascada.

A su vez, Webpack ofrece un servidor de desarrollo que mientras está en ejecución recompíla el código cada vez que un archivo cambia, para desarrollar de forma más ágil.
