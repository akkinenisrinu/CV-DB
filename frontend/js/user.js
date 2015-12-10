angular.module('myApp', [])
    .controller('userCtrl', function($scope, $http) {

        $scope.addUser = function(user) {
            $http.put('/api/user', user).then(function(response) {
                alert("Mr." + user.firstName + " " + user.lastName + "!!! Your are registered as " + user.designation);
                window.location.assign("index.html")
            });
        }

        $scope.verifyUser = function(user) {
            $http.post('/api/user', user).then(function(response) {
                //alert("Login Successful");
                window.location.assign("userpage.html")
            }, function (response){
                alert("Login Fail, Please check the Credentials");
                });
        }

    });
