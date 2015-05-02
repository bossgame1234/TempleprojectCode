/**
 * Created by SONY on 2/5/2558.
 */
'use strict';
var questionService = angular.module('questionServices',['ngResource']);

questionService.factory('questionService',function($resource){
    return $resource('/question/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})