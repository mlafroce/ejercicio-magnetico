# API Rest

Esta documentación es más linda si se hace con *Swagger*

## API de departamentos

### Listar departamentos

`${API_URL}/apartments/`: Tipo `GET` Devuelve una lista con todos los departamentos en formato json

Ejemplo de respuesta

~~~{.json}
[
   {
      "id":1,
      "location":"Aldo Bonzi",
      "rooms":1,
      "area":40,
      "rentPerDay":100.0,
      "rentPerMonth":4000.0
   },
   {
      "id":2,
      "location":"Burzaco",
      "rooms":3,
      "area":85,
      "rentPerDay":200.0,
      "rentPerMonth":7500.0
   }
]
~~~


### Estimar costo

`${API_URL}/apartments/:id/estimate?days=:days&months=:months&username=:username`: Tipo `GET` Devuelve un `double` con el costo del departamento a alquilar

**Parametros**:

* `id`: id del departamento a alquilar

* `days`: dias a alquilar

* `months`: meses a alquilar

* `username`: nombre del usuario a alquilar, necesario para saber si aplica descuento


### Alquilar

`${API_URL}/apartments/:id`: Tipo `POST`, devuelve el id de la renta realizada.

**Parametros**:

* `id`: id del departamento a alquilar

**Parametros del cuerpo**:

* `username`: usuario que alquila
