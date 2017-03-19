angular.module("versificacao").factory("versificacao_srvc",function($http) {
	porta = "8080";
	
	var _versificar = function(poematexto) {
		endereco = "";
		console.log('teste_');
		console.log('' + window.location.host);
		console.log('teste_19-03-2017');
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
