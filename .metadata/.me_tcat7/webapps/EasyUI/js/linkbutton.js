$(function(){
	$('#box').linkbutton({
		//id:'pox',
		toggle:true,
		group:'sex',
		plain:true,
		text:'文字',
		iconCls:'icon-add',
		iconAlign:'right',
		
		
	});
	$('#pox').linkbutton({
		//id:'pox',
		toggle:true,
		group:'sex',
		iconCls:'icon-mini-add',
		
	});
	$('#box').linkbutton('enable');
});