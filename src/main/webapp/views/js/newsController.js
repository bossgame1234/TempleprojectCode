/**
 * Created by Dell on 17/4/2558.
 */
'use strict';
var newsMainController = angular.module('newsMainController', ['newsServices']);

newsMainController.controller('addNewsController', ['$scope', '$http', '$location', '$rootScope','newsService',
    function ($scope, $http, $location, $rootScope,newsService) {

        $scope.addNews = false;
        $scope.editNews = true;
        var id = $routeParams.id;
        $scope.editNews = function (flowFiles) {
            flowFiles.opts.target = '/picture/addNewsPicture';
            flowFiles.opts.testChunks = false;
            flowFiles.opts.query ={newsid:newsid};
            flowFiles.upload();
            $scope.$apply();
            $rootScope.editSuccess = true;
            $location.path("Newspage/"+id);
        };
    }]);

newsMainController.controller('editNewsController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','newsService',
    function ($scope, $http, $routeParams, $location, $rootScope,newsService) {
        $scope.addNews = false;
        $scope.editNews = true;
        var id = $routeParams.id;
        $http.get("/news/" + id).success(function (data) {
            $scope.news = data;
        });

        $scope.editNews = function (flowFiles) {
            newsService.update($scope.news,function(data){
                $scope.news.newsPictureLocation = null;
                var newsid = data.newsID;

                flowFiles.opts.target = '/picture/addNewsPicture';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={newsid:newsid};
                flowFiles.upload();
                $rootScope.editSuccess = true;
                $location.path("Newspage");
                $scope.$apply();
            });
        }
    }]);

newsMainController.controller('sendNewsController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','newsService',
    function ($scope, $http, $routeParams, $location, $rootScope,newsService) {
        $scope.addNews = false;
        $scope.editNews = true;
        var id = $routeParams.id;
        $http.get("/news/" + id).success(function (data) {
            $scope.news = data;
        });


        $scope.sendnews = function () {
            newsService.save($scope.news,function(data){
                $http.get("/sendnew/").success(function (data) {
                    $scope.news = data;
                });

                $rootScope.editSuccess = true;
                $location.path("Newspage");
                $scope.$apply();
            });
        };
    }]);

newsMainController.controller('listNewsController', ['$scope', '$http', '$rootScope','newsService', '$location',
    function ($scope, $http, $rootScope,newsService, $location) {
        var data = newsService.query(function(){
            $scope.allNews = data;
            $location.path("Newspage");
        });



    }]);