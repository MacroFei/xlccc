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
<div>
<c:forEach items="${us}" var="u">

    <tr>
        <td>${u.id}</td>
        <td>${u.name}</td>
    </tr>
</c:forEach>
</div>

<div>

    <script>
        $(function(){
            $("ul.pagination li.disabled a").click(function(){
                return false;
            });
        });

    </script>

    <nav>
        <ul class="pagination">
            <li>
                <a  href="?start=0" aria-label="Previous" >
                    <span aria-hidden="true">«</span>
                </a>
            </li>

            <li >
                <a  href="?start=${page.start-page.count}" aria-label="Previous" >
                    <span aria-hidden="true">‹</span>
                </a>
            </li>

            <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
                <li>
                    <a href="?start=${status.index*page.count}" class="current">${status.count}</a>
                </li>

            </c:forEach>

            <li >
                <a href="?start=${page.start+page.count}" aria-label="Next">
                    <span aria-hidden="true">›</span>
                </a>
            </li>
            <li >
                <a href="?start=${page.last}" aria-label="Next">
                    <span aria-hidden="true">»</span>
                </a>
            </li>
        </ul>
    </nav>


</div><div>
    <script>
        $(function(){
            $("ul.pagination li.disabled a").click(function(){
                return false;
            });
        });

    </script>

    <nav>
        <ul class="pagination">
            <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
                <a  href="?start=0${page.param}" aria-label="Previous" >
                    <span aria-hidden="true">«</span>
                </a>
            </li>

            <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
                <a  href="?start=${page.start-page.count}${page.param}" aria-label="Previous" >
                    <span aria-hidden="true">‹</span>
                </a>
            </li>

            <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
                <li <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
                    <a
                            href="?start=${status.index*page.count}${page.param}"
                            <c:if test="${status.index*page.count==page.start}">class="current"</c:if>
                    >${status.count}</a>
                </li>

            </c:forEach>

            <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
                <a href="?start=${page.start+page.count}${page.param}" aria-label="Next">
                    <span aria-hidden="true">›</span>
                </a>
            </li>
            <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
                <a href="?start=${page.last}${page.param}" aria-label="Next">
                    <span aria-hidden="true">»</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
