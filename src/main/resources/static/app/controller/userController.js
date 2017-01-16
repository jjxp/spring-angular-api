'use strict';
(function() {
    var UserController = function($scope, $http) {
        $scope.users = [],
        $scope.user = {gender:'M'};
        var me = this;
         
        me.doGetUsers = function(){
        	$http.get('/users')
            .then(function(response) {
                $scope.users = response.data;
            });

        }
         
        $scope.doDeleteUser = function(id){
        	$http({
        	    method: 'DELETE',
        	    url: '/users',
        	    data: {
        	        id: id
        	    },
        	    headers: {
        	        'Content-type': 'application/json;charset=utf-8'
        	    }
        	})
        	.then(function(response) {
        	    me.doGetUsers();
        	});
        }
         
        $scope.doEditUser = function(id){
            for (var i = 0; i < $scope.users.length; i++) {
                if($scope.users[i].id === id){
                    $scope.user = $scope.users[i];
                    break;
                }
            }
        }
         
        me.createUser = function(){
        	$http({
        	    method: 'POST',
        	    url: '/users',
        	    data: $scope.user,
        	    headers: {
        	        'Content-type': 'application/json;charset=utf-8'
        	    }
        	})
        	.then(function(response) {
        	    me.doGetUsers();
        	});
        }
         
        me.updateUser = function(){
        	$http({
        	    method: 'PUT',
        	    url: '/users',
        	    data: $scope.user,
        	    headers: {
        	        'Content-type': 'application/json;charset=utf-8'
        	    }
        	})
        	.then(function(response) {
        	    me.doGetUsers();
        	});
        }
         
        $scope.doSubmit = function(){
            if(angular.isDefined($scope.user.id)){
                me.updateUser();
            }else{
                me.createUser();
            }
        }
         
        $scope.reset = function(){
            $scope.user = {gender:'M'};
            $scope.userForm.$setPristine();
        }
         
        function init() {
            me.doGetUsers();
        }
        init();
         
    };
 
    myApp.controllers.controller('UserController', [ '$scope', '$http', 'GenericFactory', UserController ]);
})();