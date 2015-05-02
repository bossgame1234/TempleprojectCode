/**
 * Created by SONY on 2/5/2558.
 */
'use strict';
var answerService = angular.module('answerServices',['ngResource']);

answerService.factory('answerService',function($resource){
    return $resource('/answer/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

});
