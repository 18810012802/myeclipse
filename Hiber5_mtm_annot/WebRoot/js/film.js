$(function(){
	$.ajax({
		type : 'POST',
		url : 'FilmServlet',
		data : {
			type : 'filmType',
		},
		success : function(msgs) {
			//alert(msg);
			msg=eval("("+msgs+")");
			for(var i=0;i<msg.length;i++){
				var ms=msg[i];
				$("#filmType").append("<option value="+ms.typeId+">"+ms.typeName+"</option>);");
				$("#filmType1").append("<option value="+ms.typeId+">"+ms.typeName+"</option>);");
			}
		}
	});
	$('#queryform:input[name="minticketprice"]')
	.keyup(
			function() {
				var minticketprice = $('#queryform :input[name="minticketprice"]')
						.val();
				if (!/^[1-9]{1}[0-9]{1,4}$/.test(minticketprice)) {
					$('#q1').remove();
					$('#queryform :input[name="floorage"]')
							.after(
									"<span id='q1' style='color:red;'>请输入10到10000的数字！</span>");
				} else {
					$('#q1').remove();
				}
			});
});

