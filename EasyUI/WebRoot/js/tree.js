$(function(){
	$('#box').tree({
		animate : true,
		checkbox : true,
		cascadeCheck : false,
		onlyLeafCheck : true,
		lines : true,
		dnd : true,
		//url : "PublishServlet?type=tree",
		data : [
			{
				"text" : "系统管理",
				"children" : [
		              {
		            	  "text" : "版本信息"
		              },
		              {
		            	  "text" : "数据库信息"
		              }
		              ]
			
			},
			{
				"text" : "会员管理",
				"children" : [
						{
							  "text" : "新增会员"
						},
						{
							  "text" : "审核会员"
						}
		              ]
			}
		],
		formatter : function(node){
			return node.text;
		},
		onContextMenu :function(e){
			e.preventDefault();
			$('#box').tree('select',node.target);
			$('#menu').menu('show',{
				left:e.pageX,
				top:e.pageY
			});
		},
		
		onDrop : function(target,source,point){
			alert(target+"/"+source+"/"+point);
		}
		
	});
});