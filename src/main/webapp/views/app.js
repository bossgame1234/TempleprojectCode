'use strict';

// Declare app level module which depends on views, and components
var templeApp = angular.module('templeApp', [
    'ngRoute',
    'angularFileUpload',
    'userMainController',
    'historyMainController',
    'flow',
    'securityControllers',
    'galleryMainController',
    'contactMainController',
    'questionMainController',
    'newsMainController',
    'userMainController'
]);

templeApp.config(['$routeProvider',
function($routeProvider) {
$routeProvider.
    when('/Homepage',{
        templateUrl: 'template/Home.html',
        controller:'HomePictureController'
    }).
    when('/editHome',{
        templateUrl: 'template/editHome.html',
        controller: 'editGalleryController'
    }).
    when('/Loginpage',{
        templateUrl: 'template/Login.html',
        controller: 'loginController'
    }).
    when('/Newspage',{
        templateUrl: 'template/News.html',
        controller: 'listNewsController'
    }).
    when('/detailNews/:id',{
        templateUrl: 'template/detailNews.html',
        controller: 'editNewsController'
    }).
    when('/editNews',{
        templateUrl: 'template/editNews.html',
        controller: 'editNewsController'
    }).
    when('/addNews',{
        templateUrl: 'template/editNews.html',
        controller: 'addNewsController'
    }).
    when('/sendNews',{
        templateUrl: 'template/Newspage.html',
        controller: 'sendNewsController'
    }).
    when('/Historypage',{
        templateUrl: 'template/History.html',
        controller: 'listHistoryController'
    }).
    when('/editHistory',{
        templateUrl: 'template/editHistory.html',
        controller: 'editHistoryController'
    }).
    when('/addQuestion',{
        templateUrl: 'template/Question.html',
        controller: 'addQuestionController'
    }).
    when('/Questionpage',{
        templateUrl: 'template/Question.html',
        controller: 'listQuestionController'
    }).
    when('/Answerpage', {
        templateUrl: 'template/Answer.html',
        controller: 'listQuestionControllerAdmin'
    }).
    when('/OwnQuestionpage',{
        templateUrl: 'template/ownquestion.html',
        controller: 'ownQuestionController'
    }).
    when('/Mappage',{
        templateUrl: 'template/Map.html',
        controller: ''
    }).
    when('/Contactpage',{
        templateUrl: 'template/Contact.html',
        controller: 'listContactController'
    }).
    when('/editContact',{
        templateUrl: 'template/editContact.html',
        controller: 'editContactController'
    }).
    when('/Gallerypage',{
        templateUrl: 'template/Gallery.html',
        controller: 'listGalleryController'
    }).
    when('/Picturepage/:id',{
        templateUrl: 'template/Picture.html',
        controller: 'editGalleryController'
    }).
<<<<<<< HEAD
    when('/addPicture/:id',{
        templateUrl: 'template/Picture.html',
=======
    when('/addPicture/:id', {
        templateUrl: 'template/editPicture.html',
>>>>>>> 664ae539aa809dcf93042250885c6fac1fc3240c
        controller: 'addPictureController'
    }).
    when('/editGallery',{
        templateUrl: 'template/editGallery.html',
        controller: 'addGalleryController'
    }).

    when('/register',{
        templateUrl: 'template/register.html',
        controller:   'addUserController'
    }).
    when('/setting',{
        templateUrl: 'template/setting.html',
        controller: 'editUserController'
    }).

otherwise({redirectTo: '/Loginpage'});
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

templeApp.config(['$locationProvider','$httpProvider',function($locationProvider,$httpProvider){
    $httpProvider.interceptors.push(function($q,$rootScope,$location){
        return {
            'responseError' : function(rejection){
                var status = rejection.state;
                var config = rejection.config;
                var method = config.method;
                var url    = config.url;

                if(status ==401){
                    $location.path("Loginpage");
                }else{
                    $rootScope.error = method + " on " + url + " failed with status "+status;

                }
                return $q.reject(rejection);
            }
        }
    });
    var exampleAppConfig = {
        userAuthTokenHeader: true
    };

    $httpProvider.interceptors.push(function($q,$rootScope,$location){
        return {
            'request' : function(config){
                if(angular.isDefined($rootScope.authToken)){
                    var authToken  = $rootScope.authToken;
                    if(exampleAppConfig.userAuthTokenHeader){
                        config.headers['X-Auth-Token'] = authToken;
                    }else{
                        config.url =config.url +"?token="+authToken;
                    }
                }
                return config || $q.when(config);
            }
        }
    })
}]).run(function($rootScope,$location,$cookieStore,UserService) {
    $rootScope.$on('$viewContentLoaded', function () {
        delete $rootScope.error;
    });


    var originalPath = $location.path();
    //$location.path("/Loginpage");
    var authToken = $cookieStore.get('authToken');
    if (authToken != undefined) {
        $rootScope.authToken = authToken;
        UserService.get(function (user) {
            $rootScope.user = user;
            $location.path(originalPath);
        })
    }
    $rootScope.initialized = true;

    $rootScope.hasRole = function(role){
        if($rootScope.user == undefined){
            return false;
        }
        if($rootScope.user.roles[role] == undefined){
            return false;
        }
        return $rootScope.user.roles[role];
    }

    $rootScope.logOut = function(){
        delete $rootScope.authToken;
        delete $rootScope.user;
        $cookieStore.remove('authToken');
        $location.path("/Loginpage");
    }
});

templeApp.config(['$compileProvider', function($compileProvider) {
    $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|file|data):/);
  }]);
