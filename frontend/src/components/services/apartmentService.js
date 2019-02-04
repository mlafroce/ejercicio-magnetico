angular.module('appModule')
  .service('apartmentService', ['$http', function apartmentService($http) {
    this.list = function(){
        return $http.get("/apartments/");
    }
  }
]);