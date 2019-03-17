<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/3/17
  Time: 15:29
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

    <title>智能灌溉系统后台123</title>

    <link href="../css/style.default.css" rel="stylesheet">
    <link href="../css/morris.css" rel="stylesheet">
    <link href="../css/select2.css" rel="stylesheet" />
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/style.calendar.css" rel="stylesheet">
    <link href="../css/reveal.css" rel="stylesheet" >

    <script src="http://www.jq22.com/js/jq.js"></script>
    <script src="http://www.jq22.com/jquery/jquery-1.6.2.js"></script>
    <script type="text/javascript" src="../js/jquery.reveal.js"></script>
</head>

<body>

<header>
    <div class="headerwrapper">
        <div class="header-left">
            <a href="../index.html" class="logo">
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
                        <img class="img-circle avatar-img" alt="" src="../picture/chrome.png">
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
                <li><a href="../index.html"><i class="fa fa-home"></i> <span>主页</span></a></li>
                <li class="parent active"><a href="#"><i class="fa fa-suitcase"></i> <span>数据管理</span></a>
                    <ul class="children">
                        <li class="active"><a href="../data-management.html">农作物信息查看</a></li>
                    </ul>
                </li>
                <li class="parent"><a href="#"><i class="fa fa-edit"></i> <span>设备管理</span></a>
                    <ul class="children">
                        <li><a href="../equipment-management.html">分类管理</a></li>
                    </ul>
                </li>
                <li class="parent"><a href="#"><i class="fa fa-bars"></i> <span>灌溉管理</span></a>
                    <ul class="children">
                        <li><a href="../irrigation-management.html">灌溉设置</a></li>
                    </ul>
                </li>
                <li class="parent"><a href="#"><i class="fa fa-file-text"></i> <span>用户管理</span></a>
                    <ul class="children">
                        <li><a href="../user-management.html">管理员管理</a></li>
                    </ul>
                </li>

            </ul>

        </div><!-- leftpanel -->

        <!--body wrapper start-->
        <div class="wrapper" style="min-height: 582px;">

            <div class="task">
                <p style="font-size: 18px;float: left;margin-left: 25%;position: absolute;">农作物检索：
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
                        <option value="">西红柿</option>
                        <option value="">白菜</option>
                        <option value="">黄瓜</option>
                    </select>

                    <span class="search-btn">搜索</span>
                </p>
            </div>

            <br>

            <div style="height: 3em;width: 95%;margin-top: -4em;margin-bottom: 2em;margin-left: 2.5%;line-height: 3em;background-color: #f5fafe;">
                <p style="float:left;margin-left: 2em;">共有数据：3条</p>
                <button class="btn btn-danger" style="margin-left: 60em;">批量删除</button>
            </div>

            <table id="tb"  class="table table-bordered table-striped" style="width: 90%;margin-left: 5%;">
                <tr>
                    <td>
                        <input type="checkbox" onclick="allChecked(this)" />全选
                    </td>
                    <td>ID</td>
                    <td>品种</td>
                    <td>温度</td>
                    <td>湿度</td>
                    <td>CO2</td>
                    <td>光照</td>
                    <td>所属区域</td>
                    <td>数据</td>
                    <td>操作</td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" class="inp" />
                    </td>
                    <td>1</td>
                    <td>西红柿</td>
                    <td>20℃</td>
                    <td>70％</td>
                    <td>70 ìl/L</td>
                    <td>40000lx</td>
                    <td>浙江省杭州市拱墅区</td>
                    <td>
                        <a href="#" class="big-link" data-reveal-id="myModal" data-animation="fade"><button class="btn btn-success" onclick="location.href='#'">查看</button></a>
                        <div id="myModal" class="reveal-modal">
                            <h4 style="float: left;">查看信息</h4>
                            <br>
                            <br>
                            <p>品种：西红柿</p>
                            <p>温度：20℃</p>
                            <p>湿度：70%</p>
                            <p>CO2：70 ìl/L</p>
                            <p>光照：40000lx</p>
                            <p>所属区域：浙江省杭州市拱墅区</p>
                            <p style="margin-bottom: 20px;">所属公司：杭州农业科技有限公司</p>
                            <button type="button" class="close-reveal-modal">返回</button>
                        </div>
                    </td>
                    <td>
                        <a href="#" class="big-link" data-toggle="modal" data-target="#addUserModal"><img src="../images/editor.png" alt="编辑信息" style="margin-right:8px;">
                            <div id="myModal" class="reveal-modal">
                                <h4 style="float: left;">编辑信息</h4>
                                <br>
                                <br>
                                <p>品种：西红柿</p>
                                <p>温度：20℃</p>
                                <p>湿度：70%</p>
                                <p>CO2：70 ìl/L</p>
                                <p>光照：40000lx</p>
                                <p>所属区域：浙江省杭州市拱墅区</p>
                                <p style="margin-bottom: 20px;">所属公司：杭州农业科技有限公司</p>
                                <button type="button" class="close-reveal-modal">返回</button>
                            </div>
                        </a>
                        <a href="" onclick="return confirm('请确认删除');"><img src="../images/delete.png" alt="删除" style="margin-left:8px;"></a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" class="inp" />
                    </td>
                    <td>2</td>
                    <td>西红柿</td>
                    <td>22℃</td>
                    <td>65％</td>
                    <td>50 ìl/L</td>
                    <td>43000lx</td>
                    <td>浙江省杭州市余杭区</td>
                    <td>
                        <a href="#" class="big-link" data-reveal-id="myModal" data-animation="fade"><button class="btn btn-success" onclick="location.href='#'">查看</button></a>
                        <div id="myModal" class="reveal-modal">
                            <h4 style="float: left;">查看信息</h4>
                            <br>
                            <br>
                            <p>品种：西红柿</p>
                            <p>温度：22℃</p>
                            <p>湿度：65%</p>
                            <p>CO2：50 ìl/L</p>
                            <p>光照：43000lx</p>
                            <p>所属区域：浙江省杭州市余杭区</p>
                            <p style="margin-bottom: 20px;">所属公司：杭州农业科技有限公司</p>
                            <button type="button" class="close-reveal-modal">返回</button>
                        </div>
                    </td>
                    <td>
                        <a href=""><img src="../images/editor.png" alt="编辑信息" style="margin-right:8px;"></a>
                        <a href="" onclick="return confirm('请确认删除');"><img src="../images/delete.png" alt="删除" style="margin-left:8px;"></a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" class="inp" />
                    </td>
                    <td>3</td>
                    <td>西红柿</td>
                    <td>18℃</td>
                    <td>70%</td>
                    <td>60 ìl/L</td>
                    <td>35000lx</td>
                    <td>浙江省杭州市下城区</td>
                    <td>
                        <a href="#" class="big-link" data-reveal-id="myModal" data-animation="fade"><button class="btn btn-success" onclick="location.href='#'">查看</button></a>
                        <div id="myModal" class="reveal-modal">
                            <h4 style="float: left;">查看信息</h4>
                            <br>
                            <br>
                            <p>品种：西红柿</p>
                            <p>温度：18℃</p>
                            <p>湿度：70%</p>
                            <p>CO2：60 ìl/L</p>
                            <p>光照：35000lx</p>
                            <p>所属区域：浙江省杭州市下城区</p>
                            <p style="margin-bottom: 20px;">所属公司：杭州农业科技有限公司</p>
                            <button type="button" class="close-reveal-modal">返回</button>
                        </div>
                    </td>
                    <td>
                        <a href=""><img src="../images/editor.png" alt="编辑信息" style="margin-right:8px;"></a>
                        <a href="" onclick="return confirm('请确认删除');"><img src="../images/delete.png" alt="删除" style="margin-left:8px;"></a>
                    </td>
                </tr>
            </table>
            <script>
                function allChecked(ck){
                    var is=document.getElementsByClassName("inp");
                    for (var i=0;i<=is.length;i++) {
                        is[i].checked=ck.checked;
                    }
                }
            </script>

            <!-- 模态框示例（Modal） -->
            <form method="post" action="" class="form-horizontal" role="form" id="form_data" onsubmit="return check_form()" style="margin: 20px;">
                <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                                    <div class="form-group"  style="margin-top: 0em;margin-bottom: 0em;">
                                        <label for="user_id" class="col-sm-3 control-label" style="line-height: 1em;margin-left: -2.5em;margin-top: 2em;">品种：</label>
                                        <div class="col-sm-9"style="margin-top: 1.5em;">
                                            <input type="text" class="form-control" id="user_id" name="user_id">
                                        </div>
                                    </div>

                                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                                        <label for="lastname" class="col-sm-3 control-label"  style="line-height: 1em;margin-left: -2.5em;margin-top: 1em;">温度：</label>
                                        <p style="line-height: 2em;margin-top: 1em;float: left;">20℃</p>
                                    </div>
                                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                                        <label for="lastname" class="col-sm-3 control-label" style="line-height: 1em;margin-left: -2.5em;margin-top: 1em;">湿度：</label>
                                        <p style="line-height: 2em;margin-top: 1em;float: left;">70％</p>
                                    </div>
                                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                                        <label for="lastname" class="col-sm-3 control-label" style="line-height: 1em;margin-left: -2.5em;margin-top: 1em;">CO2：</label>
                                        <p style="line-height: 2em;margin-top: 1em;float: left;">70 ìl/L</p>
                                    </div>
                                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                                        <label for="lastname" class="col-sm-3 control-label" style="line-height: 1em;margin-left: -2.5em;margin-top: 1em;">光照：</label>
                                        <p style="line-height: 2em;margin-top: 1em;float: left;">40000lx</p>
                                    </div>

                                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                                        <label for="user_id" class="col-sm-3 control-label" style="line-height: 1em;margin-left: -1.5em;margin-top: 1em;">所属区域：</label>
                                        <div class="col-sm-9"style="margin-top: 1em;">
                                            <input type="text" class="form-control" id="user_id" name="user_id" style=" width: 85px;"><p style="line-height: 2.5em;margin-top: -2.5em;margin-right: 12em;">省</p>
                                            <input type="text" class="form-control" id="user_id" name="user_id" style=" width: 85px;margin-top: -3.8em;margin-left: 10em;"><p style="line-height: 2.5em;margin-top: -2.5em;margin-left: 2.5em;">市</p>
                                            <input type="text" class="form-control" id="user_id" name="user_id" style=" width: 85px;margin-top: -3.8em;margin-left: 20em;"><p style="line-height: 2.5em;margin-top: -2.5em;margin-left: 17em;">区</p>
                                        </div>
                                    </div>
                                    <div class="form-group" style="margin-top: 0em;margin-bottom: 0em;">
                                        <label for="user_id" class="col-sm-3 control-label" style="line-height: 1em;margin-left: -1.5em;margin-top: 1em;">所属公司：</label>
                                        <div class="col-sm-9"style="margin-top: 1em;">
                                            <input type="text" class="form-control" id="user_id" name="user_id">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer" style="height: 6em;">
                                <button type="button" class="btn btn-default" data-dismiss="modal" style="margin-top: -10em;">关闭</button>
                                <button type="submit" class="btn btn-success" style="margin-top: -10em;">提交</button><span id="tip"> </span>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>
            </form>


            <ul class="pagination">
                <li><a href="#">«</a></li>
                <li><a class="active" href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">6</a></li>
                <li><a href="#">7</a></li>
                <li><a href="#">»</a></li>
            </ul>


        </div>
        <!-- End Wrapper-->



    </div><!-- mainwrapper -->
</section>

<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/jquery-migrate-1.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/modernizr.min.js"></script>
<script src="../js/pace.min.js"></script>
<script src="../js/retina.min.js"></script>
<script src="../js/jquery.cookies.js"></script>
<script src="../js/jquery.scrollto.min.js"></script>
<script src="../js/jquery.slimscroll.js"></script>

<script src="../js/jquery.flot.min.js"></script>
<script src="../js/jquery.flot.resize.min.js"></script>
<script src="../js/jquery.flot.spline.min.js"></script>
<script src="../js/jquery.sparkline.min.js"></script>
<script src="../js/morris.min.js"></script>
<script src="../js/raphael-2.1.0.min.js"></script>
<script src="../js/bootstrap-wizard.min.js"></script>
<script src="../js/select2.min.js"></script>
<script src="../js/css3clock.js"></script>
<script src="../js/jquery-ui-1.10.3.min.js"></script>
<script src="../js/moment.min.js"></script>
<script src="../js/fullcalendar.min.js"></script>
<script src="../js/custom.js"></script>
<script src="../js/dashboard.js"></script>
</body>
</html>
