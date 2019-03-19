<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/3/19
  Time: 22:50
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
            // alert("hello" + ids);
            if (ids == '') return;
            location.href = '${pageContext.request.contextPath}/equipment_deleteAll?ids=' + ids;
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
                <li class="parent"><a href="#"><i class="fa fa-suitcase"></i> <span>数据管理</span></a>
                    <ul class="children">
                        <li><a href="data-management.html">农作物信息查看</a></li>
                    </ul>
                </li>
                <li class="parent active"><a href="#"><i class="fa fa-edit"></i> <span>设备管理</span></a>
                    <ul class="children">
                        <li class="active"><a href="equipment-management.html">分类管理</a></li>
                    </ul>
                </li>
                <li class="parent"><a href="#"><i class="fa fa-bars"></i> <span>灌溉管理</span></a>
                    <ul class="children">
                        <li><a href="irrigation-management.html">灌溉设置</a></li>
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
                <p style="font-size: 18px;float: left;margin-left: 20%;">设备检索：
                    <select style="font-size: 18px;">
                        <option value="">浙江省</option>
                        <option value="">福建省</option>
                        <option value="">江苏省</option>
                    </select>
                    ~
                    <select style="font-size: 18px;">
                        <option value="">杭州市</option>
                        <option value="">温州市</option>
                        <option value="">宁波市</option>
                    </select>
                    ~
                    <select style="font-size: 18px;">
                        <option value="">拱墅区</option>
                        <option value="">上城区</option>
                        <option value="">下城区</option>
                    </select>
                    ~
                    <input type="text" class="form-control" id="user_id" name="user_id" placeholder="输入设备编号"
                           style="width: 100px;height: 2.5em;margin-top: -9.5em;margin-left: 40em;">

                    <span class="search-btn" style="position: absolute;margin-left: 27em;margin-top: -2em;">搜索</span>
                </p>
            </div>

            <br>

            <div style="height: 3em;width: 95%;margin-top: -4em;margin-bottom: 2em;margin-left: 2.5%;line-height: 3em;background-color: #f5fafe;">
                <p style="float:left;margin-left: 2em;">共有数据：${totalNumber}条</p>
                <button class="btn btn-danger" style="margin-left: 60em;">批量删除</button>
            </div>

            <table id="tb" class="table table-bordered table-striped" style="width: 90%;margin-left: 5%;">
                <tr>
                    <td>
                        <input type="checkbox" onclick="allChecked(this)"/>全选
                    </td>
                    <td>ID</td>
                    <td>设备编号</td>
                    <td>设备型号</td>
                    <td>设备类别</td>
                    <td>工作状态</td>
                    <td>所属区域</td>
                    <td>数据</td>
                    <td>操作</td>
                </tr>

                <form action="equipment_deleteAll" method="post">

                    <c:forEach items="${es}" var="e">
                        <tr>
                            <td>
                                <input type="checkbox" class="inp" id="checkbox" name="checkbox"  value="${e.id}"/>
                            </td>
                            <td>${e.id}</td>
                            <td>${e.serial_number}</td>
                            <td>${e.unit_type}</td>
                            <td>${e.device_class}</td>
                            <td>${e.working_condition}</td>
                            <td>${e.province} ${e.city} ${e.district}</td>
                            <td>
                                <a href="#" class="big-link" data-reveal-id="${e.id}" data-animation="fade">
                                    <button class="btn btn-success" onclick="location.href='#'">查看</button>
                                </a>
                                <div id="${e.id}" class="reveal-modal">
                                    <h4 style="float: left;">查看信息</h4>
                                    <br>
                                    <br>
                                    <p>设备编号：${e.serial_number}</p>
                                    <p>设备型号：${e.unit_type}</p>
                                    <p>设备类别：${e.device_class}</p>
                                    <p>工作状态：${e.working_condition}</p>
                                    <p>所属区域：${e.province} ${e.city} ${e.district}</p>
                                    <p style="margin-bottom: 20px;">所属公司：${e.company}</p>
                                    <button type="button" class="close-reveal-modal">返回</button>
                                </div>
                            </td>


                            <td>
                                <a href="equipment_edit?id=${e.id}"><img src="images/editor.png" alt="编辑信息"
                                                                         style="margin-right:8px;"></a>
                                <a href="equipment_delete?id=${e.id}" onclick="return confirm('请确认删除');"><img
                                        src="images/delete.png" alt="删除" style="margin-left:8px;"></a>
                            </td>
                        </tr>
                    </c:forEach>
                    <button type="submit" onclick="deleteAllData()">批量删除Demo</button>
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
