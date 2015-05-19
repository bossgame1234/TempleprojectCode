/**
 * Created by SONY on 2/5/2558.
 */
'use strict';
var galleryService = angular.module('galleryServices',['ngResource']);

galleryService.factory('galleryService',function($resource){
    return $resource('/gallery/:state/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        },
        deletePicture:{
            params:{ 'state' :'deletepicture'},
            method: 'PUT'
        }

    });

})


