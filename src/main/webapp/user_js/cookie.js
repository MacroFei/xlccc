function setCookie(name, value) {
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}


function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    //console.log(document.cookie.match(reg))
    if (arr = document.cookie.match(reg)){
        return unescape(arr[2]);
    }
    else
        return null;
}


function getValue(){
    var role = getCookie("role");
    var name = getCookie("name");
    var item ;
    if (role != "1"){
        item="<a href=\'user_list\'>"
        item+="管理员管理"
        item+="</a>"
        $("#role").append(item);
    }

    if (name != null){
        $("#name").html(name);
    }
}

