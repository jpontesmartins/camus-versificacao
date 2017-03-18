angular.module("versificacao",[]);
angular.module("versificacao").controller("versificacao_ctrl",

	function($scope, $http, versificacao_srvc) {
		$scope.app = "Versificacao";
		$scope.poema = "";
		
		$scope.versificacao = function(poema) {
			console.log(poema);
			versificacao_srvc.versificar(poema).success(function(data) {
				console.log('chamou o servico e retornou:' + data.poema);
				console.log('chamou o servico e retornou2:' + data.poemaVersificado);
				$scope.poema = data;
			});
		};
		
		
});
