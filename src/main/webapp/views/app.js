'use strict';

// Declare app level module which depends on views, and components
var templeApp = angular.module('templeApp', [
'ngRoute',
'angularFileUpload',
'userMainController',
'historyMainController',
'flow'
]);

templeApp.config(['$routeProvider',
function($routeProvider) {
$routeProvider.
when('/Homepage',{
templateUrl: 'template/Home.html',
controller: ''
}).
    when('/editHome',{
        templateUrl: 'template/admin/editHome.html',
        controller: ''
    }).
when('/Newspage',{
        templateUrl: 'template/News.html',
        controller: 'listNewsController'
    }).
when('/editNews',{
        templateUrl: 'template/admin/editNews.html',
        controller: 'editNewsController'
    }).
    when('/Historypage',{
        templateUrl: 'template/History.html',
        controller: 'listHistoryController'
    }).
when('/editHistory',{
        templateUrl: 'template/editHistory.html',
        controller: 'editHistoryController'
    }).
    when('/QuestionAnswerpage',{
        templateUrl: 'template/Question-Answer.html',
        controller: ''
    }).
    when('/Questionpage',{
        templateUrl: 'template/admin/Question.html',
        controller: ''
    }).
    when('/Answerpage',{
        templateUrl: 'template/admin/Answer.html',
        controller: ''
    }).
    when('/OwnQuestionpage',{
        templateUrl: 'template/Answer.html',
        controller: ''
    }).
    when('/Mappage',{
        templateUrl: 'template/Map.html',
        controller: ''
    }).
    when('/Contactpage',{
        templateUrl: 'template/Contact.html',
        controller: ''
    }).
    when('/editContactpage',{
        templateUrl: 'template/admin/editContact.html',
        controller: ''
    }).
    when('/Gallerypage',{
        templateUrl: 'template/Gallery.html',
        controller: ''
    }).
    when('/Picturepage',{
        templateUrl: 'template/Picture.html',
        controller: ''
    }).
    when('/uploadGallerypage',{
        templateUrl: 'template/uploadGallery.html',
        controller: ''
    }).
    when('/uploadPicturepage',{
        templateUrl: 'template/uploadPicture.html',
        controller: ''
    }).
otherwise({redirectTo: '/Homepage'});
}]);

templeApp.config(['flowFactoryProvider', function (flowFactoryProvider) {
    flowFactoryProvider.defaults = {
        target: '',
        permanentErrors: [ 500, 501],
        maxChunkRetries: 1,
        chunkRetryInterval: 5000,
        simultaneousUploads: 4,
        singleFile: false
    };
    flowFactoryProvider.on('catchAll', function (event) {
        console.log('catchAll', arguments);
    });
}]);
