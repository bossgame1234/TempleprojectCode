/**
 * Created by SONY on 2/5/2558.
 */
'use strict';
var questionService = angular.module('questionServices',['ngResource']);

questionService.factory('questionService',function($resource){
    return $resource('/Question/:id/:state', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        },
        getQuestion:{
          method: 'GET',
            params:{ 'state' :'admin'},
            isArray : true
        }

    });


})