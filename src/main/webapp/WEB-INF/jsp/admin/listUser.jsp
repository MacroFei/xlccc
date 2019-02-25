<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2019/2/17
  Time: 00:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>welcome to xlccc</title>
    <style>
        div {
            align: "center";
        }

    </style>
    <%--<script>--%>
    <%--function checkEmpty(id, name){--%>
    <%--var value = $("#"+id).val();--%>
    <%--if(value.length==0){--%>
    <%--alert(name+ "不能为空");--%>
    <%--$("#"+id)[0].focus();--%>
    <%--return false;--%>
    <%--}--%>
    <%--return true;--%>
    <%--}--%>

    <%--</script>--%>
</head>
<body>
<div>
    <c:forEach items="${us}" var="u">
        <table>
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td><img height="40px" src="img/user/${u.id}.jpg"></td>
                <td><a href="admin_user_edit?id=${u.id}">编辑</a></td>
                <td><a href="admin_property_list?uid=${u.id}">属性</a></td>
                <td><a href="admin_user_delete?id=${u.id}">删除</a></td>
            </tr>
        </table>
    </c:forEach>
</div>

<div>

    <script>
        $(function () {
            $("ul.pagination li.disabled a").click(function () {
                return false;
            });
        });

    </script>

    <%--<nav>--%>
    <%--<ul class="pagination">--%>
    <%--<li>--%>
    <%--<a href="?start=0" aria-label="Previous">--%>
    <%--<span aria-hidden="true">«</span>--%>
    <%--</a>--%>
    <%--</li>--%>

    <%--<li>--%>
    <%--<a href="?start=${page.start-page.count}" aria-label="Previous">--%>
    <%--<span aria-hidden="true">‹</span>--%>
    <%--</a>--%>
    <%--</li>--%>

    <%--<c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">--%>
    <%--<li>--%>
    <%--<a href="?start=${status.index*page.count}" class="current">${status.count}</a>--%>
    <%--</li>--%>

    <%--</c:forEach>--%>

    <%--<li>--%>
    <%--<a href="?start=${page.start+page.count}" aria-label="Next">--%>
    <%--<span aria-hidden="true">›</span>--%>
    <%--</a>--%>
    <%--</li>--%>
    <%--<li>--%>
    <%--<a href="?start=${page.last}" aria-label="Next">--%>
    <%--<span aria-hidden="true">»</span>--%>
    <%--</a>--%>
    <%--</li>--%>
    <%--</ul>--%>
    <%--</nav>--%>


</div>
<div>
    <script>
        $(function () {
            $("ul.pagination li.disabled a").click(function () {
                return false;
            });
        });

    </script>

    <nav>
        <ul class="pagination">
            <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
                <a href="?start=0${page.param}" aria-label="Previous">
                    <span aria-hidden="true">«</span>
                </a>
            </li>

            <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
                <a href="?start=${page.start-page.count}${page.param}" aria-label="Previous">
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
<br>
<br>

<script>

    // function sub() {
    //     alert("1");
    //     var  name = document.getElementById("name1");
    //     var pic = document.getElementById("userPic");
    //     var  kk = 1 ;
    //     alert("2");
    //
    //     if (!(name != null && pic != null)) {
    //         alert("缺少数据");
    //
    //         self.location='listUser.jsp';
    //     };
    //    if( name == null  ){
    //        alert("queshi数据");
    //    }
        // alert("1111111");
        // if (pic != null) {
        //     alert("pic != null");
        // };
        // if(name!= 0){
        //     alert("name!= 0");
        // }
        // if(kk == 1){
        //     alert("5");
        // }

    };
</script>
<div>
    <div>新增分类</div>
    <div>
        <form method="post" id="addForm" action="admin_user_add" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>分类名称</td>
                    <td><input id="name" name="name" type="text"></td>
                </tr>
                <tr>
                    <td>分类图片</td>
                    <td><input id="userPic" accept="image/*" type="file" name="image"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <button type="submit" >提交</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
