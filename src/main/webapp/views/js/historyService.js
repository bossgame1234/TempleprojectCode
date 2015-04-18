/**
 * Created by Dell on 17/4/2558.
 */
'use strict';
var historyService = angular.module('historyServices',['ngResource']);

historyService.factory('historyService',function($resource){
    return $resource('/history/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})