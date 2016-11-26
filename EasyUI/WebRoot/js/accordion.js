$(function(){
	$('#box').accordion({
		width:400,
		height:200,
		fit:true,
		animate:false,
		miltiple:true,
		selected:1,
		onSelect:function(title,index){
			alert(title+'|'+index);
		},
		onUnselect:function(title,index){
			alert(title+'|'+index);
		},
		onAdd:function(title,index){
			
		},
		onBeforeRemove:function(title,index){
			
		},
		onRemove:function(title,index){
			
		},
		
		
	}).hide();
	$(document).click(function(){
		$('#box').accordion().show();
		$('#box').accordion("resize");
		
	});
});