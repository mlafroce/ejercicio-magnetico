# Documentación técnica

## Backend

Se utilizó una arquitectura *MVCS* (Model view controller service), utilizando el framework *Spring boot* para ofrecer un servicio rest.

### Controladores

Existe un controlador, `ApartmentController`, que ofrece el recurso "/apartments" para:

* Listar departamentos

* Presupuestar un alquiler

* Alquilar

### Servicios

Existen dos servicios, `ApartmentService` y `RentService`, separados en interfaz e implementación.

El primero se encarga de interactuar con el DAO de departamentos y el segundo con el de alquileres

### DAOs

Existen dos DAOs para poder realizar persistencia en la base de datos: `ApartmentDAO` y `RentDAO`, también separados en interfaz e implementación.

### Modelo

Existen dos entidades: `Apartment` y `Rent`. La primera es el departamento, con los datos pedidos en el enunciado. El segundo representa un alquiler, que es una tupla (*Departamento*, *Nombre de usuario*). Para saber si se realiza un descuento por alquiler previo, un usuario tiene que haber alquilado ese mismo departamento (almacenandose la tupla correspondiente).

Los descuentos se calculan en la clase `Apartment`

## Frontend

Se utilizó también una arquitectura *MVCS*, aunque el modelo fue más pobre que en el backend

### Controladores

El controlador `ApartmentController` se encarga manejar los departamentos disponibles, presupuestar y alquilar.

### Servicios

El servicio `ApartmentService` se encarga de interactuar con la API del backend

### Vistas

No logré implementar la vista por separado del controlador, teniendo que recaer en poner la vista en `index.html`

### Otros

Se utiliza un interceptor para agregar el prefijo de la API a los requests. El mismo se configura desde el punto de entrada de la aplicación, `app.js`
