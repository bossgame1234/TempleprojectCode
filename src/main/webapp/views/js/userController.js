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
            userService.findUser($scope.user,function(data){if(data.username==undefined){
                if($scope.password2==$scope.user.password) {
                    userService.save($scope.user, function() {
                        $rootScope.addSuccess = true;
                        $location.path("loginpage");
                    });
                }else{
                    $scope.confirmPassError=true;
                    $location.path("register");
                }
            }else{
                $scope.duplicateUser=true;
                $location.path("register");
            }
            });


        }
        }]);

userMainController.controller('editUserController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','userService',
    function ($scope, $http, $routeParams, $location, $rootScope,userService) {
        $scope.addUser = false;
        $scope.editUser = true;
        userService.findUser({username:$rootScope.user.name},function(data) {
        $scope.user =data;

        })

        $scope.editProfile =function() {
            userService.save($scope.user, function() {});
            $location.path("Homepage");
        }


    }]);

userMainController.controller('listUserController', ['$scope', '$http', '$rootScope','userService', '$location',
    function ($scope, $http, $rootScope,userService, $location) {

        var data = userService.query( function(){
            $scope.users = data;
            $location.path("listUser");
        });

    }]);