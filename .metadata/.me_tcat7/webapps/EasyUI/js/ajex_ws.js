$(function(){
	var content=$('input:text').val();
	$("#btn").click(function(){
		alert(content+"---");
		$.ajax({
			type: "post",//使用get方法访问后台
			dataType: "xml",//返回json格式的数据
			url: "http://localhost:6666/ws",//要访问的后台地址
			data: '<?xml version="1.0" encoding="utf-8"?>'+
					'<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" '+
					'xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">'+
					 ' <soap:Body>'+
					    '<q0:sayHello>'+
					     ' <arg0>'+content+'</arg0>'+
					    '</q0:sayHello>'+
					  '</soap:Body>'+
					'</soap:Envelope>',//要发送的数据
			contentType:"text/xml;charset=utf-8",
			success: function(msg){//msg为返回的数据，在这里做数据绑定
				alert($(msg),find("return").text());
			},
			error:function(e){
				debugger
				alert(e);
			},
		});
	});
	
});