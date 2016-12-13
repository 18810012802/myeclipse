$(function(){
	$(document.body).css( "background", "pink" );
	$("<div>", {
		  text: "Click me!",
		  click: function(){
		    $(this).css("backgroundColor","green");
		  }
		}).appendTo("body");
	$("#myform :input[name='name']").keyup(function(){
		var $name=$(this).val();
		$.ajax({
			url:'PublishServlet',
			data:{
				name:$name,
				type:'ifexist'
			},
			success:function(msg){
				if(msg!='0'){
					$("#tip1").remove();
					$("#myform :input[name='name']").after("<span id='tip1' style='color:red;'>用户已存在！</span>");
				}else{
					$("#tip1").remove();
					$("#myform :input[name='name']").after("<span id='tip1' style='color:green;'>用户名OK！</span>");
				}
				
			}
		});
	});
	$.post("PublishServlet",{type:'users'},function(msg){
			for(var i=0;i<msg.length;i++){
				var m=msg[i];
				$("#mytable").append("<tr><td>"+m.id+"</td><td>"+m.name+"</td><td>"+m.telephone+"</td></tr>");
			}
	},'json');
	
	
});