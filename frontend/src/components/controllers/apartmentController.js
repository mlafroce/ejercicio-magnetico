'use strict';

import angular from 'angular';
import '../views/apartment.html'

/**
 * Controlador de departamentos
 */
// Hay formas más prolijas de lidiar con los promises, pero no las recuerdo en este momento
angular.module('appModule')
  .controller('apartmentController',
    ['$scope', 'apartmentService',
    function($scope, apartmentService) {
      // Carga los departamentos iniciales
      apartmentService.list()
        .then(function(response){
            $scope.apartments = response.data;
        }, function(error, status){
            console.log("Error: ", error, status);
        }); //fin then()
      console.log('apartments:', $scope.apartments);
    }
]);

