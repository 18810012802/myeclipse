$(function(){
	$('#myform :input[name="name"]').keyup(function(){
		var name=$('#myform :input[name="name"]').val();
		$.ajax({
			type : 'POST',
			url : 'SearchHouseServlet',
			data : {
				type : 'uniqueName',
				name : name
			},
			success : function(msg) {
				$('#pa').remove();
				$('#myform :input[name="name"]').after(msg);
			}

		});
	});
	$('#myform :input[name="password"]').keyup(function(){
		var name=$('#myform :input[name="name"]').val();
		if(name.trim()==""){
			$('#pa').remove();
			$('#myform :input[name="name"]').after("<span id='pa' style='color:red;'>用户名不能为空！</span>");
		}
	});
	$('#myform :input[name="repassword"]').keyup(function(){
		var repassword=$('#myform :input[name="repassword"]').val();
		var password=$('#myform :input[name="password"]').val();
		if(repassword.trim()!="" && repassword!=password){
			$('#repa').remove();
			$('#myform :input[name="repassword"]').after("<span id='repa' style='color:red;'>密码输入不一致！</span>");
		}else if(password.trim()==""){
			$('#pass').remove();
			$('#myform :input[name="password"]').after("<span id='pass' style='color:red;'>密码不能为空！</span>");
		}else if(repassword==password){
			$('#repa').remove();
			$('#myform :input[name="repassword"]').after("<span id='repa' style='color:green;'>密码输入正确！</span>");
		}
	});
	/*$('#myform :input[name="repassword"]').focus(function(){
		$(this).attr("data-oval",$(this).val);
		
	}).blur(function(){
		var oldVal=($(this).attr("data-oval"));
		var newVal=($(this).val());
		if(oldVal!=newVal){
			alert(newVal);
		}
	});*/
});