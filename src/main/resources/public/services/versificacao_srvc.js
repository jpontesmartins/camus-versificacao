angular.module("versificacao").factory("versificacao_srvc",function($http) {
	porta = "8080";
	
	var _versificar = function(poematexto) {
		console.log('a');
		user = "{}"
	    return $http({
	        method: 'POST',
	        url: '/versificar',
	        contentType: "application/json",
	        data:user
	    });
	}
	
	var _versificar2 = function(poema){
//	    var url = 'http://' + window.location.host;
	    var url = window.location.origin;
	    console.log('-> ' + window.location.origin);
	    return $http.get(window.location.origin + "/versificar?poemaTexto=" + poema);
	};
	
	
	return {
		versificar : _versificar,
		versificar2 : _versificar2
	}
});
