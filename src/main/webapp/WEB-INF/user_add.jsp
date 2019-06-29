<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/3/20
  Time: 07:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加新用户</title>
</head>
<body>
<form method="post" action="user_add">
    <table>
        <tr>
            <td>请输入用户名:</td>
            <td><input type="text" id="name" name="name"></td>
        </tr>  <tr>
        <td>请输入密码:</td>
        <td><input type="text" id="password" name="password"></td>
    </tr>

        <button type="submit">提交</button>
    </table>
</form>

</body>
</html>
