appHbsis.controller("cidadeDetalheController", function($scope, $routeParams, $http, $filter){
	
	$scope.parseDate = function (time) {
		return new Date(time * 1000);
	};

	$scope.pegaImagemIcone = function(nomeIcone) {
		return (nomeIcone ? 'http://openweathermap.org/img/w/' + nomeIcone + '.png' : '');
	};
  
	$scope.previsoes = {};
	$http.get("cidades/" + $routeParams.cidadeId)
	.then(function(response) {
		$scope.previsoes = response.data;

		$scope.previsoes;
	}, function(response) {

		console.log(response);
	});
});