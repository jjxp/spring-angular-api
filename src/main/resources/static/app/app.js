'use strict';
var angularApp = angularApp || {};
 
(function(){
	angularApp.controllers = angular.module('angularAppControllers', [ 'ngRoute' ]),
	angularApp.app = angular.module('angularApp', [ 'ngRoute', 'angularAppControllers']);
})();