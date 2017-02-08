'use strict';
(function() {
	var CarController = function($scope, $http) {
		$scope.cars = []
		$scope.users = []
		var self = this;

		self.doGetCars = function() {
			$http.get('/car/list').then(function(response) {
				$scope.cars = response.data;
			});
			
			$http.get('/user/list').then(function(response) {
				$scope.users = response.data;
			});
		}

		self.createCar = function() {
			$http({
				method : 'POST',
				url : '/car/create',
				data : $scope.car,
				headers : {
					'Content-type' : 'application/json;charset=utf-8'
				}
			}).then(function(response) {
				self.doGetCars();
			});
		}

		$scope.doSubmit = function() {
			self.createCar();
		}

		$scope.reset = function() {
			$scope.carForm.$setPristine();
		}

		function init() {
			self.doGetCars();
		}
		init();

	};

	angularApp.controllers.controller('CarController', [ '$scope', '$http', CarController ]);
})();