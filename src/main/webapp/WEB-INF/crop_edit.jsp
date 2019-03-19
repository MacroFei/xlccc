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
                <td>品种:</td>
                <td><input type="text" id="variety" name="variety" value="${crop.variety}"></td>
            </tr>
            <tr>
                <td>温度:</td>
                <td><input type="text" id="temperayure" name="temperayure" value="${crop.temperayure}"></td>
            </tr>
            <tr>
                <td>所属区域</td>
                <td><input id="province" name="province" type="text" value="${crop.province}">省</td>
                <td><input id="city" name="city" type="text" value="${crop.city}">市</td>
                <td><input id="district" name="district" type="text" value="${crop.district}">区</td>
            </tr>
            <tr>
                <td>所属公司</td>
                <td><input id="company" name="company" type="text" value="${crop.company}"></td>
            </tr>

        </table>

    <%--</c:forEach>--%>
    <input type="hidden" name="id" value="${crop.id}">
    <button type="submit">提交</button>
</form>

</body>
</html>
