<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/3/20
  Time: 02:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>智能灌溉系统后台</title>

    <link href="css/style.default.css" rel="stylesheet">
    <link href="css/morris.css" rel="stylesheet">
    <link href="css/select2.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style.calendar.css" rel="stylesheet">
    <link href="css/reveal.css" rel="stylesheet">

    <script src="http://www.jq22.com/js/jq.js"></script>
    <script src="http://www.jq22.com/jquery/jquery-1.6.2.js"></script>
    <script type="text/javascript" src="js/jquery.reveal.js"></script>
</head>

<body>

<header>
    <div class="headerwrapper">
        <div class="header-left">
            <a href="index.html" class="logo">
                <h4 style="color: #fff;">智能灌溉管理系统后台</h4>
            </a>
        </div><!-- header-left -->
        <div class="header-right">
            <div class="pull-right">
                <form class="form form-search" action="search-results.html">
                    <input type="search" class="form-control" placeholder="Search"/>
                </form>


                <div class="btn-group btn-group-option">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        <img class="img-circle avatar-img" alt="" src="picture/chrome.png">
                        <span class="user-name">admin</span>
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <ul class="dropdown-menu pull-right" role="menu">
                        <li><a href="#"><i class="glyphicon glyphicon-user"></i>个人信息</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-log-out"></i>退出</a></li>
                    </ul>
                </div><!-- btn-group -->

            </div><!-- pull-right -->

        </div><!-- header-right -->

    </div><!-- headerwrapper -->
</header>

<section>
    <div class="mainwrapper">
        <div class="leftpanel">
            <!-- media -->


            <ul class="nav nav-pills nav-stacked">
                <li><a href="index.html"><i class="fa fa-home"></i> <span>主页</span></a></li>
                <li class="parent"><a href="#"><i class="fa fa-suitcase"></i> <span>数据管理</span></a>
                    <ul class="children">
                        <li><a href="data-management.html">农作物信息查看</a></li>
                    </ul>
                </li>
                <li class="parent"><a href="#"><i class="fa fa-edit"></i> <span>设备管理</span></a>
                    <ul class="children">
                        <li><a href="equipment-management.html">分类管理</a></li>
                    </ul>
                </li>
                <li class="parent"><a href="#"><i class="fa fa-bars"></i> <span>灌溉管理</span></a>
                    <ul class="children">
                        <li><a href="irrigation-management.html">灌溉设置</a></li>
                    </ul>
                </li>
                <li class="parent active"><a href="#"><i class="fa fa-file-text"></i> <span>用户管理</span></a>
                    <ul class="children">
                        <li class="active"><a href="user-management.html">管理员管理</a></li>
                    </ul>
                </li>

            </ul>

        </div><!-- leftpanel -->

        <!--body wrapper start-->
        <div class="wrapper" style="min-height: 582px;">

            <div class="task">
                <p style="font-size: 22px;float: left;margin-left: 6%;position: absolute;margin-top: -1em;">灌溉信息编辑：</p>
            </div>

            <br>
            <form method="post" action="user_update">
                <div class="modal-body" style="margin-bottom: 1em;">
                    <form class="form-horizontal" role="form">
                        <div class="form-group" style="margin-top: -6.5em;margin-bottom: 0.5em;">
                            <label class="col-sm-3 control-label"
                                   style="line-height: 1em;margin-left: -6em;margin-top: 2em;">用户名：</label>
                            <div class="col-sm-9" style="margin-top: 1.5em;">
                                <input type="text" class="form-control" name="name" value="${u.name}">
                            </div>
                        </div>

                        <div class="form-group" style="margin-top: 0em;margin-bottom: 0.5em;">
                            <label class="col-sm-3 control-label"
                                   style="line-height: 1em;margin-left: -6em;margin-top: 1em;">性别：</label>
                            <div class="col-sm-9" style="margin-top: 1.5em;">
                                <input type="text" class="form-control" name="sex" value="${u.sex}">
                            </div>
                        </div>

                        <div class="form-group" style="margin-top: 0em;margin-bottom: 0.5em;">
                            <label class="col-sm-3 control-label"
                                   style="line-height: 1em;margin-left: -6em;margin-top: 1em;">手机：</label>
                            <div class="col-sm-9" style="margin-top: 1em;">
                                <input type="text" class="form-control" name="phone" value="${u.phone}">
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 0em;margin-bottom: 0.5em;">
                            <label class="col-sm-3 control-label"
                                   style="line-height: 1em;margin-left: -6em;margin-top: 1em;">邮箱：</label>
                            <div class="col-sm-9" style="margin-top: 1em;">
                                <input type="text" class="form-control" name="email" value="${u.email}">
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                            <label  class="col-sm-3 control-label"
                                   style="line-height: 1em;margin-left: -6em;margin-top: 1em;">所属地区：</label>
                            <div class="col-sm-9" style="margin-top: 1em;">
                                <input type="text" class="form-control" name="area" value="${u.area}">
                            </div>
                        </div>

                        <div class="modal-footer" style="height: 6em;text-align: center;border-top: 0px;">
                            <button type="button" class="btn btn-default" data-dismiss="modal"
                                    style="margin-top: -10em;width: 6em;height: 3em;"><a href="user-management.html"
                                                                                         style="color: #fff;">返回</a>
                            </button>
                            <input type="hidden" value="${u.id}" name="id">
                            <button type="submit" class="btn btn-success"
                                    style="margin-top: -10em;width: 6em;height: 3em;">提交
                            </button>
                        </div>

                    </form>
                </div>

            </form>
        </div>
        <!-- End Wrapper-->


    </div><!-- mainwrapper -->
</section>

<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/retina.min.js"></script>
<script src="js/jquery.cookies.js"></script>
<script src="js/jquery.scrollto.min.js"></script>
<script src="js/jquery.slimscroll.js"></script>

<script src="js/jquery.flot.min.js"></script>
<script src="js/jquery.flot.resize.min.js"></script>
<script src="js/jquery.flot.spline.min.js"></script>
<script src="js/jquery.sparkline.min.js"></script>
<script src="js/morris.min.js"></script>
<script src="js/raphael-2.1.0.min.js"></script>
<script src="js/bootstrap-wizard.min.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/css3clock.js"></script>
<script src="js/jquery-ui-1.10.3.min.js"></script>
<script src="js/moment.min.js"></script>
<script src="js/fullcalendar.min.js"></script>
<script src="js/custom.js"></script>
<script src="js/dashboard.js"></script>
</body>
</html>


<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" id="editUser" action="user_update">
    <%--<c:forEach items="${crop}" var="c">--%>
    <h1>欢迎来到user的编辑页面</h1>
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" value="${u.name}"></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td><input type="text" value="${u.sex}"></td>
        </tr>

        <tr>
            <td>手机:</td>

            <td><input id="phone" name="phone" type="text" value="${u.phone}">省</td>

        </tr>
        <tr>
            <td>邮箱:</td>

            <td><input id="email" name="email" type="text" value="${u.email}">市</td>
        </tr>
        <tr>

            <td>所属区域:</td>
            <td><input id="area" name="area" type="text" value="${u.area}">区</td>
        </tr>
    </table>

    <%--</c:forEach>--%>
    <input type="hidden" name="id" value="${u.id}">
    <button type="submit">提交</button>
</form>

</body>
</html>
