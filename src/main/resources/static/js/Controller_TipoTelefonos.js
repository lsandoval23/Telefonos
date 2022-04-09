angular.module('myApp', []).controller('Secundario', function ($http, $scope) {

    $scope.Persona = {
        cedula : "15558285",
        nombre: "Luis Enrique",
        apellido: "Sandoval Ancco",
        telefonos : []
    }

    $scope.url = "http://localhost:8080/";


});