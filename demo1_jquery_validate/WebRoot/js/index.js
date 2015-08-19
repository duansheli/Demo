var valdate_message={
	username : {  
    required : "请输入姓名",  
    minlength : "最小长度5",  
    maxlength : "最大长度10",  
    remote : "用户名已存在"  
},  
password : {  
    required : "请输入密码",  
    rangelength : "长度5-10之间的数字或字母"  
},  
repassword : {  
    required : "请输入确认密码",  
    rangelength : "长度5-10之间的数字或字母",  
    equalTo : "两次密码不一样"  
},  
email : {  
    required : "请输入邮箱",  
    email : "邮箱格式不正确"  
}
};
var valdate_rules={
		username : {
            required : true,  
            minlength : 5,  
            maxlength : 10,  
            remote : {  
                url : "checkAction.action",  
                type : "post"  
            /* 
             * dataType:'json', data:{ name:function(){ return 
             * $("#name").val(); } } 
             */  
            }  
        },  
        password : {  
            required : true,  
            rangelength : [ 5, 10 ]  
        },  
        repassword : {  
            required : true,  
            rangelength : [ 5, 10 ],  
            //equalTo : "#password"  
            equalTo:"input[type='repwd']"  
        },  
        email : {  
            required : true,  
            email : true  
        }
};

$(function() {
$("#userInfo").validate({
//调试模式校验，不提交表单
debug:true,
//表单规则
rules : valdate_rules,
//错误信息
messages : valdate_message
});

});