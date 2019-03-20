<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/3/19
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script>
        function deleteAllData() {
            var ckDataIds = document.getElementsByName("checkbox");
            var ids = '';
            for (var i = 0; i < ckDataIds.length; i++) {
                if (ckDataIds[i].checked == true) {
                    ids += ckDataIds[i].value + ',';
                }
            }
            ids = ids.substring(0, ids.length - 1);
            alert("hello" + ids);
            if (ids == '') return;
            location.href = '${pageContext.request.contextPath}/user_deleteAll?ids=' + ids;
        }
    </script>
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
                <li class="parent active"><a href="#"><i class="fa fa-suitcase"></i> <span>数据管理</span></a>
                    <ul class="children">
                        <li class="active"><a href="crop_list">农作物信息查看</a></li>
                    </ul>
                </li>
                <li class="parent"><a href="#"><i class="fa fa-edit"></i> <span>设备管理</span></a>
                    <ul class="children">
                        <li><a href="equipment_list">分类管理</a></li>
                    </ul>
                </li>
                <li class="parent"><a href="#"><i class="fa fa-bars"></i> <span>灌溉管理</span></a>
                    <ul class="children">
                        <li><a href="irrigate_list">灌溉设置</a></li>
                    </ul>
                </li>
                <li class="parent"><a href="#"><i class="fa fa-file-text"></i> <span>用户管理</span></a>
                    <ul class="children">
                        <li><a href="user_list">管理员管理</a></li>
                    </ul>
                </li>

            </ul>

        </div><!-- leftpanel -->

        <!--body wrapper start-->
        <div class="wrapper" style="min-height: 582px;">

            <div class="task">
                <p style="font-size: 18px;float: left;margin-left: 32%;">
                    <input type="text" class="form-control" id="user_id" name="user_id" placeholder="输入用户名称、手机号"
                           style=" margin-top: 6.5em;position: absolute;width: 18em;margin-left: 5em;">

                    <span class="search-btn" style="margin-left: 24em;margin-top: 6.5em;position: absolute;">搜用户</span>
                </p>
            </div>

            <br>

            <div style="height: 3em;width: 95%;margin-top: -4em;margin-bottom: 2em;margin-left: 2.5%;line-height: 3em;background-color: #f5fafe;">
                <p style="float:left;margin-left: 2em;">共有数据：${totalNumber}</p>
                <button class="btn btn-danger" style="margin-left: 50em;">批量删除</button>
                <a href="#" class="big-link" data-reveal-id="Modal-1" data-animation="fade">
                    <button class="btn btn-primary">添加用户</button>
                </a>
                <div id="Modal-1" class="reveal-modal-2">
                    <h4 style="float: left;">添加用户</h4>
                    <br>
                    <br>
                    <form class="form-horizontal" role="form" style="margin-top: -3em;">
                        <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                            <label for="user_id" class="col-sm-3 control-label"
                                   style="line-height: 1em;margin-left: -0.5em;margin-top: 2em;">用户名：</label>
                            <div class="col-sm-9" style="margin-top: 1.5em;">
                                <input type="text" class="form-control" id="user_id" name="user_id">
                            </div>
                        </div>

                        <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                            <label class="col-sm-3 control-label"
                                   style="line-height: 1em;margin-left: -0.5em;margin-top: 1.5em;">密码：</label>
                            <div class="col-sm-9" style="margin-top: 1.5em;">
                                <input type="text" class="form-control" id="user_id" name="user_id">
                            </div>
                        </div>

                        <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                            <label class="col-sm-3 control-label"
                                   style="line-height: 1em;margin-left: -0.5em;margin-top: 1.5em;">类别：</label>
                            <div class="col-sm-9" style="margin-top: 1.5em;">
                                <input type="text" class="form-control" id="user_id" name="user_id">
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                            <label class="col-sm-3 control-label"
                                   style="line-height: 1em;margin-left: -0.5em;margin-top: 1.5em;">手机：</label>
                            <div class="col-sm-9" style="margin-top: 1.5em;">
                                <input type="text" class="form-control" id="user_id" name="user_phone">
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                            <label class="col-sm-3 control-label"
                                   style="line-height: 1em;margin-left: -0.5em;margin-top: 1.5em;">邮箱：</label>
                            <div class="col-sm-9" style="margin-top: 1.5em;">
                                <input type="text" class="form-control" id="user_id" name="user_email">
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                            <label class="col-sm-3 control-label"
                                   style="line-height: 1em;margin-left: -0.5em;margin-top: 1.5em;">所属地区：</label>
                            <div class="col-sm-9" style="margin-top: 1.5em;">
                                <input type="text" class="form-control" id="user_id" name="user_place">
                            </div>
                        </div>

                        <button type="reset" class="btn btn-default" data-dismiss="modal" style="margin-top: 3em;">重置
                        </button>
                        <button type="submit" class="btn btn-success" style="margin-top: 3em;">提交</button>
                    </form>


                    </form>
                </div>
            </div>

            <table id="tb" class="table table-bordered table-striped" style="width: 90%;margin-left: 5%;">
                <tr>
                    <td>
                        <input type="checkbox" onclick="allChecked(this)"/>全选
                    </td>
                    <td>ID</td>
                    <td>用户名</td>
                    <td>手机</td>
                    <td>邮箱</td>
                    <td>所属区域</td>
                    <td>数据</td>
                    <td>操作</td>
                </tr>

                <form action="user_list" method="post" id="form1">
                    <c:forEach items="${us}" var="u">
                        <tr>
                            <td>
                                <input type="checkbox" name="checkbox" value="${u.id}" class="inp"/>
                            </td>
                            <td>${u.id}</td>
                            <td>${u.name}</td>
                            <td>${u.sex}</td>
                            <td>${u.phone}</td>
                            <td>${u.email}</td>
                            <td>${u.area}</td>
                            <td>
                                <a href="#" class="big-link" data-reveal-id="${u.id}" data-animation="fade">
                                    <button class="btn btn-success" onclick="location.href='#'">查看</button>
                                </a>
                                <div id="${u.id}" class="reveal-modal">
                                    <h4 style="float: left;">查看信息</h4>
                                    <br>
                                    <br>
                                    <p>用户名：${u.name}</p>
                                        <%--<p>性别：${u.sex}</p>--%>
                                    <p>手机：${u.phone}</p>
                                    <p>邮箱：${u.email}</p>
                                    <p style="margin-bottom: 20px;">所属地区：${u.area}</p>

                                    <button type="button" class="close-reveal-modal">返回</button>
                                </div>
                            </td>
                            <td>
                                <a href="" class="big-link" data-toggle="modal" data-target="#addUserModal"><img
                                        src="images/editor.png" alt="编辑信息" style="margin-right:8px;"
                                        onclick="javascript:location.href='user_edit?id=${u.id}'"></a>
                                <input type="hidden" id="hiddenId" name="hiddenId" value="${u.id}">
                                <a href="#" class="big-link" data-reveal-id="Modal" data-animation="none" onclick="fuzhi()"><img
                                        src="images/password.png" alt="修改密码" style="margin-left:8px;"></a>

                                <a href="user_delete?id=${u.id}" onclick="return confirm('请确认删除');"><img
                                        src="images/delete.png" alt="删除"
                                        style="margin-left:8px;"></a>
                            </td>
                        </tr>
                    </c:forEach>

                    <button type="button" onclick="deleteAllData()">批量删除Demo</button>
                </form>
            </table>
            <script>
                function allChecked(ck) {
                    var is = document.getElementsByClassName("inp");
                    for (var i = 0; i <= is.length; i++) {
                        is[i].checked = ck.checked;
                    }
                }
            </script>
            
            <script>

                function fuzhi() {
                    var idDemo = document.getElementById("hiddenId").value;
                    alert(idDemo+":idDemo4");
                    // var idDemo5 = form1.hiddenId.value;
                    var idNext = document.getElementById("passwordId");
                        idNext.value = idDemo;

                }


            </script>

            <form action="user_update_password" method="post">  <!--需要用js获取id -->
                <div id="Modal" class="reveal-modal-1">
                    <h4 style="float: left;">修改密码</h4>
                    <p style="line-height: 3em;margin-right: 15em;">原密码：
                        <input type="text" class="form-control"  name="password"
                               style="width: 17em;height: 2.7em;margin-left: 11em;margin-top: -3.5em;">
                    </p>
                    <p style="margin-left: -15em;line-height: 3.5em;">新密码：
                        <input type="text" class="form-control"  name="newPassword"
                               style="width: 17em;height: 2.7em;margin-left: 31.8em;margin-top: -4em;">
                    </p>

                    <button type="reset" class="btn btn-default" data-dismiss="modal"
                            style="margin-top: 3em;">重置
                    </button>
                    <input type="hidden" id="passwordId"  value="">
                    <button type="submit" class="btn btn-success" style="margin-top: 3em;">提交
                    </button>
                </div>
            </form>
            <script>
                function setId(id,value) {
                    document.getElementById(id).value = value;
                }

            </script>

            <nav>
                <ul class="pagination">
                    <li>
                        <a href="?start=0" aria-label="Previous">
                            <span aria-hidden="true">«</span>
                        </a>
                    </li>

                    <li>
                        <a href="?start=${page.start-page.count}" aria-label="Previous">
                            <span aria-hidden="true">‹</span>
                        </a>
                    </li>

                    <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
                        <li>
                            <a href="?start=${status.index*page.count}" class="current">${status.count}</a>
                        </li>

                    </c:forEach>

                    <li>
                        <a href="?start=${page.start+page.count}" aria-label="Next">
                            <span aria-hidden="true">›</span>
                        </a>
                    </li>
                    <li>
                        <a href="?start=${page.last}" aria-label="Next">
                            <span aria-hidden="true">»</span>
                        </a>
                    </li>
                </ul>
            </nav>


        </div>
        <!-- End Wrapper-->


    </div><!-- mainwrapper -->
</section>

<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/pace.min.js"></script>
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
