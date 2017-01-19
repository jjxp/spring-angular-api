'use strict';

var angularApp = angular.module('angularApp', [ 'ngRoute', 'angularAppControllers', 'ngSanitize', 'swaggerUi', 'pascalprecht.translate' ]);

angularApp.controllers = angular.module('angularAppControllers', [ 'ngRoute' ]);

angularApp.config([ '$translateProvider', function($translateProvider) {
	$translateProvider.useStaticFilesLoader({
	    files: [{
	        prefix: 'locale-',
	        suffix: '.json'
	    }, {
	        prefix: '/app/view/user/locale-',
	        suffix: '.json'
	    }, {
	        prefix: '/app/view/api/locale-',
	        suffix: '.json'
	    }]
	});
	$translateProvider.preferredLanguage('en');
} ]);

angularApp.controller('languajeController', [ '$translate', '$scope',
		function($translate, $scope) {

			$scope.changeLanguage = function(langKey) {
				$translate.use(langKey);
			};
		} ]);