'use strict';
(function() {
	angularApp.controllers.config([ '$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {
            controller : 'UserController',
            templateUrl : '/app/view/user/users.html'
        }).when('/apiDoc', {
            templateUrl: 'app/view/api/api.html',
            controller: 'ApiDocController'
        }).otherwise('/');
    } ]);
})();