$(function(){
	$.fn.resizable.defaults.disabled=false;
	$('#box').resizable({
		handles:'e,se',
		minWidth:200,
		maxHeight:600,
		edge:50,
		onStartResize:function(e){
			
		},
		onResize:function(e){
			//return false;
		},
		onStopResize:function(e){
			
		},
	});
})