<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/2/17
  Time: 00:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello demo</h1>
<c:forEach items="${us}" var="u">

    <tr>
        <td>${u.id}</td>
        <td>${u.name}</td>
    </tr>
</c:forEach>

</body>
</html>
