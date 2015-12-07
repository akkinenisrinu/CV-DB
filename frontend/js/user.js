angular.module('myApp', [])
    .controller('userCtrl', function($scope, $http) {

        $scope.addUser = function(user) {
            $http.put('/api/user', user).then(function(response) {
            });
        }
    });