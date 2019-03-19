<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/3/19
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" id="editEquipment" action="equipment_update">
    <table>
        <tr>
            <td>设备编号:</td>
            <td><input type="text" id="serial_number" name="serial_number" value="${e.serial_number}"></td>
        </tr>
        <tr>
            <td>设备型号:</td>
            <td><input id="unit_type" name="unit_type" type="text" value="${e.unit_type}"/></td>

        </tr>
        <tr>
            <td>设备类别：</td>
            <td><input id="device_class" name="device_class" type="text" value="${e.device_class}"></td>
        </tr>
        <tr>
            <td>工作状态</td>
            <td><input id="working_condition" name="working_condition" type="text" value="${e.working_condition}"></td>
        </tr>
        <tr>
            <td>所属区域：</td>
            <td><input type="text" id="province" name="province" value="${e.province}"></td>
            <td>省</td>
            <td><input type="text" id="city" name="city" value="${e.city}"></td>
            <td>市</td>
            <td><input type="text" id="district" name="district" value="${e.district}"></td>
            <td>区</td>
        </tr>
        <tr>
            <td>所属公司</td>
            <td><input type="text" id="company" name="company" value="${e.company}"></td>
        </tr>

    </table>
    <input type="hidden" name="id" value="${e.id}">
    <button type="submit">提交</button>
</form>

</body>
</html>
