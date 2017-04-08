angular.module("versificacao").factory("versificacao_srvc",function($http) {
	porta = "8080";
	
	
	var _versificar2 = function(poema){
	    var url = window.location.origin;
	    console.log('camus-versificação ' + poema);
	    return $http.get(window.location.origin + "/versificar?poemaTexto=" + poema);
	};
	
	
	return {
		versificar2 : _versificar2
	}
});
