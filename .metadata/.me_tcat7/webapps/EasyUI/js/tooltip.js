$(function(){
	$('#tooltip').tooltip({
		content:"这是内容提示框",
		position:'top',
		trackMouse:true,
		deltaX:10,
		//showEvent:'click',
		//hideEvent:'dblclick',
		showDelay:500,
		hideDelay:0,
		onShow:function(e){
			console.log($(this).tooltip('arrow'));
		},
		onHide:function(e){
			(this).tooltip('reposition');
		},
		onUpdate:function(content){
			alert("内容变成"+content);
		},
		onPosition:function(left,top){
			//console.log("left="+left+",top="+top);
			
		},
		onDestroy:function(e){
			alert("销毁了")
		}
		
	});
	$('#tooltip').click(function(){
		//$(this).tooltip('update','内容改变了');
		$(this).tooltip('destroy');
	});
	$('#tooltip').dblclick(function(){
		$(this).tooltip('destroy');
		
	});
	//$(this).tooltip('show');
	//$(this).tooltip('hide');
	
	
})