$(function(){
	$.messager.defaults = {
		ok:'是',
		cancel:'否'
	};
	
	$.messager.alert('警告框','这是一个提示！','info',function(){
		alert('警告');
	});
	$.messager.confirm('确认框','你真的要删除吗',function(flag){
		if(flag){
			alert('删除成功');
		}
	});
	$.messager.prompt('提升框','请输入你的名字！',function(content){
		if(content){
			alert(content);
		}
	});
	/*$.messager.progress({
		title:'执行中',
		msg:'努力上传中',
		text:'{value}%',
		interval:100,
		closable:true,
		timeout:2000,
		
		
	});*/
	//console.log($.messager.progress('bar'));
	//console.log($.messager.progress('close'));
	$.messager.show({
		title:'我的消息',
		msg:'消息5秒关闭',
		timeout:5000,
		showType:'fade',
		style:{
			top:0,
		},
		
	});
	
	
});
	