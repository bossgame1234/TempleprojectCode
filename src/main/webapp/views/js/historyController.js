/**
 * Created by Dell on 17/4/2558.
 */
'use strict';
var historyMainController = angular.module('historyMainController', ['historyServices']);


historyMainController.controller('editHistoryController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','historyService',
    function ($scope, $http, $routeParams, $location, $rootScope,historyService) {
        $scope.flow ={};
        $scope.editHistory = true;
        $http.get("/wat/History").success(function (data) {
            $scope.history = data;
        });

        $scope.editHistory = function (flowFiles) {
            historyService.update($scope.history,function(data){
            $scope.history.historyPictureLocation = null;
            var historyid = data.historyID;
            // set location
            flowFiles.opts.target = '/wat/picture/addHistoryPicture';
            flowFiles.opts.testChunks = false;
            flowFiles.opts.query ={historyid:historyid};
            flowFiles.upload();
                $rootScope.editSuccess = true;
                alert("สำเร็จ");
            $location.path("Historypage");
            $scope.$apply();
        });
        };
    }]);

historyMainController.controller('listHistoryController', ['$scope', '$http', '$rootScope','historyService', '$location',
    function ($scope, $http, $rootScope,historyService, $location) {
         $http.get("/wat/History").success(function(data){
             $scope.history = data;
             $location.path("Historypage");
         });
    }]);