//登出操作
function logout() {
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "logout",
        //data:,
        success: function (result) {
            if (result.resultCode == 200) {
            	alert("退出成功！");
                window.location.href = "login.jsp";
            }
        },
        error: function () {
            alert("异常！");
        }
    });

}