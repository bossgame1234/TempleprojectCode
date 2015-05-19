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
                $location.path("Questionpage");
            });
        };

    }]);

questionMainController.controller('listQuestionController', ['$scope', '$http', '$rootScope','questionService', '$location','$route',
    function ($scope, $http, $rootScope,questionService, $location ,$route) {
        var data = questionService.query( function(){
            $scope.questions = data;
        });
        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });
        $scope.question={username:'',questionDes:''};
        if($rootScope.user!=undefined){
            $scope.question.username= $rootScope.user.name;
        }
        $scope.addQuestion = function (){
            questionService.save($scope.question,function(){
                $rootScope.addSuccess = true;
                alert("สำเร็จ");
                $route.reload();
            });
        };




    }]);
questionMainController.controller('listQuestionControllerAdmin', ['$scope', '$http', '$rootScope','questionService', '$location','$route',
    function ($scope, $http, $rootScope,questionService, $location ,$route) {
        var data = questionService.getQuestion( function(){
            $scope.questions = data;
        });

        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });
        $scope.addAnswer= function(question){
            questionService.save(question,function(){
                $rootScope.addSuccess = true;
                alert("สำเร็จ");
                $route.reload();
            });
        };

        $scope.deleteQuestion = function (id) {
            var answer = confirm("คุณต้องการที่จะลบคำถามนี้?");
                if (answer) {
                questionService.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    alert("สำเร็จ");
                    $route.reload();
                });
            }
        }



    }]);
questionMainController.controller('ownQuestionController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','questionService',
    function ($scope, $http, $routeParams, $location, $rootScope,questionService) {
        $scope.addQuestion = false;
        $scope.editQuestion = true;
        questionService.getOwnQuestion({username:$rootScope.user.name},function(data){
            $scope.questions =data;
        })

        $scope.editQuestion = function () {
            questionService.update({id:$scope.question.id},$scope.question,function(){
                $rootScope.editSuccess = true;
                alert("สำเร็จ");
                $location.path("Questionpage");
            });
        }
    }]);