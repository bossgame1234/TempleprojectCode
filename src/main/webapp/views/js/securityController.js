/**
 * Created by Dell on 2/5/2558.
 */
'use strict';
var securityController = angular.module('securityControllers',['securityServices','ngCookies']);
securityController.controller('loginController',['$scope','$rootScope','$location','$cookieStore','UserService',function($scope,$rootScope,$location,$cookieStore,UserService){
    $scope.rememberMe = false;
    $scope.login = function(){
        UserService.authenticate($.param({username:$scope.username,password:$scope.password}),

            function(authenticationResult){
                var authToken = authenticationResult.token;
                $rootScope.authToken = authToken;
                if($scope.rememberMe){
                    $cookieStore.put('authToken',authToken);
                }
                UserService.get(function(user){
                    $rootScope.user = user;
                    $location.path("Homepage")
                })
            })
    }
    $scope.logout = function(){
        $rootScope.user = null;
        $cookieStore.remove('authToken');
        $location.path("Loginpage")
    }
}])
var securityService = angular.module('securityServices',['ngResource']);
securityService.factory('UserService',function($resource){
    return $resource('user/:action',{}, {
        authenticate: {
            method: 'POST',
            params: {'action': 'authenticate'},
            header: {'Content-Type': 'application/x-www-form-urlencoded'}
        }
    })
})
