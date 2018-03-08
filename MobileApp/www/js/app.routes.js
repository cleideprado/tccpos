angular.module('sces')
  .config(function ($stateProvider, $urlRouterProvider) {
    
    $stateProvider
      .state('login', {
        url: '/',
        views: {
          'login': {
            templateUrl: 'templates/login.html',
            controller: 'loginController'
          }
        }
      })
      .state('signup', {
        url: '/signup',
        views: {
          'login': {
            templateUrl: 'templates/signup.html',
            controller: 'signupController'
          }
        }
      })
      .state('cliente', {
        url: '/cliente',
        views: {
          'login': {
            templateUrl: 'templates/cliente.html',
            controller: 'clienteController'
          }
        }
      })
      $urlRouterProvider.otherwise('/')
  });