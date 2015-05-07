/**
 * Created by SONY on 2/5/2558.
 */
'use strict';

var contactMainController = angular.module('contactMainController', ['contactServices']);

contactMainController.controller('addContactController', ['$scope', '$http', '$location', '$rootScope','contactService',
    function ($scope, $http, $location, $rootScope,contactService) {
        $scope.contact = {};
        $scope.addContact = true;
        $scope.editContact = false;
        $scope.addContact = function () {
            contactService.save($scope.contact,function(){
                $rootScope.addSuccess = true;
                $location.path("Contactpage");

            });
        };


    }]);

contactMainController.controller('listContactController', ['$scope', '$http', '$rootScope','contactService', '$location',
    function ($scope, $http, $rootScope,contactService,$location) {
        $http.get("/Contact").success(function(data){
            $scope.contact = data;
            $location.path("Contactpage");
        });
    }]);

contactMainController.controller('editContactController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','contactService',
    function ($scope, $http, $routeParams, $location, $rootScope,contactService) {
        $scope.editContact = true;
        $http.get("/Contact").success(function (data) {
            $scope.contact = data;
        });

        $scope.editContact = function () {
            contactService.update({id:$scope.contact.id},$scope.contact,function(){
                $rootScope.editSuccess = true;
                $location.path("Contactpage");
            });
        }
    }]);
