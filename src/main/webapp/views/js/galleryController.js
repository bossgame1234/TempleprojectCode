/**
 * Created by SONY on 2/5/2558.
 */
'use strict';

var galleryMainController = angular.module('galleryMainController', ['galleryServices']);

galleryMainController.controller('addGalleryController', ['$scope', '$http', '$location', '$rootScope','galleryService',
    function ($scope, $http, $location, $rootScope,galleryService) {
        $scope.gallery = {};
        $scope.addGallery = true;
        $scope.editGallery = false;
        $scope.addGallery = function (flowFiles) {
            galleryService.save($scope.gallery,function(data){
                var galleryid = data.galleryId;
                console.log(galleryid);
                // set location
                flowFiles.opts.target = '/picture/addGalleryPicture';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={galleryid:galleryid};
                flowFiles.upload();

                $rootScope.addSuccess = true;
                $location.path("Gallerypage");
                $scope.$apply();
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
            galleryService.update({id:$scope.gallery.galleryId},$scope.gallery,function(){
                $rootScope.editSuccess = true;
                $location.path("Gallerypage");
            });
        }
    }]);
galleryMainController.controller('addPictureController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','galleryService',
    function ($scope, $http, $routeParams, $location, $rootScope,galleryService) {
        var id = $routeParams.id;
        $scope.editPicture = function (flowFiles) {
                flowFiles.opts.target = '/picture/addGalleryPicture';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={galleryid:id};
                flowFiles.upload();
                $scope.$apply();
                $rootScope.editSuccess = true;
                $location.path("Picturepage/"+id);
            };
        }
    ]);
galleryMainController.controller('HomePictureController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','galleryService',
    function ($scope, $http, $routeParams, $location, $rootScope,galleryService) {
        var id = 1;
        $http.get("/gallery/" + id).success(function (data) {
            $scope.HomeGallery = data;
        });
    }]);
