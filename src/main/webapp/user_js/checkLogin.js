//验证是否登录
function checkLogin() {
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "checkLogin",
        //data:,
        success: function (result) {
            if (result.resultCode == 200) {
            	alert("请先登录！");
                window.location.href = "login.jsp";
            }
        },
        error: function () {
            alert("异常！");
        }
    });

}
