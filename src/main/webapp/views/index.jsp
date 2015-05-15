<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en-US" ng-app="templeApp" >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>วัดเจดีย์หลวง</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bower_components/html5-boilerplate/css/normalize.css">
    <link rel="stylesheet" href="bower_components/html5-boilerplate/css/main.css">
    <link rel="stylesheet" href="app.css">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="css/foundation.min.css">
    <link rel="stylesheet" href="css/ie8-grid-foundation-4.css">
    <link rel="stylesheet" href="css/ie-fixes.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/stylesheet.css">
    <link rel="stylesheet" href="css/superfish.css">
    <link rel="stylesheet" href="css/colorbox.css">
    <link rel="stylesheet" href="css/flexcar.css">
    <link rel="stylesheet" href="css/flexslider.css">
    <link rel="stylesheet" href="css/lightbox.css">

    <link href='http://fonts.googleapis.com/css?family=Quando' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,300' rel='stylesheet' type='text/css'>
    <script src="http://maps.google.com/maps/api/js?sensor=true"></script>

    <script src="bower_components/html5-boilerplate/js/vendor/modernizr-2.6.2.min.js"></script>
    <script src="bower_components/angular/angular.js"></script>
    <script src="bower_components/angular-route/angular-route.js"></script>
    <script src="bower_components/angular-resource/angular-resource.js"></script>
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
    <script src="bower_components/angular-file-upload/angular-file-upload-shim.js"></script>
    <script src="bower_components/angular-file-upload/angular-file-upload.min.js"></script>
    <script src="app.js"></script>
    <script src="js/colorbox/jquery.colorbox-min.js"></script>
    <script src="js/slider/jquery.flexslider.js"></script>
    <script src="js/vendor/custom.modernizr.js"></script>
    <script src="js/lightbox/prototype.js" ></script>
    <script src="js/lightbox/scriptaculous.js?load=effects" ></script>
    <script src="js/lightbox/lightbox.js" ></script>

    <script src="js/userController.js"></script>
    <script src="js/securityController.js"></script>
    <script src="js/userService.js"></script>
    <script src="js/historyController.js"></script>
    <script src="js/historyService.js"></script>
    <script src="js/galleryController.js"></script>
    <script src="js/galleryService.js"></script>
    <script src="js/contactController.js"></script>
    <script src="js/contactService.js"></script>
    <script src="js/questionController.js"></script>
    <script src="js/questionService.js"></script>
<<<<<<< HEAD
=======
    <script src="js/answerController.js"></script>
    <script src="js/answerService.js"></script>
    <script src="js/newsController.js"></script>
    <script src="js/newsService.js"></script>

>>>>>>> 37d44e8079741cf0094e0971239f01cb88029053
    <script src="bower_components/ng-flow/dist/ng-flow-standalone.js"></script>
    <script src="bower_components/angular-cookies/angular-cookies.js"></script>
    <script src ="bower_components/angular-translate/angular-translate.js"></script>
    <script src ="bower_components/angular-translate-loader-url/angular-translate-loader-url.js"></script>
</head>
<body>
<div class="page-header"  >
    <div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-3">
       <h1><img src="picture/logo.png" alt="" class="logo"></h1>
    </div>
    <div class="col-md-12"></div>
    <div class="col-md-12"></div>
    <div class="col-md-1"></div>
    <div class="col-md-11">
    <div role="navigation">
    <nav class="nav nav-pills nav-justified">
        <div class="container-fluid">
            <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                    <li ng-class="{true: 'active'}[menuActive('/Homepage')]">
                        <a  href="#/Homepage">หน้าแรก</a>
                    </li>
                    <li ng-class="{true: 'active'}[menuActive('/Newspage')]">
                        <a  href="#/Newspage">ข่าวสาร</a>
                    </li>
                    <li ng-class="{true: 'active'}[menuActive('/Historypage')]">
                        <a href="#/Historypage">ประวัติ</a>
                    </li>
<<<<<<< HEAD
                    <li ng-class="{true: 'active'}[menuActive('/QuestionAnswer')]">
=======
                    <li ng-class="{true: 'active'}[menuActive('/Questionpage')]">
>>>>>>> 37d44e8079741cf0094e0971239f01cb88029053
                        <a  href="#/Questionpage">ถาม-ตอบธรรมะ</a>
                    </li>
                        <li ng-class="{true: 'active'}[menuActive('/Questionpage')]">
                            <a  href="#/Answerpage">ตอบธรรมะ</a>
                        </li>
                    <li ng-class="{true: 'active'}[menuActive('/Gallerypage')]">
                        <a  href="#/Gallerypage">แกลอรี่</a>
                    </li>
                    <li ng-class="{true: 'active'}[menuActive('/Mappage')]">
                        <a  href="#/Mappage">แผนที่</a>
                    </li>
                    <li ng-class="{true: 'active'}[menuActive('/Contactpage')]">
                        <a  href="#/Contactpage">ติดต่อวัด</a>
                    </li>

                </ul>
        </div>
        </div>

</nav>
    </div>
</div>
</div>
    </div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-1">
        </div>
        <div class="col-md-10">
            <!-- Breadcrumbs
           ================================================== -->
            <ng-view>Loading...</ng-view>

        </div>
    </div>
</div>

</body>
</html>
