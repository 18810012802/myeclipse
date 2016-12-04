$(function(){
	$.ajax({
		type : 'POST',
		dataType : 'json',
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
		dataType : 'json',
		url : 'SearchHouseServlet',
		data : {
			type : 'types',
		},
		success : function(msg) {
			for(var i=0;i<msg.length;i++){
				var ms=msg[i];
				$("#housetype").append("<option value="+ms.id+">"+ms.name+"</option>);");
			}
		}

	});
	$('#price').change(function(){
		window.location.href="SearchHouseServlet?type=list&price="+$(this).val();	
	});
	$('#street').change(function(){
		window.location.href="SearchHouseServlet?type=list&street="+$(this).val();	
	});
	$('#housetype').change(function(){
		window.location.href="SearchHouseServlet?type=list&housetype="+$(this).val();	
	});
	$('#floorage').change(function(){
		window.location.href="SearchHouseServlet?type=list&floorage="+$(this).val();	
	});
});