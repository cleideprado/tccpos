angular.module('sces')
.controller('signupController', ['$scope','$window', 'clienteService',  function($scope,$window,clienteService) {
    $scope.cliente = {
        nome: '',
        cpf: '',
        senha: '',
        endereco: '',
        estado: '',
        municipio: '',
        email: '',
        telefone: ''
    };

    $scope.createcliente = function () {
        clienteService.createcliente($scope.cliente)
            .then(function (success) {
                if (success.status == 201) {
                    alert("Cliente cadastrado com sucesso!");
                }
                else {
                    alert("Cliente não pode ser cadastrado!");
                }
                $window.location.href = 'index.html';
            }, function (error) {
                console.log(error);
            });
    };
/*
    $scope.onSubmit = function () {
        alert('Teste')
        //$window.location.href = 'templates/login.html';
    }; */
}]);