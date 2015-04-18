'use strict';

var InformationMainController = angular.module('InformationMainController', ['informationServices']);

InformationMainController.controller('showHomepageInformationController', ['$scope', '$http', '$location', '$rootScope','informationService',
function(){}

]);
InformationMainController.controller('uploadImageController', ['$scope', '$http','$upload', '$location', '$rootScope','informationService',
    function($scope, $http,$upload) {
        $scope.$watch('files', function () {
            $scope.upload($scope.files);
        });

        $scope.upload = function (files) {
            if (files && files.length) {
                for (var i = 0; i < files.length; i++) {
                    var file = files[i];
                    $upload.upload({
                        url: 'upload/url',
                        fields: {'username': $scope.username},
                        file: file
                    }).progress(function (evt) {
                        var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                        console.log('progress: ' + progressPercentage + '% ' + evt.config.file.name);
                    }).success(function (data, status, headers, config) {
                        console.log('file ' + config.file.name + 'uploaded. Response: ' + data);
                    });
                }
            }
        };
    }

]);
