<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/3/17
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" id="editUser" action="data_update" >
    <table>
        <tr>
            <td>品种:</td>
            <td><input type="text"></td>
        </tr>  <tr>
        <td>所属区域</td>
        <td><input id="province" name="province" type="text">省</td>
        <td><input id="city" name="data_city" type="text">市</td>
        <td><input id="district" name="district"  type="text">区</td>
    </tr>  <tr>
        <td>所属公司</td>
        <td><input id="data_company" type="text"></td>
    </tr>

    </table>
    <input type="hidden" name="id" value="1">
    <button type="submit">提交</button>
</form>

</body>
</html>
