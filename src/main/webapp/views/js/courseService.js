'use strict';
var courseService = angular.module('courseServices',['ngResource']);

courseService.factory('courseService',function($resource){
    return $resource('/course/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})


