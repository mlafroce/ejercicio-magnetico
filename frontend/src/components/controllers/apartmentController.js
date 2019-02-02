'use strict';

import angular from 'angular';

angular.module('appModule')
  .controller('apartmentController',
    ['$scope',
    function($scope) {
      $scope.greeting = "Hello world";
    }
]);

