/*<input id="ss"/>

<div id="food">
	<div style="background:#eee;padding:5px;">请选择</div>
	<div style="padding:5px;">
		<input type="radio" name="food" value="01"><span>煎饼果子</span><br/>
		<input type="radio" name="food" value="02"><span>牛腩米线</span><br/>
		<input type="radio" name="food" value="03"><span>水果沙拉</span><br/>
		<input type="radio" name="food" value="04"><span>其他</span><br/>
		
	</div>
</div>*/
$(function(){
	$('#ss').combo({
		required:true,
		width:300,
		height:50,
		panelWidth:300,
		editable:false,
		//readonly:true,//还可以发送值
		//disabled:true,
		//hasDownArrow:true,
		//value:'123',
		//delay:100,
		onShowPanel:function(){
			
		},
		onHidePanel:function(){
			
		},
		onChange:function(newValue,oldValue){
			
		},
	});
	$('#food').appendTo($('#ss').combo('panel'));
	$('#food input').click(function(){
		var v=$(this).val();
		var s=$(this).next('span').text();
		$('#ss').combo('setValue',v);
		$('#ss').combo('setText',s).combo('hidePanel');
		alert(v+s);
		
	});
	$('#ss').combo('resize','width');
});