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
        var data = contactService.query( function(){
            $scope.contacts = data;
        });

        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });

        $scope.deleteContact = function (id) {
            var contact = confirm("Do you want to delete the Contact?");
            if (contact) {
                contactService.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    $location.path("Contactpage");
                });
            }
        }
    }]);

contactMainController.controller('editContactController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','contactService',
    function ($scope, $http, $routeParams, $location, $rootScope,contactService) {
        $scope.addContact = false;
        $scope.editContact = true;
        var id = $routeParams.id;
        $http.get("/contact/" + id).success(function (data) {
            $scope.contact = data;
        });

        $scope.editContact = function () {
            contactService.update({id:$scope.contact.id},$scope.contact,function(){
                $rootScope.editSuccess = true;
                $location.path("Contactpage");
            });
        }
    }]);
