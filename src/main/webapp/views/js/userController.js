/**
 * Created by Dell on 1/4/2558.
 */
'use strict';
var userMainController = angular.module('userMainController', ['userServices']);
userMainController.controller('loginController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','userService',function($http,$scope,$rootScope,userService)
{
$scope.user = {
    username :'',
    password :''
};
$scope.login = function(){
console.log("Hello World");
};
}
]
);