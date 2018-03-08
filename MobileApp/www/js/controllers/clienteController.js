angular.module('sces')
    .controller('clienteController', ['$scope', '$window','$ionicModal','$state','clienteService',  function ($scope, $window,$ionicModal,$state, clienteService) {
        $scope.cliente = JSON.parse($window.localStorage.getItem('cliente'));

        $scope.deletecliente = function () {
            clienteService.deletecliente($scope.cliente.cpf)
                .then(function (success) {
                    if (success.status == 200) {
                        alert("Cliente foi deletado com sucesso!");
                    }
                    else {
                        alert("Cliente não pode ser deletado!");
                    }
                    $window.location.href = 'index.html';
                }, function (error) {
                    alert(error);
                });
        };

        

        $scope.onLogout = function () {
            $window.location.href = 'index.html';
        };

        $ionicModal.fromTemplateUrl('modal.html', {
            scope: $scope,
            animation: 'slide-in-up'
          }).then(function(modal) {
            $scope.modal = modal;
          });
          $scope.openModal = function() {
            $scope.modal.show();
          };
          $scope.editarcliente = function () {
            clienteService.editarcliente($scope.cliente)
                .then(function (success) {
                    if (success.status == 200) {
                        $window.localStorage.setItem('cliente', JSON.stringify($scope.cliente))
                        alert("Alterações concluídas com sucesso!");
                    }
                    else {
                        alert("Não foi possível salvar as alterações.");
                    }
                    $window.location.reload();
                }, function (error) {
                    alert(error);
                });
        };
          $scope.closeModal = function() {
            $scope.modal.hide();
          };
          // Cleanup the modal when we're done with it!
          $scope.$on('$destroy', function() {
            $scope.modal.remove();
          });
          // Execute action on hide modal
          $scope.$on('modal.hidden', function() {
            // Execute action
          });
          // Execute action on remove modal
          $scope.$on('modal.removed', function() {
            // Execute action
          });
        
    }]);