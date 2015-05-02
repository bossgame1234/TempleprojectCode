
    'use strict';
    var userService = angular.module('userServices',['ngResource']);
    userService.factory('userService',function($resource){
    return $resource('/login/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});
    });



