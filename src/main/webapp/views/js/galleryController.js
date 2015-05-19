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
                flowFiles.opts.target = '/picture/addGalleryPicture';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={galleryid:galleryid};
                flowFiles.upload();

                $rootScope.addSuccess = true;
                $location.path("Gallerypage");
                $scope.$apply();
                alert("สำเร็จ");
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
        $scope.deletePicture = function(id){
            var answer = confirm("คุณต้องการที่จะลบรูปภาพนี้?");
            if (answer) {
                $scope.gallery.pictureList = null;
                galleryService.deletePicture({id: id}, $scope.gallery, function () {
                    $rootScope.deleteSuccess = true;
                    alert("สำเร็จ");
                    $location.path("Picturepage/"+$scope.gallery.galleryid);
                });
            }
        }


        $scope.editGallery = function () {
            galleryService.update({id:$scope.gallery.galleryId},$scope.gallery,function(){
                $rootScope.editSuccess = true;
                alert("สำเร็จ");
                $location.path("Gallerypage");
            });
        }
    }]);
galleryMainController.controller('addPictureController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','galleryService',
    function ($scope, $http, $routeParams, $location, $rootScope,galleryService) {
        $scope.editPicture = function (flowFiles) {
            var id = $routeParams.id;
                flowFiles.opts.target = '/picture/addGalleryPicture';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={galleryid:id};
                flowFiles.upload();
                $scope.$apply();
                $rootScope.editSuccess = true;
                $location.path("Picturepage/"+id);
                 alert("สำเร็จ");
            };
    $scope.editHomePicture = function (flowFiles) {
        flowFiles.opts.target = '/picture/addGalleryPicture';
        flowFiles.opts.testChunks = false;
        flowFiles.opts.query ={galleryid:1};
        flowFiles.upload();
        $scope.$apply();
        $rootScope.editSuccess = true;
        $location.path("Homepage");
        alert("สำเร็จ");
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
