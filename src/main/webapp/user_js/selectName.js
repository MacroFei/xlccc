function selectUserName() {
    var selectName = $("#user_id").val();
    var values = '';
    values = selectName;
    if(values == '') return ;
    location.href = 'selectUserName?values=' + values;
}