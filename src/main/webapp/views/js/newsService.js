/**
 * Created by SONY on 2/5/2558.
 */
'use strict';
var newsService = angular.module('newsServices',['ngResource']);

newsService.factory('newsService',function($resource){
    return $resource('/news/:state', {}, {
        update: {
            params:{ 'state' :'add'},
            method: 'GET' // this method issues a PUT request
        }});
})