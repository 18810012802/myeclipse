$(function(){
	$('#edit')pagination({
		total:5,
		pageSize:1,
		pageNumber:1,
		pageList:[1,2],
		onSelectPage:function(pageNumber,pageSize){
			$("#box").pagination('loading');
			$('#content').panel('refresh','user.php?'+pageNumber+'&pageSize='+pageSize)
			$("#box").pagination('loaded');
		},
		buttons:[{iconCls:'icon-add',
			
		},'-',{
			iconCls:'icon-edit',
		}],
		layout:['first','prev','next','last','links'],
		showPageList:false,
		showRefresh:false,
		beforePageText:'第',
		afterPageText:'共{pages}个',
		displayMag:'从{from}to{to}，有{total}人',
		onBeforeRefresh:function(pageNumber,pageSize){
			
		},
		onRefresh:function(pageNumber,pageSize){
			
		},
		onChangePageSize:function(pageSize){
			
		},
		
	});
	$("#box").pagination('select',1);
	$("#box").pagination('refresh',{
		pageSize:2,
		pageNumber:2,
		
	})
});