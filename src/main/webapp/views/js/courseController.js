'use strict';

var courseMainController = angular.module('courseMainController', ['courseServices']);

courseMainController.controller('addCourseController', ['$scope', '$http', '$location', '$rootScope','courseService',
function ($scope, $http, $location, $rootScope,courseService) {
$scope.course = {};
$scope.addPerson = true;
$scope.editPerson = false;
$scope.addCourse = function () {

//$http.post("/Course", $scope.Course).success(function () {
courseService.save($scope.course,function(){
$rootScope.addSuccess = true;
$location.path("listCourse");

});
};


}]);

courseMainController.controller('listCourseController', ['$scope', '$http', '$rootScope','courseService', '$location',
function ($scope, $http, $rootScope,courseService, $location) {
//$http.get("/Course/").success(function (data) {
var data = courseService.query( function(){
$scope.courses = data;
});
    $scope.getCourseFromID = function(){
        $http.get("/course/search/"+$scope.CourseId+"&&"+$scope.CourseName).success(function(data) {
            $scope.courses = data;
        })
    };
$scope.$on('$locationChangeStart', function (event) {
$rootScope.addSuccess = false;
$rootScope.editSuccess = false;
$rootScope.deleteSuccess = false;
});

$scope.deleteCourse = function (id) {
var answer = confirm("Do you want to delete the Course?");
if (answer) {
courseService.delete({id:id},function(){
$rootScope.deleteSuccess = true;
    $location.path("listCourse");
});
}
}

}]);

courseMainController.controller('editCourseController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','courseService',
function ($scope, $http, $routeParams, $location, $rootScope,courseService) {
$scope.addPerson = false;
$scope.editPerson = true;
var id = $routeParams.id;
$http.get("/course/" + id).success(function (data) {
$scope.course = data;
});

$scope.editCourse = function () {
//$http.put("/Course", $scope.Course).then(function () {
courseService.update({id:$scope.course.id},$scope.course,function(){
$rootScope.editSuccess = true;
$location.path("listCourse");
});
}
}]);