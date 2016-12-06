/*<div id='ss' style="width:200px">
</div>
<div id="box">
	<div data-optins="icon-ok">所有频道</div>
	<div id="sports">体育频道</div>
</div>*/
$(function(){
	$('#ss').searchbox({
		menu:'#box',
		searcher:function(name,value){
			
		},
		prompt:"请输入关键字",
		width:300,
		value:'固定的值',
		disabled:true,
		
	});
	var m=$('#ss').searchbox('menu');
	m.menu('setIcon',{
		target:m.menu('findItem','体育频道').target,
		iconCls:'icon-save',
	});
	console.log($('#ss').searchbox('textbox'));
	console.log($('#ss').searchbox('getValue'));
	$('#ss').searchbox('setValue',123);
	console.log($('#ss').searchbox('getName'));
	$('#ss').searchbox('selectName','sports');
	$('#ss').searchbox('clear')
	$('#ss').searchbox('reset')
});