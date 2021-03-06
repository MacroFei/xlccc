<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>智能灌溉管理系统后台</title>

    <link href="css/style.default.css" rel="stylesheet">
    <script src="user_js/cookie.js"></script>
    <script src="user_js/login.js"></script>
</head>

<body class="signin">





<section>

    <div class="panel panel-signin">
        <div class="panel-body">
            <h3 class="text-center mb5">智能灌溉管理系统</h3>

            <div class="mb30"></div>

            <form action="signin.html" method="post" id="adminlogin">
                <div class="input-group mb15">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input type="text" class="form-control" placeholder="Username" id="userName">
                </div><!-- input-group -->
                <div class="input-group mb15">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input type="password" class="form-control" placeholder="Password" id="password">
                </div><!-- input-group -->

                <div class="clearfix">
                    <div class="pull-left">
                        <div class="ckbox ckbox-primary mt10">
                            <input type="checkbox" id="rememberMe" value="1">
                            <label for="rememberMe">记住我</label>
                        </div>
                    </div>
                </div>
            </form>

        </div><!-- panel-body -->
        <div class="panel-footer">
            <a class="btn btn-primary btn-block" onclick="javascript:login();">登录</a>
        </div><!-- panel-footer -->
    </div><!-- panel -->

</section>


<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/pace.min.js"></script>
<script src="js/retina.min.js"></script>
<script src="js/jquery.cookies.js"></script>

<script src="js/custom.js"></script>

</body>
</html>

