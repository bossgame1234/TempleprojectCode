/**
 * Created by SONY on 2/5/2558.
 */
'use strict';

var answerMainController = angular.module('answerMainController', ['answerServices']);

answerMainController.controller('addAnswerController', ['$scope', '$http', '$location', '$rootScope','answerService',
    function ($scope, $http, $location, $rootScope,answerService) {
        $scope.answer = {};
        $scope.addAnswer = true;
        $scope.editAnswer = false;
        $scope.addAnswer = function () {
            answerService.save($scope.answer,function(){
                $rootScope.addSuccess = true;
                $location.path("Answerpage");

            });
        };


    }]);

answerMainController.controller('listAnswerController', ['$scope', '$http', '$rootScope','answerService', '$location',
    function ($scope, $http, $rootScope,answerService,$location) {
        var data = answerService.query( function(){
            $scope.answers = data;
        });

        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });

        $scope.deleteAnswer = function (id) {
            var answer = confirm("Do you want to delete the Answer?");
            if (answer) {
                answerService.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    $location.path("Answerpage");
                });
            }
        }
    }]);

answerMainController.controller('editAnswerController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','answerService',
    function ($scope, $http, $routeParams, $location, $rootScope,answerService) {
        $scope.addAnswer = false;
        $scope.editAnswer = true;
        var id = $routeParams.id;
        $http.get("/answer/" + id).success(function (data) {
            $scope.answer = data;
        });

        $scope.editAnswer = function () {
            answerService.update({id:$scope.answer.id},$scope.answer,function(){
                $rootScope.editSuccess = true;
                $location.path("Answerpage");
            });
        }
    }]);
