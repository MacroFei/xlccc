<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/2/22
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>

</head>
<body>

<form method="post" id="editUser" action="admin_user_update" enctype="multipart/form-data">
    <table>

        <tr>
            <td>请输入修改后的姓名：</td>
            <td><input id="name" name="name" value="${u.name}" type="text"></td>
        </tr>
        <tr>
            <td>图片</td>
            <td><input id="userPic" accept="image/*" type="file" name="image"/></td>
        </tr>
        <tr>
            <td>
                <input type="hidden" name="id" value="${u.id}">
                <button type="submit" id="tijiao" name="tijiao" value="tijiao">提交</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
