$(function(){
	$.ajax({
		type : 'POST',
		url : 'SearchHouseServlet',
		data : {
			type : 'street',
		},
		success : function(msg) {
			for(var i=0;i<msg.length;i++){
				var ms=msg[i];
				$("#street").append("<option value="+ms.id+">"+ms.name+"</option>);");
			}
		}
	});
	$.ajax({
		type : 'POST',
		url : 'SearchHouseServlet',
		data : {
			type : 'types',
		},
		success : function(msg) {
			for(var i=0;i<msg.length;i++){
				var ms=msg[i];
				$("#houseType").append("<option value="+ms.id+">"+ms.name+"</option>);");
			}
		}

	});
});