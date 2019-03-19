<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/3/19
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <script type="text/javascript" src="js/jedate.js"></script>
    <link type="text/css" rel="stylesheet" href="css/jeDate-test.css">
    <link type="text/css" rel="stylesheet" href="css/jedate.css">

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
            //alert("hello"+ ids );
            if (ids == '') return;
            location.href = '${pageContext.request.contextPath}/irrigation_deleteAll?ids=' + ids;
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
        <div class="leftpanel" style="top: 0px;">
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
                <p style="font-size: 18px;float: left;margin-left: 25%;position: absolute;">设备检索：
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
                    <select style="font-size: 18px;margin-right: 3em;">
                        <option value="">一号大棚</option>
                        <option value="">二号大棚</option>
                        <option value="">三号大棚</option>
                    </select>

                    <span class="search-btn">搜索</span>
                </p>
            </div>

            <br>

            <div style="height: 3em;width: 95%;margin-top: -4em;margin-bottom: 2em;margin-left: 2.5%;line-height: 3em;background-color: #f5fafe;">
                <p style="float:left;margin-left: 2em;">共有数据：${totalNumber}条</p>
                <button class="btn btn-danger" style="margin-left: 60em;">批量删除</button>
                <button class="btn btn-primary" style="margin-left: 2em;">批量设置</button>
            </div>

            <table id="tb" class="table table-bordered table-striped" style="width: 90%;margin-left: 5%;">
                <tr>
                    <td>
                        <input type="checkbox" onclick="allChecked(this)"/>全选
                    </td>
                    <td>ID</td>
                    <td>设备编号</td>
                    <td>所属大棚</td>
                    <td>定时</td>
                    <td>工作状态</td>
                    <td>所属区域</td>
                    <td>数据</td>
                    <td>操作</td>
                </tr>
                <form action="irrigate_list" method="post">
                    <c:forEach items="${is}" var="i">
                        <tr>
                            <td>
                                <input type="checkbox" id="checkbox" name="checkbox" value="${i.id}" class="inp"/>
                            </td>
                            <td>${i.id}</td>
                            <td>${i.serial_number}</td>
                            <td>${i.greenhouse}</td>
                            <td>星期一</td>
                            <td>${i.working_condition}</td>
                            <td>${i.province}${i.city}${i.district}</td>
                            <td>
                                <a href="#" class="big-link" data-reveal-id="myModal" data-animation="fade">
                                    <button class="btn btn-success" onclick="location.href='#'">查看</button>
                                </a>
                                <div id="myModal" class="reveal-modal">
                                    <h4 style="float: left;">查看信息</h4>
                                    <br>
                                    <br>
                                    <p>设备编号：${i.serial_number}</p>
                                    <p>所属大棚：${i.greenhouse}</p>
                                    <p>定时：星期一 - 12：00~59：00</p>
                                    <p>工作状态：正常</p>
                                    <p>阀门数量：2</p>
                                    <p>灌溉时间：60分</p>
                                    <p style="margin-bottom: 20px;">所属地区：${i.province}${i.city}${i.district}</p>

                                    <button type="button" class="close-reveal-modal">返回</button>
                                </div>
                            </td>
                            <td>
                                <a href="#" class="big-link" data-toggle="modal" data-target="#addUserModal"><img
                                        src="images/editor.png" alt="编辑信息" style="margin-right:8px;"></a>
                                <a href="#" class="big-link" data-reveal-id="Modal" data-animation="none"><img
                                        src="images/set-up.png" alt="设置" style="margin-left:8px;"></a>
                                <div id="Modal" class="reveal-modal-1">
                                    <h4 style="float: left;">参数设置</h4>
                                    <br>
                                    <br>
                                    <form action="" method="post">
                                        <p style="line-height: 3em;">阀门控制：
                                            <select style="width: 16em;height: 1.8em;margin-right: 3em;">
                                                <option value="">1</option>
                                                <option value="">2</option>
                                                <option value="">3</option>
                                            </select>
                                        </p>
                                        <p style="margin-left: -15em;line-height: 3.5em;">灌溉时间（分钟）：
                                            <input type="text" class="form-control" id="user_id" name="user_id"
                                                   style="width: 17em;height: 2.7em;margin-left: 35em;margin-top: -4em;">
                                        </p>
                                        <p style="margin-right: 21em;line-height: 4em;">定时：
                                        <div class="jeitem">
                                            <div class="jeinpbox"><input type="text" class="jeinput" id="test04"
                                                                         placeholder="YYYY-MM-DD hh:mm:ss"
                                                                         style="margin-left: 4em;margin-top: -3em;">
                                            </div>
                                        </div>
                                        </p>

                                        <button type="reset" class="btn btn-default" data-dismiss="modal"
                                                style="margin-top: 0em;">重置
                                        </button>
                                        <button type="submit" class="btn btn-success"
                                                style="margin-top: 0em;margin-right: 10em;">提交
                                        </button>
                                    </form>
                                </div>
                                <a href="irrigate_delete?id=${i.id}" onclick="return confirm('请确认删除');"><img
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

            <!-- 模态框（Modal） -->
            <form method="post" action="" class="form-horizontal" role="form" id="form_data"
                  onsubmit="return check_form()" style="margin: 20px;">
                <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">
                                    编辑信息
                                </h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" role="form">
                                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                                        <label for="user_id" class="col-sm-3 control-label"
                                               style="line-height: 1em;margin-left: -1.5em;margin-top: 2em;">设备编号：</label>
                                        <div class="col-sm-9" style="margin-top: 1.5em;">
                                            <input type="text" class="form-control" id="user_id" name="user_id">
                                        </div>
                                    </div>

                                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                                        <label for="lastname" class="col-sm-3 control-label"
                                               style="line-height: 1em;margin-left: -1.5em;margin-top: 2em;">所属大棚：</label>
                                        <div class="col-sm-9" style="margin-top: 1.5em;">
                                            <input type="text" class="form-control" id="user_id" name="user_id">
                                        </div>
                                    </div>
                                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                                        <label for="lastname" class="col-sm-3 control-label"
                                               style="line-height: 1em;margin-left: -3.5em;margin-top: 1em;">定时：</label>
                                        <p style="line-height: 2em;margin-top: 1em;float: left;">星期一 - 12：00~59：00</p>
                                    </div>
                                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                                        <label for="lastname" class="col-sm-3 control-label"
                                               style="line-height: 1em;margin-left: -1.5em;margin-top: 1em;">工作状态：</label>
                                        <p style="line-height: 2em;margin-top: 1em;float: left;">正常</p>
                                    </div>
                                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                                        <label for="lastname" class="col-sm-3 control-label"
                                               style="line-height: 1em;margin-left: -1.5em;margin-top: 1em;">阀门数量：</label>
                                        <p style="line-height: 2em;margin-top: 1em;float: left;">2</p>
                                    </div>
                                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                                        <label for="user_id" class="col-sm-3 control-label"
                                               style="line-height: 1em;margin-left: -1.5em;margin-top: 1em;">灌溉时间：</label>
                                        <p style="line-height: 2em;margin-top: 1em;float: left;">60分</p>
                                    </div>
                                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                                        <label for="user_id" class="col-sm-3 control-label"
                                               style="line-height: 1em;margin-left: -1.5em;margin-top: 1em;">所属区域：</label>
                                        <div class="col-sm-9" style="margin-top: 1em;">
                                            <input type="text" class="form-control" id="user_id" name="user_id">
                                        </div>
                                    </div>

                                </form>
                            </div>
                            <div class="modal-footer" style="height: 5em;">
                                <button type="button" class="btn btn-default" data-dismiss="modal"
                                        style="margin-top: -10em;">关闭
                                </button>
                                <button type="submit" class="btn btn-success" style="margin-top: -10em;">提交</button>
                                <span id="tip"> </span>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>
            </form>


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

<script type="text/javascript" src="js/demo.js"></script>

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

