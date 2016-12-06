/*<table id="table">
		<!--  <thead>
    	<tr>
    		<th data-options="field:'user'">账号</th>
    		
    	</tr>
   	</thead>
   	<tbody>
   		<tr>
   			<td>蜡笔小新</td>
   		</tr>
   	</tbody> -->
	</table>
	<div id="menu" class="easyui-menu" style="width:120px;display:none;">
		<div onclick="" iconCls="icon-add">增加</div>
		<div onclick="" iconCls="icon-remove">删除</div>
		<div onclick="" iconCls="icon-edit">修改</div>
	</div>
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
				onclick="obj.add()">添加</a> <a href="#" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="obj.update()">修改</a> <a
				href="#" class="easyui-linkbutton" iconCls="icon-remove"
				plain="true" onclick="obj.del()">删除</a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-edit" plain="true"
				onclick="obj.save()" style="display:none;" id="save">保存</a> <a
				href="#" class="easyui-linkbutton" iconCls="icon-remove"
				plain="true" onclick="obj.redo()" style="display:none;" id="redo">取消</a>
		</div>
		<div style="padding:0 0 0 7px">
			查询车次:<input class="textbox" name="trainNo" style="width:110px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search"
				onclick="obj.search();">查询</a>
		</div>
	</div>*/

$(function(){
	obj={
		editRow:undefined,
		search:function(){
			$('#table').datagrid('load',{
				user:$.trim($('input[name="user"]').val()),
			});
		},
		add:function(){
			if(this.editRow == undefined){
				$('#save,#redo').show();
				$('#table').datagrid("appendRow",{
				});
				$('#table').datagrid("insertRow",{
					index:0,
					row:{
					}
				});
				$('#table').datagrid("beginEdit",0);
				this.editRow = 0;
			}
		},
		save:function(){
			$('#table').datagrid("endEdit",this.editRow);
		},
		redo:function(){
			this.editRow=undefined;
			$('#save,#redo').hide();
			$('#table').datagrid("rejectChanges");
		},
		update:function(){
			var rows = $('#table').datagrid('getSelections');
			if(rows.length == 1){
				if(this.editRow == undefined){
					alert("kdiho");
					var index = $('#table').datagrid('getRowIndex',rows[0]);
					$('#table').datagrid('beginEdit',rowIndex);
					this.editRow = rowIndex;
					$('#save,#redo').show();
					$('#table').datagrid('unselectRow',index);
				}
				if(this.editRow != undefined){
					$('#table').datagrid('endEdit',this.editRow);
					//obj.editRow=undefined;
				}
			}else{
				$.message.alert('警告','修改必须且只能有一行','warnning');
			}
		},
		del : function(){
			var rows = $('#table').datagrid('getSelections');
			if(rows.length > 0){
				$.messager.confirm('确定操作','确定要删除吗？',function(flag){
					if(flag){
						var ids=[];
						for(var i=0;i<rows.length;i++){
							ids.push(rows[i].id);
						}
						$.ajax({
							type : 'POST',
							url : 'PublishServlet',
							data : {
								type : "del",
								ids : ids.join(','),
							},
							beforeSend : function(){
								$('#table').datagrid('loading');
							},
							success : function(msg){
									$('#table').datagrid('loaded');
									$('#table').datagrid('load');
									$('#table').datagrid('unselectAll');
									$.messager.show({
										title : "提示",
										msg : msg,
									});
									obj.editRow = undefined;
							}
						});
					}
				});
			}else{
				$.messager.alert('提示','请选择要删除的记录！','info');
			}
		},
	};
	$('#table').datagrid({
		width : 600,
		url : 'PublishServlet',
		title : '用户列表',
		inconCls : 'icon-search',
		pagination:true,
		pageSize : 5,
		pageList : [5,10,15],
		//pageNumber : 1,
		pagePosition : 'bottom',
		sortName : 'email',
		sortOrder : 'DESC',
		remoteSort:false,
		//multiSort:true,
		striped:true,
		nowrap:false,
		fitColumns:true,
		data:[{
			user:"user",
			email:"email"
		}],
		loadMsg:"玩命加载中",
		rownumbers:true,
		singleSelect:true,
		showHeader:true,
		showFooter:true,
		scrollbarSize:20,
		fitColumns : true,
		
		frozenColumns : [[
		                  {
		                	  
		                  }
		                  
		                  ]],
		rowStyler:function(index,row){
			if(row.user == 'f'){
				return "background-color:orange";
			}
		},
		toolbar:"#tb",
		onAfterEdit:function(rowIndex,rowData,changes){
			
			$('#save,#redo').hide();
			console.log(rowData);
			var inserted = $('#table').datagrid('getChanges','inserted');
			var updated = $('#table').datagrid('getChanges','updated');
			var type="";
			var tip="";
			if(inserted.length > 0){
				type="add";
				tip="添加了";
			}else if(updated.length > 0){
				type="update";
				tip="修改了";
			}
			rowData.type=type;
			$.ajax({
				type : 'POST',
				url : 'PublishServlet',
				data : rowData,
				beforeSend : function(){
					$('#table').datagrid('loading');
				},
				success : function(msg){
						$('#table').datagrid('loaded');
						$('#table').datagrid('load');
						$('#table').datagrid('unselectAll');
						$.messager.show({
							title : "提示",
							msg : msg+"条数据!",
							
						});
					obj.editRow = undefined;
				}
			});
		},
		onDblClickRow:function(rowIndex,rowData){
			if(obj.editRow != undefined){
				$('#table').datagrid('endEdit',obj.editRow);
				//obj.editRow=undefined;
			}
			if(obj.editRow == undefined){
				$('#save,#redo').show();
				$('#table').datagrid('beginEdit',rowIndex);
				obj.editRow = rowIndex;
				
			}
			
		},
		columns:[[
		          {
					  field:'id',
					  title:'编号',
					  width:90,
					  sortable:true,
					  checkbox:true,
				  },
		          {
		        	  field:'user',
		        	  title:'账号',
		        	  width:90,
		        	  sortable:true,
		        	  sorter : function(a,b){
		        		  if(a>b)
		        		  return true;
		        	  },
		        	  fixed:true,
		        	  align:'center',
		        	  halign:'center',
		        	  resizable:false,
		        	  //hidden:true,
		        	  formatter:function(value,row,index){
		        		  return index+value;
		        	  },
		        	  styler:function(value,row,index){
		        		  if(row.user == 'e'){
		      				return "background-color:red";
		      			}
		        	  },
		        	  editor:{
		        		  type:"validatebox",
		        		  options:{
		        			  required:true,
		        			  
		        		  }
		        	  },
		          },
		          {
		        	  field:'email',
		        	  title:'邮件',
		        	  width:150,
		        	  //sortable:true,
		        	  editor:{
		        		  type:"validatebox",
		        		  options:{
		        			  required:true,
		        			  validType:"email",
		        		  }
		        	  },
		        	 
		          },
	          ]],
	          onHeaderContextMenu : function(e,field){
	        	  e.priventDefault();
	        	  alert(field);
	          },
	          onRowContextMenu : function(e,rowIndex,rowData){
	        	  e.prventDefault();
	        	  console.log(rowData);
	        	  $('#menu').menu('show',{
	        		 left : e.pageX,
	        		 top : e.pageY,
	        	  });
	          },
	          onClickRow : function(rowIndex,rowData){
	        	  
	          },
	          onClickCell : function(rowIndex,fielld,value){
	        	  
	          },
	          onUnselect : function(rowIndex,rowData){
	        	  
	          },
	          onCheck : function(rowIndex,rowData){
	        	  
	          },
	          onCancelEdit : function(rowIndex,rowData){
	        	  
	          },
	          onSortColumn : function(sort,order){
	        	  
	          },
	          onResizable: function(){
	        	  
	          },
	});
	//$('#table').datagrid('loadData');
	
});