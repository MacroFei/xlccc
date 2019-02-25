<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/2/25
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ol>
    <li><a href="admin_user_list">所有用户</a> </li>
    <li><a href="admin_property_list?uid=${p.user.id}">${p.user.name}</a> </li>

</ol>
<form method="post" action="admin_property_update">
    <table>
        <tr>
            <td>id</td>
            <td>属性名</td>

        </tr>
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
        </tr>
    </table>
</form>

<br>
<form method="post" action="admin_property_add">
    <table>
        <tr><input type="text" name="name" id="name"></tr>
        <tr>
            <td>新属性：</td>
            <td><input type="hidden" name="id" value="${p.id}"> </td>
            <td><input type="hidden" name="uid" value="${p.user.id}"> </td>
            <td>
                <button type="submit">
                    提交
                </button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
