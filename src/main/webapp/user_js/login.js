//登录操作
function login() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    if (userName == null || userName == "") {
        alert("用户名不能为空！");
        return;
    }
    if (password == null || password == "") {
        alert("密码不能为空！");
        return;
    }

    var data = {
        "name" : userName,
        "password" : password
    }

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "login",
        data: data,
        success: function (result) {
            if (result.resultCode == 200) {
                setCookie("role", result.data.role);
                setCookie("name", result.data.name);
                window.location.href = "index.jsp";
            }else {
                alert("用户名或密码错误！");
                return;
            }
        },
        error: function () {
            alert("异常！");
        }
    });

}