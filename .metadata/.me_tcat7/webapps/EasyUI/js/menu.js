/*<div id="box" class="easyui-menu" data-options="left:10,top:10,minWidth:120,hideOnUnhover:false">
	<div id="new">新建</div>
	<div>打開
		<div id="word">word</div>
		<div>Excel</div>
		<div id="ppt">ppt</div>
	</div>
	<div data-options="iconCls:'icon-save'">保存</div>
	<div>退出</div>
</div>*/
$(function(){
	$(document).on('contextmenu',function(e){
		e.preventDefault();
		//$('#box').menu('hide');
		$('#box').menu('show',{
			left:e.pageX,
			top:e.pageY,
		});
		//$('#box').menu('destroy');
		console.log($('#box').menu('getItem','#new').id);
		$('#box').menu('setText',{
			target:'#new',
			text:'新新',
		});
		$('#box').menu('setIcon',{
			target:'#new',
			iconCls:'icon-add',
		});
		console.log($('#box').menu('findItem','退出'));
		$('#box').menu('appendItem',{
			id:'add',
			text:'新增',
			iconCls:'icon-add',
			href:'123.html',
			onclick:function(){
			
			}
		});
		$('#box').menu('removeItem','#ppt');
		$('#box').menu('disableItem','#word');
		$('#box').menu({
			onShow:function(){
				
			},
			onHide:function(){
				
			},
			onClick:function(item){
				alert(item.text);
			}
		});
	});
	
	
});