'use strict';

import angular from 'angular';
import 'angular-route';
import 'bootstrap/dist/css/bootstrap.min.css';
import './components/assets/app.css';

import appModule from './components/app.module';
import ApartmentController from './components/controllers/apartmentController';
import ApartmentService from './components/services/apartmentService';

appModule.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/', { templateUrl: 'index.html'})
        .when('/apartment', { templateUrl: 'components/views/apartment.html', controller: 'apartmentController' })
    }
]);

// api url prefix
var API_URL = 'http://localhost:8080';

appModule.factory('apiInterceptor', ['$q',
    function ($q){
      return {
        request: function (config) {
          var url = config.url;

          // ignore template requests
          if (url.substr(url.length - 5) == '.html') {
            return config || $q.when(config);
          }

          config.url = API_URL + config.url;
          return config || $q.when(config);
        }
      }      
    }
]);

appModule.config(['$httpProvider',function ($httpProvider) {
    $httpProvider.interceptors.push('apiInterceptor');
  }
]);