/**
 * Created by Dell on 1/4/2558.
 */
'use strict';
var userMainController = angular.module('userMainController', ['userServices']);

userMainController.controller('loginController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','userService',
        function($http,$scope,$rootScope,userService) {
            $scope.user = {
                username: '',
                password: ''
            };
            $scope.login = function () {
                console.log("Hello World");
            };
        }]);

userMainController.controller('addUserController', ['$scope', '$http', '$location', '$rootScope','userService',
    function ($scope, $http, $location, $rootScope,userService) {
        $scope.user = {};
        $scope.addUser = true;
        $scope.editUser = false;
        $scope.addUser = function () {
            userService.save($scope.user,function(data){
                // after adding the object, add a new picture
                // get the product id which the image will be added
                var userid = data.id;
                // set location
                $rootScope.addSuccess = true;
                $location.path("listUser");
                $scope.$apply();
            });
        };
    }]);

userMainController.controller('editUserController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','userService',
    function ($scope, $http, $routeParams, $location, $rootScope,userService) {
        $scope.addUser = false;
        $scope.editUser = true;
        var id = $routeParams.id;
        $http.get("/user/" + id).success(function (data) {
            $scope.user = data;
        });

        $scope.editHistory = function () {
            userService.update({id:$scope.user.id},$scope.user,function(){
                $rootScope.editSuccess = true;
                $location.path("listUser");
            });
        }
    }]);

userMainController.controller('listUserController', ['$scope', '$http', '$rootScope','userService', '$location',
    function ($scope, $http, $rootScope,userService, $location) {
        var data = userService.query( function(){
            $scope.users = data;
            $location.path("listUser");
        });

    }]);