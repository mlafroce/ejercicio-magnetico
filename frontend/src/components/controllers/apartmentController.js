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
      $scope.init = function() {
        apartmentService.list()
          .then(function(response){
              $scope.apartments = response.data;
          }, function(error, status){
              console.log("Error: ", error, status);
          }); //fin then()
      }

      /**
      * Realiza una estimación con los datos del departamento activo
      * y la muestra en el popup de alquiler
      */
      $scope.estimate = function() {
        var params = {
          "username": $scope.username,
          "days": $scope.days,
          "months": $scope.months
        }
        apartmentService.estimate($scope.apartmentId, params)
          .then(function(response){
              $scope.estimation = response.data;
          }, function(error, status){
              console.log("Error: ", error, status);
          }); //fin then()
      }

      /**
      * Marca un departamento como activo antes de abrir el popup de alquiler
      */
      $scope.selectApartment = function(id) {
        $scope.rentSuccessful = false;
        $scope.apartmentId = id;
      }

      /**
      * Realiza un alquiler (guarda en la base de datos el nombre de usuario)
      */
      $scope.rent = function() {
        var data = {
          "username": $scope.username
        }
        apartmentService.rent($scope.apartmentId, data)
          .then(function(response){
              $scope.rentSuccessful = true
          }, function(error, status){
              console.log("Error: ", error, status);
          }); //fin then()
      }
      $scope.init();
    }
]);

