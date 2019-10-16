//查询省份
function selectSheng() {
	var item;
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "selectSheng",
        success: function (result) {
        	item="<option value=''>"
    		item+=""
    		item+="</option>"
			$.each(result,function(i, result) {
				                              
				item+="<option value=''>"
				item+=result['province']
				item+="</option>"
					
			});
        	$("#selectSheng").append(item);
        },
        error: function () {
            alert("异常！");
        }
    });

}

//查询市区
function selectShi() {
	var selectSheng = document.getElementById("selectSheng");
	var value = selectSheng.options[selectSheng.selectedIndex].text;
	var item;
	
	var data = {
		        "province" : value
		   }
	
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "selectShi",
        data: data,
        success: function (result) {
        	item="<option value=''>"
			item+=""
			item+="</option>"	
			$.each(result,function(i, result) {
				item+="<option value=''>"
				item+=result['city']
				item+="</option>"		
			});
        	
        	$("#selectShi").html(item);
        },
        error: function () {
            alert("异常！");
        }
    });

}

//查询区/镇
function selectQu() {
	var selectSheng = document.getElementById("selectSheng");
	var value_1 = selectSheng.options[selectSheng.selectedIndex].text;
	
	var selectShi = document.getElementById("selectShi");
	var value_2 = selectShi.options[selectShi.selectedIndex].text;
	var item;
	
	var data = {
		        "province" : value_1,
		        "city" : value_2
		   }
	
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "selectQu",
        data: data,
        success: function (result) {
        	item="<option value=''>"
			item+=""
			item+="</option>"	
			$.each(result,function(i, result) {
				item+="<option value=''>"
				item+=result['district']
				item+="</option>"		
			});
        	
        	$("#selectQu").html(item);
        },
        error: function () {
            alert("异常！");
        }
    });
}

//查询品种
function selectName() {
	var selectSheng = document.getElementById("selectSheng");
	var value_1 = selectSheng.options[selectSheng.selectedIndex].text;
	
	var selectShi = document.getElementById("selectShi");
	var value_2 = selectShi.options[selectShi.selectedIndex].text;
	
	var selectQu = document.getElementById("selectQu");
	var value_3 = selectQu.options[selectQu.selectedIndex].text;
	
	var item;
	
	var data = {
			 	"province" : value_1,
		        "city" : value_2,
		        "district" : value_3
		   }
	
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "selectName",
        data: data,
        success: function (result) {
        	item="<option value=''>"
			item+=""
			item+="</option>"	
			$.each(result,function(i, result) {
				item+="<option value=''>"
				item+=result['variety']
				item+="</option>"		
			});
        	
        	$("#selectName").html(item);
        },
        error: function () {
            alert("异常！");
        }
    });
}
//根据四个信息查询
function selectSSQN(){
    var selectSheng = document.getElementById("selectSheng");
    var value_1 = selectSheng.options[selectSheng.selectedIndex].text;

    var selectShi = document.getElementById("selectShi");
    var value_2 = selectShi.options[selectShi.selectedIndex].text;

    var selectQu = document.getElementById("selectQu");
    var value_3 = selectQu.options[selectQu.selectedIndex].text;

    var selectName = document.getElementById("selectName");
    var value_4 = selectName.options[selectName.selectedIndex].text;

    if (value_1 == ""){
        value_1 = "kong";
    }
    if (value_2 == ""){
        value_2 = "kong";
    }
    if (value_3 == ""){
        value_3 = "kong";
    }
    if (value_4 == ""){
        value_4 = "kong";
    }

    var values = '';
    values = value_1+","+value_2+","+value_3+","+value_4;
    if(values == '') return ;
    location.href = 'crop_selectSSQN?values=' + values;
}