angular.module("versificacao").factory("versificacao_srvc",function($http) {
	porta = "8080";
	
	var _versificar = function(poematexto) {
		endereco = 
		console.log('abc');
		if (window.location.host == "") {
			endereco = "http://localhost:8080";
		} else {
			endereco = window.location.host;
		}
		console.log(window.location.host);
		return $http.get(endereco + "/versificar?poemaTexto=" + poematexto);
	}
	
	return {
		versificar : _versificar
	}
});
