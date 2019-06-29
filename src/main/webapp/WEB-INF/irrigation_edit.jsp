<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/3/20
  Time: 02:45
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
    <link href="css/select2.css" rel="stylesheet" />
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style.calendar.css" rel="stylesheet">
    <link href="css/reveal.css" rel="stylesheet" >

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
                    <input type="search" class="form-control" placeholder="Search" />
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
                <li class="parent active"><a href="#"><i class="fa fa-bars"></i> <span>灌溉管理</span></a>
                    <ul class="children">
                        <li class="active"><a href="irrigation-management.html">灌溉设置</a></li>
                    </ul>
                </li>
                <li class="parent"><a href="#"><i class="fa fa-file-text"></i> <span>用户管理</span></a>
                    <ul class="children">
                        <li><a href="user-management.html">管理员管理</a></li>
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

            <div class="modal-body" style="margin-bottom: 1em;">
                <form class="form-horizontal" role="form" method="post" action="irrigate_update">
                    <div class="form-group" style="margin-top: -6.5em;margin-bottom: 0.5em;">
                        <label  class="col-sm-3 control-label" style="line-height: 1em;margin-left: -6em;margin-top: 2em;">设备编号：</label>
                        <div class="col-sm-9"style="margin-top: 1.5em;">
                            <input type="text" class="form-control"  name="id" value="${i.id}">
                        </div>
                    </div>

                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0.5em;">
                        <label class="col-sm-3 control-label" style="line-height: 1em;margin-left: -6em;margin-top: 2em;">所属大棚：</label>
                        <div class="col-sm-9"style="margin-top: 1.5em;">
                            <input type="text" class="form-control"  name="greenhouse" value="${i.greenhouse}">
                        </div>
                    </div>

                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0.5em;">
                        <label  class="col-sm-3 control-label" style="line-height: 1em;margin-left: -6em;margin-top: 1.5em;">所属区域：</label>
                        <div class="col-sm-9"style="margin-top: 1em;">
                            <input type="text" class="form-control"  name="province" style=" width: 130px;" value="${i.province}"><p style="line-height: 2.5em;margin-top: -2.5em;margin-left: 8.1em;position: absolute;">省</p>
                            <input type="text" class="form-control"  name="city" style=" width: 130px;margin-top: -3.1em;margin-left: 14em;" value="${i.city}"><p style="line-height: 2.5em;margin-top: -2.5em;margin-left: 18.1em;position: absolute;">市</p>
                            <input type="text" class="form-control"  name="district" style=" width: 130px;margin-top: -3.1em;margin-left: 27.5em;" value="${i.district}" ><p style="line-height: 2.5em;margin-top: -2.5em;margin-left: 28em;position: absolute;">区</p>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                        <label  class="col-sm-3 control-label" style="line-height: 1em;margin-left: -6em;margin-top: 1.5em;">所属公司：</label>
                        <div class="col-sm-9"style="margin-top: 1em;">
                            <input type="text" class="form-control" id="company_id" name="company_id" value="">
                        </div>
                    </div>

                    <div class="modal-footer" style="height: 6em;text-align: center;border-top: 0px;">
                        <button type="button" class="btn btn-default" data-dismiss="modal" style="margin-top: -10em;width: 6em;height: 3em;"><a href="irrigation-management.html" style="color: #fff;">返回</a></button>
                        <input type="hidden" name="id" value="${i.id}">
                        <button type="submit" class="btn btn-success" style="margin-top: -10em;width: 6em;height: 3em;">提交</button>
                    </div>

                </form>
            </div>


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


<%--<html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form method="post" id="editCrop" action="crop_update">--%>
    <%--&lt;%&ndash;<c:forEach items="${crop}" var="c">&ndash;%&gt;--%>
    <%--<h1>欢迎来到crop的编辑页面</h1>--%>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<td>设备编号:</td>--%>
            <%--<td><input type="text" value="${i.district}"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>温度:</td>--%>
            <%--<td><input type="text" value="${i.temperayure}"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>所属区域</td>--%>
            <%--<td><input id="province" name="province" type="text" value="${i.province}">省</td>--%>
            <%--<td><input id="city" name="data_city" type="text" value="${i.city}">市</td>--%>
            <%--<td><input id="district" name="district" type="text" value="${i.district}">区</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>所属公司</td>--%>
            <%--<td><input id="data_company" type="text" value="${i.company}"></td>--%>
        <%--</tr>--%>

    <%--</table>--%>

    <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
    <%--<input type="hidden" name="id" value="${i.id}">--%>
    <%--<button type="submit">提交</button>--%>
<%--</form>--%>

<%--</body>--%>
<%--</html>--%>
