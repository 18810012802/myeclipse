/*<div id="box" style="width:600px;height:400px;">
	<div data-options="region:'north',
	title:'上北',
	border:true,
	split:true,
	iconCls:'icon-save',
	href:'index2.jsp',
	collapsible:true,
	
	" style="height:100px;">tab1</div>
	<div data-options="region:'west',title:'左西'" style="width:100px;">tab2</div>
	<div data-options="region:'east',title:'右东'" style="width:100px;">tab3</div>
	<div data-options="region:'south',title:'下南'" style="height:100px;">tab4</div>
	<div data-options="region:'center',title:'中间'" >tab5</div>
	
</div>*/
$(function(){
	$('#box').layout({
		fit:true,
		
	
	});
	$('#box').layout('collapse','north');
	$('#box').layout('remove','north');
});