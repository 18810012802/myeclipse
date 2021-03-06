$(function() {
	$('#myform :input[name="title"]')
			.keyup(
					function() {
						var title = $('#myform :input[name="title"]').val();
						if (!/^[a-z0-9_-]{3,16}$/.test(title)) {
							$('#tit').remove();
							$('#myform :input[name="title"]')
									.after(
											"<span id='tit' style='color:red;'>请输入3到16位的字母数字中线或下划线！</span>");
						} else {
							$('#tit').remove();
						}
					});
	$('#myform :input[name="price"]')
			.keyup(
					function() {
						var price = $('#myform :input[name="price"]').val();
						if (!/^[1-9]{1}[0-9]{1,4}$/.test(price)) {
							$('#pri').remove();
							$('#myform :input[name="price"]')
									.after(
											"<span id='pri' style='color:red;'>请输入10到100000的数字！</span>");
						} else {
							$('#pri').remove();
						}
					});
	$('#myform :input[name="floorage"]')
			.keyup(
					function() {
						var floorage = $('#myform :input[name="floorage"]')
								.val();
						if (!/^[1-9]{1}[0-9]{1,4}$/.test(floorage)) {
							$('#flo').remove();
							$('#myform :input[name="floorage"]')
									.after(
											"<span id='flo' style='color:red;'>请输入10到10000的数字！</span>");
						} else {
							$('#flo').remove();
						}
					});
	$('#myform :input[name="houseDate"]')
			.keyup(
					function() {
						var houseDate = $('#myform :input[name="houseDate"]')
								.val();
						if (!/^[1-2]{1}[0-9]{3}-(([0][1-9])|([1][0-2]))-([0][1-9]|[1-2][0-9]|[3][0-1])$/
								.test(houseDate)) {
							$('#hou').remove();
							$('#myform :input[name="houseDate"]')
									.after(
											"<span id='hou' style='color:red;'>请输入类似“2016-11-11”的日期字串！</span>");
						} else {
							$('#hou').remove();
						}
					});
	$('#myform :input[name="contact"]')
			.keyup(
					function() {
						var contact = $('#myform :input[name="contact"]').val();
						if (!/^(\d{11}|\d{3,4}-\d{7,8}-\d{1,4})$/.test(contact)) {
							$('#con').remove();
							$('#myform :input[name="contact"]')
									.after(
											"<span id='con' style='color:red;'>请输入手机或座机号码！</span>");
						} else {
							$('#con').remove();
						}
					});
	var tid = $(":input[name='types_id']").val().trim();
	$.ajax({
		type : 'POST',
		dataType : 'json',
		url : 'SearchHouseServlet',
		data : {
			type : 'types',
		},
		success : function(msg) {

			for ( var i = 0; i < msg.length; i++) {
				var ms = msg[i];
				$("#types").append(
						"<option value=" + ms.id + ">" + ms.name
								+ "</option>);");
				// value="${msg.street.district.id }"
			}
			$("#types").val(tid);
		}
	});

	$.post("SearchHouseServlet", {
		type : 'district'
	}, function(msg) {

		var did = $(":input[name='dis_id']").val().trim();
		var sid = $(":input[name='str_id']").val().trim();
		for ( var i = 0; i < msg.length; i++) {
			var ms = msg[i];
			$("#district_id").append(
					"<option value=" + ms.id + ">" + ms.name + "</option>);");
		}
		$("#district_id").val(did);
		$.post("SearchHouseServlet", {
			type : 'streetById',
			id : did
		}, function(result) {
			$("#street_id").find("option").remove();
			/*
			 * if(result.length==0){ $("#street_id").append("<option
			 * value="+no+">"+data.name+"</option>"); }
			 */
			for ( var i = 0; i < result.length; i++) {
				var data = result[i];
				$("#street_id").append(
						"<option value=" + data.id + ">" + data.name
								+ "</option>");
			}
			$("#street_id").val(sid);
		}, "json");
	}, "json");

	$("#district_id").change(
			function() {
				var val = $(this).val();
				// if(val!='0'){
				$("#street_id").find("option").remove();
				$.post("SearchHouseServlet", {
					type : 'streetById',
					id : val
				}, function(result) {
					for ( var i = 0; i < result.length; i++) {
						var data = result[i];
						$("#street_id").append(
								"<option value=" + data.id + ">" + data.name
										+ "</option>");
					}
				}, "json");

			});
});