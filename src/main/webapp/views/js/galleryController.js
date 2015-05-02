/**
 * Created by SONY on 2/5/2558.
 */
'use strict';

var galleryMainController = angular.module('courseMainController', ['courseServices']);

galleryMainController.controller('addGalleryController', ['$scope', '$http', '$location', '$rootScope','galleryService',
    function ($scope, $http, $location, $rootScope,galleryService) {
        $scope.gallery = {};
        $scope.addGallery = true;
        $scope.editGallery = false;
        $scope.addGallery = function () {

            galleryService.save($scope.gallery,function(){
                $rootScope.addSuccess = true;
                $location.path("Gallerypage");

            });
        };


    }]);

galleryMainController.controller('listGalleryController', ['$scope', '$http', '$rootScope','galleryService', '$location',
    function ($scope, $http, $rootScope,galleryService, $location) {
        var data = galleryService.query( function(){
            $scope.galleries = data;
        });
        $scope.getGalleryFromID = function(){
            $http.get("/gallery/search/"+$scope.GalleryId+"&&"+$scope.GalleryName).success(function(data) {
                $scope.courses = data;
            })
        };
    }]);

galleryMainController.controller('editGalleryController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','galleryService',
    function ($scope, $http, $routeParams, $location, $rootScope,galleryService) {
        $scope.addGallery = false;
        $scope.editGallery = true;
        var id = $routeParams.id;
        $http.get("/gallery/" + id).success(function (data) {
            $scope.gallery = data;
        });

        $scope.editGallery = function () {
            galleryService.update({id:$scope.gallery.id},$scope.gallery,function(){
                $rootScope.editSuccess = true;
                $location.path("Gallerypage");
            });
        }
    }]);