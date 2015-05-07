'use strict';

// Declare app level module which depends on views, and components
var templeApp = angular.module('templeApp', [
'ngRoute',
'angularFileUpload',
'userMainController',
'historyMainController',
'flow',
    'securityControllers'
]);

templeApp.config(['$routeProvider',
function($routeProvider) {
$routeProvider.
when('/Homepage',{
templateUrl: 'template/Home.html',
controller: ''
}).
    when('/Loginpage',{
        templateUrl: 'template/Login.html',
        controller: 'loginController'
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

templeApp.config(['$locationProvider', '$httpProvider', function($locationProvider, $httpProvider){
    /* Register error provider that shows message on failed requests or redirects to login page on
     * unauthenticated requests */
    $httpProvider.interceptors.push(function($q,$rootScope,$location){
        return {
            'responseError': function(rejection){
                var status = rejection.status;
                var config = rejection.config;
                var method = config.method;
                var url = config.url;

                if (status == 401){
                    $location.path("Loginpage");
                }else{
                    $rootScope.error = method + " on " + url + " failed with status " + status;
                }
                return $q.reject(rejection);
            }
        }
    });

    /* Registers auth token interceptor, auth token is either passed by header or by query parameter
     * as soon as there is an authenticated user */
    var exampleAppConfig = {
        /* When set to false a query parameter is used to pass on the auth token.
         * This might be desirable if headers don't work correctly in some
         * environments and is still secure when using https. */
        useAuthTokenHeader: true
    };

    $httpProvider.interceptors.push(function ($q,$rootScope,$location){
        return {
            'request' : function(config){
                if (angular.isDefined($rootScope.authToken)){
                    var authToken = $rootScope.authToken;
                    if (exampleAppConfig.useAuthTokenHeader){
                        config.headers['X-Auth-Token'] = authToken;
                    }else{
                        config.url = config.url + "?token=" + authToken;
                    }
                }
                return config || $q.when(config);
            }

        }
    })

}]).run(function($rootScope,$location,$cookieStore,UserService){
    $rootScope.$on('$viewContentLoaded',function(){
        delete $rootScope.error;
    });

    $rootScope.hasRole = function(role) {
        if ($rootScope.user == undefined){
            return false;
        }

        if ($rootScope.user.roles[role] == undefined){
            return false;
        }

        return $rootScope.user.roles[role];
    }

    $rootScope.logout = function(){
        delete $rootScope.user;
        $cookieStore.remove('authToken');
        $location.path("Loginpage");
    }

    /* Try getting valid user from cookie or go to login page */
    var originalPath = $location.path();
    $location.path("Loginpage");
    var authToken = $cookieStore.get('authToken');
    if (authToken != undefined){
        $rootScope.authToken = authToken;
        UserService.get(function(user){
            $rootScope.user = user;
            $location.path(originalPath);
        })
    }
    $rootScope.initialized = true;
});
