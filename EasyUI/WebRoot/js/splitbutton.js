/*<a href="javascript:void(0)"
	id="edit"
	class="easyui-splitbutton"
	data-options="iconCls:'icon-edit',menu:'#box'">編輯</a>
<div id="box" style="width:150px">
	<div>剪切</div>
	<div>複製</div>
	<div class="menu-sep"></div>
	<div>粘貼</div>
	<div data-options="iconCls:'icon-remove'">刪除</div>	
</div>*/

$(function(){
	$('#edit')splitbutton({
		menu:'#box',
		iconCls:'icon-edit',
		plain:false,
		duration:500,
	});
	console.log($('#edit').splitbutton("options"));
});