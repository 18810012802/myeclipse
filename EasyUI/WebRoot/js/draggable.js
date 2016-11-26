$(function(){
	$.fn.draggable.defaults.cursor='text';
	$('#box').draggable({
		revert:true,
		//cursor:'text',
		//handle:'#pox',
		//disabled:true,
		edge:10,
		//axis:'v',
		/*proxy:'clone',
		deltaX:0,
		deltaY:0,*/
		proxy:function(source){
			var p=$('<div style="border:2px solid red;width:400px;height:200px;"></div>');
			p.html($(source).html()).appendTo('body');
			return p;
		},
		/*onBeforeDrag:function(e){
			alert('拖动前触发');
		},*/
		onStartDrag:function(e){
			//alert('拖动开始触发');
			console.log($('#box').draggable('proxy'));
		},
		/*onDrag:function(e){
			alert('拖动过程');
		},*/
		/*onStopDrag:function(e){
			alert('拖动结束触发');
		},*/
						
	});
	console.log($('#box').draggable('options'));
	
})