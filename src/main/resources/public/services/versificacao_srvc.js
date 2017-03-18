angular.module("versificacao").factory("versificacao_srvc",function($http) {
	porta = "8080";
	
	var _versificar = function(poematexto) {
		return $http.get("http://localhost:" + porta +"/versificar?poema=" + poematexto);
	}
	
	return {
		versificar : _versificar
	}
});
