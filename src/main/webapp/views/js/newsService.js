/**
 * Created by SONY on 2/5/2558.
 */
'use strict';
var newsService = angular.module('newsServices',['ngResource']);

newsService.factory('newsService',function($resource){
    return $resource('/news/:id', { id: '@_id'}, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})