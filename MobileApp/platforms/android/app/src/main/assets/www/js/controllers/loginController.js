angular.module('sces')
    .controller('loginController', ['$scope', '$window', '$state', 'loginService', function ($scope, $window, $state, loginService) {
        $scope.cliente = {
            email: '',
            senha: ''
        };
        $scope.onLogin = function () {
            //alert('Login');
            loginService.onLogin($scope.cliente)
                .then(function (success) {
                    if (success.data) {
                        $window.localStorage.setItem('cliente', JSON.stringify(success.data))
                        $state.go("cliente");
                    }
                    else {
                        alert('Email ou senha inválido. Tente novamente!');
                        document.getElementById('email').value = '';
                        document.getElementById('password').value = '';
                        $scope.loginForm.email.$setValidity("reason", false);
                        $scope.user.password.$setValidity("reason", false);
                    }
                }, function (error) {
                   // alert('Email ou senha inválido. Tente novamente!');
                    console.log("Error to invoke get service");
                });
        };

    }]);