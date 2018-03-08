angular.module('sces')
    .service('loginService', function ($http) {
        this.onLogin = function (cliente) {
            var url = 'https://sces.herokuapp.com/webapi/login';
            return $http({
                method: 'GET',
                url: url,
                params: {email:cliente.email, senha:cliente.senha} 
                
            });
        }
    });