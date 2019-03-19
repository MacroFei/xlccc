<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/3/20
  Time: 02:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <input type="hidden" name="id"  value="${u.id}">
    <button type="submit">提交</button>
</form>

</body>
</html>
