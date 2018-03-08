angular.module('sces')
    .service('clienteService', function ($http) {
        this.deletecliente = function (cpf) {
            var url = 'https://sces.herokuapp.com/webapi/clientes/' + cpf;
            return $http({
                method: 'DELETE',
                url: url
            });
        }

        this.createcliente = function (cliente) {
            var url = 'https://sces.herokuapp.com/webapi/clientes/';
            return $http({
                method: 'POST',
                url: url,
                headers: {
                    'Content-Type': "application/json"
                  },
                data: { "nome": cliente.nome, 
                        "cpf": cliente.cpf, 
                        "senha": cliente.senha, 
                        "endereco": cliente.endereco, 
                        "estado": cliente.estado, 
                        "municipio": cliente.municipio, 
                        "email": cliente.email, 
                        "telefone": cliente.telefone 
                    }
            });
        }

        this.editarcliente = function (cliente) {
            var url = 'https://sces.herokuapp.com/webapi/clientes/'+cliente.cpf;
            return $http({
                method: 'PUT',
                url: url,
                headers: {
                    'Content-Type': "application/json"
                  },
                data: { "nome": cliente.nome, 
                        "cpf": cliente.cpf, 
                        "senha": cliente.senha, 
                        "endereco": cliente.endereco, 
                        "estado": cliente.estado, 
                        "municipio": cliente.municipio, 
                        "email": cliente.email, 
                        "telefone": cliente.telefone 
                    }
            });
        }
    });