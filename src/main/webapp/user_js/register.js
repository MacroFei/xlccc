//用户注册
function register() {
	var numasc = 0;
    var charasc = 0;
    var otherasc = 0;
	var pattern = /^0(([1,2]\d)|([3-9]\d{2}))\d{7,8}$/;
	var userName = $("#user_name").val();
	var password = $("#user_password").val();
	var category = $("#user_category").val();
	var phone = $("#user_phone").val();
	var email = $("#user_email").val();
	var region = $("#user_region").val();
	var data = {
		"name" : userName,
		"password" : password,
		"category" : category,
		"phone" : phone,
		"email" : email,
		"area" : region
	}

	if (userName == null || userName == "") {
		alert("用户名不能为空！");
		return;
	}else if(!/^[0-9a-zA-Z]+$/.test(userName)){
			alert("用户名只能包含英文和数字！");
			return;
	}
	
	if (password == null || password == "") {
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
	if (phone ==null||phone=="") {
        alert("手机号码不能为空");
        return;
      } else if (phone.length != 11 || !/^1[3|4|5|6|7|8|9]\d{9}$/.test(phone)) {
        alert("手机号码格式不正确");
        return;
      } //手机号已被注册提示信息
	$.ajax({
		type : "POST",// 方法类型
		dataType : "json",// 预期服务器返回的数据类型
		url : "register",// url
		data : data,
		success : function(result) {
			console.log(result);// 打印服务端返回的数据
			if (result.resultCode == 200) {
				window.location.href = "user_list";
			} else {
				alert("用户名已存在");
				return;
			}
			;
		},
		error : function() {
			    alert("操作失败!");
			    return;
		}
	});
}