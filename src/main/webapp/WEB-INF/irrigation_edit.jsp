<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/3/20
  Time: 02:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" id="editCrop" action="crop_update">
    <%--<c:forEach items="${crop}" var="c">--%>
    <h1>欢迎来到crop的编辑页面</h1>
    <table>
        <tr>
            <td>设备编号:</td>
            <td><input type="text" value="${i.district}"></td>
        </tr>
        <tr>
            <td>温度:</td>
            <td><input type="text" value="${i.temperayure}"></td>
        </tr>
        <tr>
            <td>所属区域</td>
            <td><input id="province" name="province" type="text" value="${i.province}">省</td>
            <td><input id="city" name="data_city" type="text" value="${i.city}">市</td>
            <td><input id="district" name="district" type="text" value="${i.district}">区</td>
        </tr>
        <tr>
            <td>所属公司</td>
            <td><input id="data_company" type="text" value="${i.company}"></td>
        </tr>

    </table>

    <%--</c:forEach>--%>
    <input type="hidden" name="id" value="${i.id}">
    <button type="submit">提交</button>
</form>

</body>
</html>
