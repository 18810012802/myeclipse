$(function(){
	$('#box').tabs({
		width:600,
		height:300,
		//plain:true,
		//fit :true,
		//border:false,
		tabWidth:50,
		scrollIncrement:100,
		scrollDuration:400,
		tabHeight:20,
		tools:[{
			iconCls:'icon-add',
			handler:function(){
				alert('add');
			},
		}],
		toolsPosition:'right',
		//tabPosition:'right',
		headerWidth:300,
		selected:1,
		closable:true,
		//showHeader:false,
		onSelect:function(title,index){
			alert(title+"  "+index);
		},
		onUnselect:function(title,index){
			
		},
		onBeforeClose:function(){
			
		},
		onClose:function(){
			
		},
		onContextMenu:function(e,title,index){
			alert(e.type);
		},
		onLoad:function(panel){
			alert(panel);
		}
		
	}).css('display','none');
	
	$(document).click(function(){
		$('#box').tabs().css('display','block');
		$('#box').tabs('resize');
		$('#box').tabs('add',{
			id:'bbb',
			title:'new',
			content:'new tab',
			href:'index2.jsp',
			iconCls:'icon-add',
			collapsible:true,
			closeable:true,
			selected:false,
		});
		$('#box').tabs('close',1);
		console.log($('#box').tabs('getTab',2));
		console.log($('#box').tabs('getTabIndex','#tab2'));
		console.log($('#box').tabs('getSelected'));
		

		
	});
});