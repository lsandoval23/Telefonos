

angular.module('myApp', []).controller('Principal', function ($http, $scope) {

    var Nombre = "Jose";

    $scope.Persona_Nombre = "";
    $scope.Persona_Cedula = "";

    $scope.TipoTelefonos = [
        {
            id : 1,
            tipo : "Celular"
        },
        {
            id : 2,
            tipo : "Fijo"
        },
        {
            id : 3,
            tipo : "Fax"
        },
        {
            id : 4,
            tipo : "Satelitar"
        },
        {
            id : 5,
            tipo : "Hibrido"
        }
    ];

    $scope.TipoStatus = [
        {
            id : "1",
            tipo : "Activo"
        },
        {
            id : "2",
            tipo : "Inactivo"
        }
    ];

    $scope.Persona = {
        cedula : "15558285",
        nombre: "Eurides José",
        apellido: "Mapari Ramirez",
        telefonos : []
    }
	
	$scope.url = "http://localhost:8080/";
	
	function LlenarTelefonos(){
		$http({
            method: 'GET',
            url: $scope.url + "listar_telefonos",
            dataType: "json" ,
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'Accept-Charset': undefined
            }
        }).then(function successCallback(data) {
			console.log(data);
			var datos = data.data;
			console.log(datos);
			$scope.Persona.telefonos = [];
			for (var x = 0; x < datos.length; x++){
				$scope.Persona.telefonos.push({
					id : datos[x].id,
					tipo : datos[x].tipo,
					numero : datos[x].numero,
					estado : datos[x].estado,
					des_estado : datos[x].des_estado
				})
			}
		});
	}
	
	LlenarTelefonos();

    $scope.EliminarTelefono = function(datos, posicion){
        console.log(datos);
        var mensaje = "¿Seguro que desea eliminar el número telefónico <b>" + datos.tipo + " " + datos.numero + "?";
        swal.queue([{
            title: 'Advertencia',
            text: mensaje,
            type: 'question',
            showLoaderOnConfirm: true,
            showCancelButton: true,
            confirmButtonText: 'Eliminar',
            cancelButtonText: 'Cancelar',
            confirmButtonClass: 'btn btn-success',
            cancelButtonClass: 'btn btn-danger',
            preConfirm: function () {
                return new Promise(function (resolve, reject) {
					$http({
			            method: 'PUT',
			            url: $scope.url + "eliminar/" + datos.id,
			            dataType: "json" ,
			            headers: {
			                'Content-Type': 'application/x-www-form-urlencoded',
			                'Accept-Charset': undefined
			            }
			        }).then(function successCallback(data) {
	                    var response = data.data;
						if (response.error === 0){
							resolve();
						}else{
							reject(response.messenger);	
						}
                	}, function errorCallback(response) {
						reject(response.data.message)
					})
            	});
        	}
        }]).then(function (result) {
			LlenarTelefonos();
           	swal("", "Telefono eliminado", "success");
        });
        $(".swal2-content").html(mensaje);

    }

    $scope.AgregarTelefono = function(){
        $scope.Posicion = -1;

        $scope.telefonos = {
			id : 0,
            tipo: "",
            numero: null,
            estado: "1"
        }
        $("#AgregarTelefono").modal("show");
    }

    $scope.GuardarTelefono = function(){
        console.log($scope.telefonos);
        for (var x = 0; x < $scope.Persona.telefonos.length; x++){
            if ($scope.telefonos.numero === $scope.Persona.telefonos[x].numero && x !== $scope.Posicion){
                $.jGrowl("el telefono número <b>" + $scope.telefonos.numero + "</b>", {
                    life: 2500,
                    theme: 'growl-warning',
                    header: ''
                });
                //General.EscucharMensaje("el telefono número " + $scope.telefonos.numero);
                swal("Acción Cancelada", "el telefono número <b>" + $scope.telefonos.numero + "</b>, ya existe", "warning");
                return false;
            }
        }
        
                
        $http({
            method: 'POST',
            url: $scope.url + "save",
            data : JSON.stringify($scope.telefonos),
            dataType: "json" ,
            headers: {
                'Content-Type': 'application/json'
            } 
        }).then(function successCallback(data) {
			var response = data.data;
			if (response.error === 0){
				LlenarTelefonos();
				swal("", response.messenger, "success");
				$("#AgregarTelefono").modal("hide");	
			}else{
				swal("", response.messenger, "warning");	
			}
			
		}, function errorCallback(response) {
			console.log(response);
			swal($.trim(response.data.status), "<b>" + response.data.error + "</b><br>" + response.data.message + " (" + response.data.path + ")", "warning");
		});
        
    }

    $scope.EditarTelefono = function(datos, posicion){
		console.log(datos);
		$http({
            method: 'GET',
            url: $scope.url + "listar_id/" + datos.id,
            dataType: "json" ,
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'Accept-Charset': undefined
            }
        }).then(function successCallback(data) {
			console.log(data);
			var datos = data.data;
			$scope.telefonos = {
				id : datos.id,
	            tipo: datos.tipo,
	            numero: datos.numero,
	            estado: datos.estado
	        }
			
	        $("#AgregarTelefono").modal("show");

			
		});
                
                
    }


});

