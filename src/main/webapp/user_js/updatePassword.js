//修改密码
function updatePassword(updatePassword) {
    setCookie("updatePasswordId", updatePassword);
}

function getPassword(){
    var updatePasswordId = getCookie("updatePasswordId");
    var numasc = 0;
    var charasc = 0;
    var otherasc = 0;
    var password = $("#password").val();
    var newPassword = $("#newPassword").val();
    if (password == null || password == "") {
        alert("密码不能为空！");
        return;
    }if (password == null || password == "") {
        alert("密码不能为空！");
        return;
    }else if(password.length<8||password.length>16){
        alert("密码至少8个字符,最多16个字符");
        return;
    }else{
        for (var i = 0; i < password.length; i++) {
            var asciiNumber = password.substr(i, 1).charCodeAt();
            if (asciiNumber >= 48 && asciiNumber <= 57) {
                numasc += 1;
            }
            if ((asciiNumber >= 65 && asciiNumber <= 90)||(asciiNumber >= 97 && asciiNumber <= 122)) {
                charasc += 1;
            }
            if ((asciiNumber >= 33 && asciiNumber <= 47)||(asciiNumber >= 58 && asciiNumber <= 64)||(asciiNumber >= 91 && asciiNumber <= 96)||(asciiNumber >= 123 && asciiNumber <= 126)) {
                otherasc += 1;
            }
        }
        if(0==numasc)  {
            alert("密码必须含有数字");
            return;
        }else if(0==charasc){
            alert("密码必须含有字母");
            return;
        }
    }
    if (newPassword == null || newPassword == "") {
        alert("确认密码不能为空！");
        return;
    }else if(newPassword.length<8||newPassword.length>16){
        alert("确认密码至少8个字符,最多16个字符");
        return;
    }else{
        for (var i = 0; i < newPassword.length; i++) {
            var asciiNumber = newPassword.substr(i, 1).charCodeAt();
            if (asciiNumber >= 48 && asciiNumber <= 57) {
                numasc += 1;
            }
            if ((asciiNumber >= 65 && asciiNumber <= 90)||(asciiNumber >= 97 && asciiNumber <= 122)) {
                charasc += 1;
            }
            if ((asciiNumber >= 33 && asciiNumber <= 47)||(asciiNumber >= 58 && asciiNumber <= 64)||(asciiNumber >= 91 && asciiNumber <= 96)||(asciiNumber >= 123 && asciiNumber <= 126)) {
                otherasc += 1;
            }
        }
        if(0==numasc)  {
            alert("确认密码必须含有数字");
            return;
        }else if(0==charasc){
            alert("确认密码必须含有字母");
            return;
        }
    }
    if (password != newPassword) {
        alert("密码不一致！");
        return;
    }

    var data = {
        "id" : updatePasswordId,
        "password" : password
    }

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "update_password",
        data: data,
        success: function (result) {
            if (result.resultCode == 200) {
                alert("修改成功！")
                window.location.href = "user_list";
            }else {
                alert("异常！");
                return;
            }
        },
        error: function () {
            alert("异常！");
        }
    });
}