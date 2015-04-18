/**
 * Created by Dell on 1/4/2558.
 */
'use strict';
var informationService = angular.module('informationServices',['ngResource']);

informationService.factory('informationService',function($resource){
    return $resource('/information/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})

