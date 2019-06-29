<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/6/26
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>

    <form method="post" action="admin_android_update">
        <tr>
            <td><input type="text" id="id" name="id" value="${a.id}"></td>
            <td><input type="text" id="name" name="name" value="${a.name}"></td>
        </tr>

        <tr>
            <td>
                <button type="submit">更新提交</button>
            </td>
        </tr>
    </form>
</table>

</body>
</html>
