/**
 * Created by SONY on 2/5/2558.
 */
'use strict';

var questionMainController = angular.module('questionMainController', ['questionServices']);

questionMainController.controller('addQuestionController', ['$scope', '$http', '$location', '$rootScope','questionService',
    function ($scope, $http, $location, $rootScope,questionService) {
        $scope.question = {};
        $scope.addQuestion = true;
        $scope.editQuestion = false;
        $scope.addQuestion = function () {
            questionService.save($scope.question,function(){
                $rootScope.addSuccess = true;


            });
        };
        $location.path("Questionpage");

        var data = questionService.query( function(){
            $scope.questions = data;
        });

        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });

        $scope.deleteQuestion = function (id) {
            var answer = confirm("Do you want to delete the Question?");
            if (answer) {
                questionService.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    $location.path("Questionpage");
                });
            }
        }


    }]);

questionMainController.controller('listQuestionController', ['$scope', '$http', '$rootScope','questionService', '$location',
    function ($scope, $http, $rootScope,questionService, $location) {
        var data = questionService.query( function(){
            $scope.questions = data;
        });

        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });

        $scope.deleteQuestion = function (id) {
            var answer = confirm("Do you want to delete the Question?");
            if (answer) {
                questionService.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    $location.path("Questionpage");
                });
            }
        }



    }]);

questionMainController.controller('editQuestionController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','questionService',
    function ($scope, $http, $routeParams, $location, $rootScope,questionService) {
        $scope.addQuestion = false;
        $scope.editQuestion = true;
        var id = $routeParams.id;
        $http.get("/Question/" + id).success(function (data) {
            $scope.question = data;
        });

        $scope.editQuestion = function () {
            questionService.update({id:$scope.question.id},$scope.question,function(){
                $rootScope.editSuccess = true;
                $location.path("Questionpage");
            });
        }
    }]);