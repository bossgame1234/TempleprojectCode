'use strict';

// Declare app level module which depends on views, and components
var templeApp = angular.module('templeApp', [
'ngRoute',
'InformationMainController',
'flow',
'angularFileUpload',
 'userMainController'
]);
templeApp.config(['flowFactoryProvider', function (flowFactoryProvider) {
    flowFactoryProvider.defaults = {
        target: 'upload',
        permanentErrors: [500, 501],
        maxChunkRetries: 1,
        chunkRetryInterval: 5000,
        simultaneousUploads: 1
    };
    flowFactoryProvider.on('catchAll', function (event) {
        console.log('catchAll', arguments);
    });
    // Can be used with different implementations of Flow.js
    flowFactoryProvider.factory = fustyFlowFactory;
}]);
templeApp.config(['$routeProvider',
function($routeProvider) {
$routeProvider.
when('/Homepage',{
templateUrl: 'template/Home.html',
controller: 'showHomepageInformationController'
}).
when('/News',{
        templateUrl: 'template/admin/uploadActivity.html',
        controller: 'uploadImageController'
    }).
otherwise({redirectTo: '/Homepage'});
}]);
