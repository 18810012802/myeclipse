$(function(){
	$('#box').window({
		modal:true,
		width:600,
		height:400,
		title:'窗口',
		collapsible:false,
		minimizable:false,
		maximizable:false,
		closable:false,
		closed:true,
		zIndex:9999,
		draggable:true,
		resizable:false,
		shadow:false,
		inline:true,
		
		
		
	});
	$(document).click(function(){
		$('#box').window('move',{
			left:0,
			top:0,
		});
	});
	$(document).dblclick(function(){
		$('#box').window('center');
	});
});