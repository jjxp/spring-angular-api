'use strict';
(function() {
	var UserController = function($scope, $http) {
		$scope.users = [],
		$scope.user = {
			gender : 'M'
		};
		var me = this;

		self.doGetUsers = function() {
			$http.get('/users').then(function(response) {
				$scope.users = response.data;
			});

		}

		$scope.doDeleteUser = function(id) {
			$http({
				method : 'DELETE',
				url : '/users',
				data : {
					id : id
				},
				headers : {
					'Content-type' : 'application/json;charset=utf-8'
				}
			}).then(function(response) {
				self.doGetUsers();
			});
		}

		$scope.doEditUser = function(id) {
			for (var i = 0; i < $scope.users.length; i++) {
				if ($scope.users[i].id === id) {
					$scope.user = $scope.users[i];
					break;
				}
			}
		}

		self.createUser = function() {
			$http({
				method : 'POST',
				url : '/users',
				data : $scope.user,
				headers : {
					'Content-type' : 'application/json;charset=utf-8'
				}
			}).then(function(response) {
				self.doGetUsers();
			});
		}

		self.updateUser = function() {
			$http({
				method : 'PUT',
				url : '/users',
				data : $scope.user,
				headers : {
					'Content-type' : 'application/json;charset=utf-8'
				}
			}).then(function(response) {
				self.doGetUsers();
			});
		}

		$scope.doSubmit = function() {
			if (angular.isDefined($scope.user.id)) {
				self.updateUser();
			} else {
				self.createUser();
			}
		}

		$scope.reset = function() {
			$scope.user = {
				gender : 'M'
			};
			$scope.userForm.$setPristine();
		}

		function init() {
			self.doGetUsers();
		}
		init();

	};

	angularApp.controllers.controller('UserController', [ '$scope', '$http', UserController ]);
})();