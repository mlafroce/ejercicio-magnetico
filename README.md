# Alquileres Magnetico

Este repositorio contiene la resolución del ejercicio de alquileres propuesto por Magnético (click [aquí](doc/enunciado.md))

## Solución propuesta

Se utiliza un servidor **Apache Tomcat** para las operaciones de *backend*, embebido en el mismo jar creado por spring, y un servidor **nginx** para operaciones de *frontend*

Para el *frontend* se utilizó AngularJs y Bootstrap

## Documentación técnica

La documentación técnica se encuentra disponible [aquí](doc/documentacion-tecnica.md), con detalles del diseño y arquitectura de la aplicación.

La documentación de la API rest se encuentra [aquí](doc/api-rest.md)

Notas extra del desarrollo [aquí](doc/notas-de-desarrollo.md)

## Configuración de la API

Para configurar la dirección de la API en el frontend, se debe modificar la variable `API_URL` en el archivo `app.js` y compilar el proyecto

Para configurar el puerto de la API en el backend, se puede agregar la opción `--server.port=<nnnn>` al comando de ejecución (ver más adelante)

## Compilación

### Backend

Requiere `gradle` y java 1.8+

~~~
cd backend
gradle build
~~~

Esto genera un jar con la aplicación en la carpeta `build/libs`

### Frontend

Requiere `npm`

~~~
cd frontend
npm build
~~~

Esto genera una carpeta con los recursos necesarios para la aplicación en la carpeta `dist`

## Ejecución

### Ejecución por individual

#### Frontend

Webpack posee un servidor de desarrollo que puede ser lanzado ejecutando

~~~
npm start
~~~

Si se dispone de un servidor preinstalado, agregar la siguiente configuración

~~~
location /alquileres {
    alias   ${ruta a la carpeta donde fue compilado el frontend};
    index   index.html;
}
~~~

#### Backend

Ejecutar

~~~
java -jar build/libs/apartments-api-${version}.jar
~~~

Ejemplo:

~~~
java -jar build/libs/apartments-api-0.1.0.jar
~~~

### Docker

Se asume que el usuario posee el servicio *docker* y *docker-compose*

~~~
cd docker
docker-compose up
~~~