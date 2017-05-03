'use strict';
(function () {
    var LoginController = function ($scope, $http, $resource, $httpParamSerializer, $cookies) {
        $scope.error = false;

        if ($cookies.get("access_token") != null) {
            $scope.isLoggedIn = true;
        } else {
            $scope.isLoggedIn = false;
        }


        $scope.login = function () {

            $scope.formRequest = {
                grant_type: "password",
                username: $scope.loginCredentials.username,
                password: $scope.loginCredentials.password
            };
            $scope.encoded = btoa("sproutsApp:sproutsAppSecret");

            $cookies.remove("access_token");
            var req = {
                method: 'POST',
                url: "/oauth/token",
                headers: {
                    "Authorization": "Basic " + $scope.encoded,
                    "Content-type": "application/x-www-form-urlencoded; charset=utf-8"
                },
                data: $httpParamSerializer($scope.formRequest)
            }
            $http(req).success(function (data) {
                $http.defaults.headers.common.Authorization =
                    'Bearer ' + data.access_token;
                $cookies.put("access_token", data.access_token);

                $http.get("/authority/get").then(function (data) {
                    $cookies.put("authority", data.data.authority);
                    window.location.href = "/";
                });
            }).error(function (data) {
                $scope.error = true;
            });
        };

        $scope.logout = function () {
            $http.get("/oauth/revoke").then(function () {
                $cookies.remove("authority");
                $cookies.remove("access_token");
            });
            window.location.replace('/');
        };
    };

    angularApp.controllers.controller('LoginController', ['$scope', '$http', '$resource', '$httpParamSerializer', '$cookies', 'AuthService', LoginController]);
})();