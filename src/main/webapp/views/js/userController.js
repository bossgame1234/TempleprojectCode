/**
 * Created by Dell on 1/4/2558.
 */
'use strict';
var userMainController = angular.module('userMainController', ['userServices']);

userMainController.controller('addUserController', ['$scope', '$http', '$location', '$rootScope','userService',
    function ($scope, $http, $location, $rootScope,userService) {
        $scope.confirmPassError=false;
        $scope.duplicateUser=false;
        $scope.password2 ="";
        $scope.user = {f_name:'',l_name:'',username:'',password:''};
        $scope.addUser = true;
        $scope.editUser = false;
        $scope.addUser = function () {
            $http.get("/user/" + $scope.user.username).success(function (data) {
                if(data.username==undefined){
                    if($scope.password2==$scope.user.password) {
                        userService.save($scope.user, function (data) {
                            // after adding the object, add a new picture
                            // get the product id which the image will be added
                            var userid = data.id;
                            // set location
                            $rootScope.addSuccess = true;
                            $location.path("loginpage");
                            $scope.$apply();
                        });
                    }else{
                        $scope.confirmPassError=true;
                        $location.path("register")
                    }
                }else{
                    $scope.duplicateUser=true;
                }
            })
    }
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