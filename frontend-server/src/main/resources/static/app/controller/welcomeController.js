'use strict';
(function () {
    var WelcomeController = function ($scope) {
        $scope.date;

        function init() {
            $scope.date = new Date();
        };
        init();
    };

    angularApp.controllers.controller('WelcomeController', ['$scope', '$http', 'AuthService', WelcomeController]);
})();