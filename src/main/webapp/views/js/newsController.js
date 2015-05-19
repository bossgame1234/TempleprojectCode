/**
 * Created by Dell on 17/4/2558.
 */
'use strict';
var newsMainController = angular.module('newsMainController', ['newsServices']);

newsMainController.controller('addNewsController', ['$scope', '$http', '$location', '$rootScope','newsService',
    function ($scope, $http, $location, $rootScope,newsService) {
        var data = newsService.query(function(){
            $scope.allNews = data;
            $location.path("Newspage");
        });

        $scope.addNews = false;
        $scope.editNews = true;
        var id = $routeParams.id;
        $scope.addNews = function (flowFiles) {
            flowFiles.opts.target = '/picture/addNewsPicture';
            flowFiles.opts.testChunks = false;
            flowFiles.opts.query ={newsid:newsid};
            flowFiles.upload();
            $scope.$apply();
            $rootScope.editSuccess = true;
            $scope.alert("สำเร็จ");
            $location.path("Newspage/"+id);
        };
    }]);

newsMainController.controller('editNewsController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','newsService',
    function ($scope, $http, $routeParams, $location, $rootScope,newsService) {
        $scope.addNews = false;
        $scope.editNews = true;
        $scope.selections = ['id-1'];

        $scope.items = [{
            id: 'id-1',
            name: 'กิจกรรมประจำวัน'},
            {id: 'id-2', name: 'กิจกรรมช่วงพิเศษ'}];
        $scope.check = {};
        $scope.news = {newsId:'',newsName:'',newsDate:'',newsTime:'',newsPlace:'',newsPictureLocation:'',check:''};
        if($routeParams.id!=undefined) {
        var id = $routeParams.id;
        $http.get("/news/" + id).success(function (data) {
            $scope.news = data;
        });
        }
        $scope.editNews = function (flowFiles) {
            newsService.update($scope.news,function(data){
                var newsid = data.newsId;
                flowFiles.opts.target = '/picture/addNewsPicture';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={newsid:newsid};
                flowFiles.upload();
                $scope.$apply();
                alert("สำเร็จ");
                $location.path("Newspage");
            });
        }
    }]);

newsMainController.controller('listNewsController', ['$scope', '$http', '$rootScope','newsService', '$location',
    function ($scope, $http, $rootScope,newsService, $location) {
        var data = newsService.query(function(){
            $scope.allNews = data;
            $location.path("Newspage");
        });



    }]);