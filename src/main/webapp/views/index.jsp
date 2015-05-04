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
    <script src="bower_components/html5-boilerplate/js/vendor/modernizr-2.6.2.min.js"></script>
    <script src="bower_components/angular/angular.js"></script>
    <script src="bower_components/angular-route/angular-route.js"></script>
    <script src="bower_components/angular-resource/angular-resource.js"></script>
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
    <script src="bower_components/flow/flow.js"></script>
    <script src="bower_components/flow/ng-flow.js"></script>
    <script src="bower_components/flow/fusty-flow-factory.js"></script>
    <script src="bower_components/flow/fusty-flow.js"></script>
    <script src="bower_components/angular-file-upload/angular-file-upload-shim.js"></script>
    <script src="bower_components/angular-file-upload/angular-file-upload.min.js"></script>
    <script src="app.js"></script   >
    <script src="js/userController.js"></script>
    <script src="js/userService.js"></script>
    <script src="js/historyController.js"></script>
    <script src="js/historyService.js"></script>
    <!-- add i18n script-->

    <script src ="bower_components/angular-translate/angular-translate.js"></script>
    <script src ="bower_components/angular-translate-loader-url/angular-translate-loader-url.js"></script>

</head>
<body flow-prevent-drop flow-drag-enter="dropClass='drag-over'" flow-drag-leave="dropClass=''" >
<div class="page-header"  >
    <div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-3">
       <h1>วัดเจดีย์หลวง</h1>
    </div>
        <!-- ng-app="userMainController" -->
        <!--<div class="col-md-3" ng-controller="loginController" >
            <form name="loginForm" method="post" ng-submit="login()" >
                <div class="form-group" >
                    <label for="username" >ชื่อผู้ใช้งาน</label> :
                    <input ng-model="user.username" class="form-control" id="username" name="username" placeholder="id" required/>
                    <label for="password" >รหัสผ่าน</label> :
                    <input ng-model="user.password" class="form-control" id="password" name="password" placeholder="password" required/>
                    <br>
                    <div class="col-md-6"></div>
                    <button type="submit" class="btn btn-default" >เข้าสู่ระบบ</button>
                    <label>  </label>
                    <br>
                    <br>
                    <div class="col-md-7"></div>
                    <a translate href="#/Register">ลงทะเบียนผู้ใช้งาน</a>
                </div>
            </form>
        </div> -->
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
                    <li ng-class="{true: 'active'}[menuActive('/News')]">
                        <a  href="#/Newspage">ข่าวสาร</a>
                    </li>
                    <li ng-class="{true: 'active'}[menuActive('/News')]">
                        <a href="#/Historypage">ประวัติ</a>
                    </li>
                    <li ng-class="{true: 'active'}[menuActive('/QuestionAnswer)]">
                        <a  href="#/QuestionAnswerpage">ถาม-ตอบธรรมะ</a>
                    </li>
                    <li ng-class="{true: 'active'}[menuActive('/Gallery')]">
                        <a  href="#/Gallerypage">แกลอรี่</a>
                    </li>
                    <li ng-class="{true: 'active'}[menuActive('/Map')]">
                        <a  href="#/Mappage">แผนที่</a>
                    </li>
                    <li ng-class="{true: 'active'}[menuActive('/News')]">
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
