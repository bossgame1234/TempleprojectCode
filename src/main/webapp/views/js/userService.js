
    'use strict';
    var userService = angular.module('userServices',['ngResource']);
    userService.factory('userService',function($resource){
    return $resource('/user/:state', { }, {
        update: {
            method: 'GET' // this method issues a PUT request
        },
        findUser: {
            params:{ 'state' :'verifyusername'},
            method: 'GET'
        }
    });
    });



