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
//	    var url = 'localhost:8080/';
	    var url = 'http://localhost:8080/versificar';
//	    var data = {poemaTexto: poema};
//	    return $http.post(url, data).success(function(data){
//	    	console.log('fdfk');
//	    });
	    return $http.get(url + "?poemaTexto=" + poema);
	};
	
	
	return {
		versificar : _versificar,
		versificar2 : _versificar2
	}
});
