angular.module("versificacao").factory("versificacao_srvc",function($http) {
	porta = "8080";
	
	var _versificar = function(poematexto) {
		return $http.get("https://localhost:" + porta +"/versificar?poema=" + poematexto);
	}
	
	return {
		versificar : _versificar
	}
});
