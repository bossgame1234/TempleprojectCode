/**
 * Created by SONY on 2/5/2558.
 */
'use strict';
var contactService = angular.module('contactServices',['ngResource']);

contactService.factory('contactService',function($resource){
    return $resource('/contact/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

});