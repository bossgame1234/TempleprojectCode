/**
 * Created by Dell on 17/4/2558.
 */
'use strict';
var historyMainController = angular.module('historyMainController', ['historyServices']);


historyMainController.controller('editHistoryController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','historyService',
    function ($scope, $http, $routeParams, $location, $rootScope,historyService) {
        $scope.addHistory = false;
        $scope.editHistory = true;
        $http.get("/History").success(function (data) {
            $scope.history = data;
        });

        $scope.editHistory = function () {

            $scope.history.historyPictureLocation = null;
            historyService.save($scope.history,function(data){
                $rootScope.editSuccess = true;
                $location.path("Historypage");
            });
        };
    }]);

historyMainController.controller('listHistoryController', ['$scope', '$http', '$rootScope','historyService', '$location',
    function ($scope, $http, $rootScope,historyService, $location) {
         $http.get("/History").success(function(data){
             $scope.history = data;
             $location.path("Historypage");
         });
    }]);