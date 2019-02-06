angular.module('appModule')
  .service('apartmentService', ['$http', function apartmentService($http) {
    /**
    * Trae una lista de todos los edificios disponibles
    */
    this.list = function(){
        return $http.get("/apartments/");
    }
    /**
    * Realiza un presupuesto del alquiler
    */
    this.estimate = function(apartmentId, params){
        // No me sale la sintaxis /ruta/:param/ruta
        return $http.get("/apartments/" + apartmentId + "/estimate", {params: params});
    }
    /**
    * Realiza un alquiler
    */
    this.rent = function(apartmentId, data){
        // No me sale la sintaxis /ruta/:param/ruta
        return $http.post("/apartments/" + apartmentId + "/rent", data);
    }
  }
]);