//criacao do modulo principal da aplicacao
var appHbsis = angular.module("appHbsis", ['ngRoute']);

appHbsis.config(function($routeProvider, $locationProvider){
	
	$routeProvider
	.when("/cidade", {
		templateUrl : 'view/cidade.html',
		controller : 'cidadeController'
	}).when("/cidade/:cidadeId", {
		templateUrl : 'view/cidade-detalhes.html',
		controller : 'cidadeDetalheController'
	}).otherwise({
		redirectTo : '/'
	});

	$locationProvider.html5Mode({
		enabled : true,
		requireBase : false
	});﻿
	

	
	
});