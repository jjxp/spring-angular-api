'use strict';
(function() {
	var ApiDocController = function($scope) {
		$scope.isLoading = false;
		$scope.url = $scope.swaggerUrl = '/v2/api-docs';
		$scope.myErrorHandler = function(data, status) {
		};

		$scope.info = false;
	};

	angularApp.controllers.controller('ApiDocController', [ '$scope', ApiDocController ]);
})();