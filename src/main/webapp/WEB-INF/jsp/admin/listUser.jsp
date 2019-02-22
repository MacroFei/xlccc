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
    <title>Title</title>

    <script>
        function checkEmpty(id, name){
            var value = $("#"+id).val();
            if(value.length==0){
                alert(name+ "不能为空");
                $("#"+id)[0].focus();
                return false;
            }
            return true;
        }
        // function checkNumber(id, name){
        //     var value = $("#"+id).val();
        //     if(value.length==0){
        //         alert(name+ "不能为空");
        //         $("#"+id)[0].focus();
        //         return false;
        //     }
        //     if(isNaN(value)){
        //         alert(name+ "必须是数字");
        //         $("#"+id)[0].focus();
        //         return false;
        //     }
        //
        //     return true;
        // }
        // function checkInt(id, name){
        //     var value = $("#"+id).val();
        //     if(value.length==0){
        //         alert(name+ "不能为空");
        //         $("#"+id)[0].focus();
        //         return false;
        //     }
        //     if(parseInt(value)!=value){
        //         alert(name+ "必须是整数");
        //         $("#"+id)[0].focus();
        //         return false;
        //     }

            // return true;
        // }
        //
        //
        // $(function(){
        //     $("a").click(function(){
        //         var deleteLink = $(this).attr("deleteLink");
        //         console.log(deleteLink);
        //         if("true"==deleteLink){
        //             var confirmDelete = confirm("确认要删除");
        //             if(confirmDelete)
        //                 return true;
        //             return false;
        //
        //         }
        //     });
        // })
    </script>
</head>
<body>
<h1>hello demo</h1>
<div>
    <c:forEach items="${us}" var="u">
        <table>
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td><img height="40px" src="img/user/${u.id}.jpg"></td>
                <td><a href="admin_user_edit?id=${u.id}">编辑</a></td>
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

    <nav>
        <ul class="pagination">
            <li>
                <a href="?start=0" aria-label="Previous">
                    <span aria-hidden="true">«</span>
                </a>
            </li>

            <li>
                <a href="?start=${page.start-page.count}" aria-label="Previous">
                    <span aria-hidden="true">‹</span>
                </a>
            </li>

            <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
                <li>
                    <a href="?start=${status.index*page.count}" class="current">${status.count}</a>
                </li>

            </c:forEach>

            <li>
                <a href="?start=${page.start+page.count}" aria-label="Next">
                    <span aria-hidden="true">›</span>
                </a>
            </li>
            <li>
                <a href="?start=${page.last}" aria-label="Next">
                    <span aria-hidden="true">»</span>
                </a>
            </li>
        </ul>
    </nav>


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
    $(function () {
        $("#addForm").submit(function(){
            if(!checkEmpty("name","分类名称"))
                return false;
            if(!checkEmpty("userPic","分类图片"))
                return false;
            return true;
        })
    })
</script>
<div class="panel panel-warning addDiv">
    <div class="panel-heading">新增分类</div>
    <div class="panel-body">
        <form method="post" id="addForm" action="admin_user_add" enctype="multipart/form-data">
            <table class="addTable">
                <tr>
                    <td>分类名称</td>
                    <td><input id="name" name="name" type="text" class="form-control"></td>
                </tr>
                <tr>
                    <td>分类图片</td>
                    <td><input id="userPic" accept="image/*" type="file" name="image"></td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <button type="submit" class="btn btn-success">提交</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
