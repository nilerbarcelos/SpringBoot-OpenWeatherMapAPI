appHbsis.controller("cidadeController", function($scope, $http) {

	$scope.cidades = [];
	$scope.cidade = {};

	carregarCidades = function(){
		$http({method : 'GET', url : '/cidades'})
		.then(function(response) {
			$scope.cidades = response.data;
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarCidade = function(){
		
		if($scope.frmCidade.$valid){
			$http({method : 'POST', url : '/cidades', data: $scope.cidade})
			.then(function(response) {
				carregarCidades();
				$scope.cidade = {};
				$scope.frmCidade.$setPristine(true);
			}, function(response) {
				console.log(response.data);
				console.log(response.status);
				$scope.cidade.error = true;
			});
		}else{
			window.alert("Dados Invalidos");
		}
	};
	

	$scope.excluirCidade = function(cidade) {
		$http({method : 'DELETE', url : '/cidades/' + cidade.id})
		.then(function(response) {			
			posicao = $scope.cidades.indexOf(cidade)
			$scope.cidades.splice(posicao, 1);
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	carregarCidades();
});