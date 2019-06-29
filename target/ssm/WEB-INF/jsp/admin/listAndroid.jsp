<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/6/26
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="center" class="table table-striped table-bordered table-hover  table-condensed">
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <tr class="success">
        <%--<th>ID</th>--%>
        <th>标题名称</th>
        <th width="80px">图片管理</th>
        <%--<th width="42px">编辑标题</th>--%>
        <%--<th width="42px">删除</th>--%>
    </tr>
<%--<c:forEach  items="${as}" var="a">--%>
    <%--<tr>--%>
                                              <%--&lt;%&ndash;<td>${a.id}</td>&ndash;%&gt;--%>
        <%--<td>${a.name}</td>--%>
        <%--<td><a href="admin_androidPic_list?androidId=${a.id}" ><span--%>
                <%--class="glyphicon glyphicon-picture"></span>点击进入该图片管理</a></td>--%>
                                                <%--&lt;%&ndash;<td><a href="admin_android_edit?androidId=${a.id}">图片名称</a></td>&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;<td><a href="admin_android_delete?androidId=${a.id}">删除该图片</a></td>&ndash;%&gt;--%>
    <%--</tr>--%>
<%--</c:forEach>--%>
    <tr>
        <td>搭建演示</td>
        <td><a href="admin_androidPic_list?androidId=3">进入</a></td>
    </tr> <tr>
        <td>控制天地</td>
        <td><a href="admin_androidPic_list?androidId=2">进入</a></td>
    </tr><tr>
        <td>视频管理</td>
        <td><a href="admin_androidPic_list?androidId=4">进入</a></td>
    </tr><tr>
    <td>视频管理</td>
    <td><a href="admin_androidPic_list_more?androidId=3">进入</a></td>
</tr>

</table>

<%--<div class="panel panel-warning addDiv">--%>
    <%--<div class="panel-heading">新增图片</div>--%>
    <%--<div class="panel-body">--%>
        <%--<form method="post" id="addForm" action="admin_android_add">--%>
            <%--<table class="addTable">--%>
                <%--<tr>--%>
                    <%--<td>图片名称</td>--%>
                    <%--<td><input id="name" name="name" type="text"--%>
                               <%--class="form-control"></td>--%>
                <%--</tr>--%>

                <%--<tr class="submitTR">--%>
                    <%--<td colspan="2" align="center">--%>
                        <%--<button type="submit" class="btn btn-success">提 交</button>--%>
                    <%--</td>--%>
                <%--</tr>--%>
            <%--</table>--%>
        <%--</form>--%>
    <%--</div>--%>
<%--</div>--%>


</body>
</html>
