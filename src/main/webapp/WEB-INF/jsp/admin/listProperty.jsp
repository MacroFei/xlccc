<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/2/25
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PropertyList</title>
</head>
<body>
<ol>
    <li><a href="admin_user_list">所有用户</a> </li>
    <li><a href="admin_property_list?uid=${u.id}">${u.name}</a> </li>
</ol>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${ps}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td><a href="admin_property_edit?id=${p.id}">编辑</a></td>
            <td><a href="admin_property_delete?id=${p.id}">删除</a></td>
        </tr>
    </c:forEach>

</table>
<br>
<br>
    <div>新增属性</div>
    <form method="post" id="addForm" name="addForm" action="admin_property_add">
        <table>
            <tr>
                <td>属性名称</td>
                <td><input id="name" name="name" type="text" ></td>
            </tr>
            <tr>
                <input type="hidden" name="uid" id="uid" value="${u.id}">
                <td><button type="submit">提交</button> </td>
            </tr>
        </table>

    </form>
</body>
</html>
