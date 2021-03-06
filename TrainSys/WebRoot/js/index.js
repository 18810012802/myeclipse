$(function() {
	var types = null;
	$
			.ajax({
				type : 'POST',
				url : 'TrainServlet',
				data : {
					t : 'type',
				},
				success : function(msg) {
					types = msg;

					$("#trainType").combobox({
						valueField : "id",
						textField : "type",
						url : "TrainServlet?t=type",
						mode : "remote",
						/*
						 * groupField : 'group', groupFormatter :
						 * function(group){ return group; },
						 */
						filter : function(q, row) {
							var opts = $(this).combobox('options');
							return row[opts.textField].indexOf(q) >= 0;
						},
						formatter : function(row) {
							var opts = $(this).combobox('options');
							return '[' + row[opts.textField] + ']';
						},
						onSelect : function(record) {

						},
						onUnSelect : function(record) {

						},

					});
					obj = {
						editRow : undefined,
						search : function() {
							$('#table')
									.datagrid(
											'load',
											{
												train_no : $
														.trim($(
																'input[name="trainNo"]')
																.val()),
												trainType : $
														.trim($(
																'input[name="trainType"]')
																.val()),
											});
						},
						add : function() {
							if (this.editRow == undefined) {
								$('#save,#redo').show();
								$('#table').datagrid("appendRow", {});
								$('#table').datagrid("insertRow", {
									index : 0,
									row : {}
								});
								$('#table').datagrid("beginEdit", 0);
								this.editRow = 0;
							}
						},
						save : function() {
							$('#table').datagrid("endEdit", this.editRow);
						},
						redo : function() {
							this.editRow = undefined;
							$('#save,#redo').hide();
							$('#table').datagrid("rejectChanges");
						},
						update : function() {
							var rows = $('#table').datagrid('getSelections');
							if (rows.length == 1) {
								if (this.editRow != undefined) {
									$('#table').datagrid('endEdit',
											this.editRow);
									// obj.editRow=undefined;
								}
								if (this.editRow == undefined) {
									var index = $('#table').datagrid(
											'getRowIndex', rows[0]);
									$('#table').datagrid('beginEdit', index);
									this.editRow = index;
									$('#save,#redo').show();
									$('#table').datagrid('unselectRow', index);
								}

							} else {
								$.messager
										.alert('警告', '修改必须且只能有一行', 'warnning');
							}
						},
						del : function() {
							var rows = $('#table').datagrid('getSelections');
							if (rows.length > 0) {
								$.messager
										.confirm(
												'确定操作',
												'确定要删除吗？',
												function(flag) {
													if (flag) {
														var ids = [];
														for ( var i = 0; i < rows.length; i++) {
															ids
																	.push(rows[i].no);
														}
														$
																.ajax({
																	type : 'POST',
																	url : 'TrainServlet',
																	data : {
																		t : "del",
																		ids : ids
																				.join(','),
																	},
																	beforeSend : function() {
																		$(
																				'#table')
																				.datagrid(
																						'loading');
																	},
																	success : function(
																			msg) {
																		$(
																				'#table')
																				.datagrid(
																						'loaded');
																		$(
																				'#table')
																				.datagrid(
																						'load');
																		$(
																				'#table')
																				.datagrid(
																						'unselectAll');
																		$.messager
																				.show({
																					title : "提示",
																					msg : "删除了"
																							+ msg
																							+ "条记录！",
																				});
																		obj.editRow = undefined;
																	}
																});
													}
												});
							} else {
								$.messager.alert('提示', '请选择车次！', 'info');
							}
						},
					};
					$
							.extend(
									$.fn.validatebox.defaults.rules,
									{
										fromTo : {
											validator : function(value) {
												return /^.+[-][-].+$/
														.test(value);
											},
											message : '必须输入"--"分割的两个地址!'
										},
										time : {
											validator : function(value) {
												return /^(([0-1]{1}[0-9]{1})|([2]{1}[0-4]{1})):([0-5]{1}[0-9]{1})[-][-](([0-1]{1}[0-9]{1})|([2]{1}[0-4]{1})):([0-5]{1}[0-9]{1})$/
														.test(value);
											},
											message : '必须输入"--"分割的两个时间（HH:mm）!'
										}
									});
					$('#table')
							.datagrid(
									{
										width : 900,
										url : 'TrainServlet',
										title : '列车信息',
										inconCls : 'icon-search',
										pagination : true,
										pageSize : 5,
										pageList : [ 5, 10, 15 ],
										// pageNumber : 1,
										pagePosition : 'bottom',
										sortName : 'start_time',
										sortOrder : 'DESC',
										remoteSort : false,
										multiSort : true,
										striped : true,
										nowrap : false,
										fitColumns : true,
										/*
										 * data:[{ user:"user", email:"email"
										 * }],
										 */
										loadMsg : "加载中...",
										rownumbers : true,
										// singleSelect : true,
										showHeader : true,
										showFooter : true,
										scrollbarSize : 20,
										frozenColumns : [ [ {

										}

										] ],
										rowStyler : function(index, row) {
											if (row.user == 'f') {
												return "background-color:orange";
											}
										},
										toolbar : "#tb",
										onAfterEdit : function(rowIndex,
												rowData, changes) {
											// if(obj.editRow == undefined){
											$('#save,#redo').hide();
											var inserted = $('#table')
													.datagrid('getChanges',
															'inserted');
											var updated = $('#table').datagrid(
													'getChanges', 'updated');
											var type = "";
											var tip = "";
											if (inserted.length > 0) {
												type = "add";
												tip = "添加了";
											} else if (updated.length > 0) {
												type = "update";
												tip = "修改了";
											}
											rowData.t = type;
											if (type != "")
												$
														.ajax({
															type : 'POST',
															url : 'TrainServlet',
															data : rowData,
															beforeSend : function() {
																$('#table')
																		.datagrid(
																				'loading');
															},
															success : function(
																	msg) {
																$('#table')
																		.datagrid(
																				'loaded');
																$('#table')
																		.datagrid(
																				'load');
																$('#table')
																		.datagrid(
																				'unselectAll');
																$.messager
																		.show({
																			title : "提示",
																			msg : (msg == 0) ? "操作失败，该列车车次已存在！"
																					: (tip
																							+ msg + "条数据!"),
																		});
																obj.editRow = undefined;
															}
														});
										},
										onDblClickRow : function(rowIndex,
												rowData) {
											if (obj.editRow != undefined) {
												$('#table').datagrid('endEdit',
														obj.editRow);
												obj.editRow = undefined;
											}
											if (obj.editRow == undefined) {
												$('#save,#redo').show();
												$('#table').datagrid(
														'beginEdit', rowIndex);
												obj.editRow = rowIndex;

											}

										},
										columns : [ [
												{
													field : 'no',
													width : 50,
													checkbox : true,

												},
												{
													align : 'center',
													halign : 'center',
													field : 'train_no',
													title : '车次',
													width : 50,
													sortable : true,
													editor : {
														type : "validatebox",
														options : {
															required : true,
														}
													},
													formatter : function(value,
															row, index) {
														return '<a href="TrainServlet?t=look&train_no='
																+ value
																+ '">'
																+ value
																+ '</a>';
													},
												},
												{
													field : 'station',
													title : '发车 -- 到达',
													width : 80,
													sortable : true,
													align : 'center',
													halign : 'center',
													editor : {
														type : "validatebox",
														options : {
															required : true,
															validType : "fromTo"
														}
													},
												},
												{
													align : 'center',
													halign : 'center',
													field : 'time',
													title : '发时 -- 到时',
													width : 80,
													// sortable:true,
													editor : {
														type : "validatebox",
														options : {
															required : true,
															validType : "time"
														}
													},

												},
												{
													align : 'center',
													halign : 'center',
													field : 'start_time',
													title : '发时',
													width : 80,
													hidden : true,
												},
												{
													align : 'center',
													halign : 'center',
													field : 'arrival_time',
													title : '到达',
													width : 80,
													hidden : true,
												},
												{
													align : 'center',
													halign : 'center',
													field : 'type',
													title : '车型',
													width : 50,
													// sortable:true,
													formatter : function(value,
															rowData, rowIndex) {
														if (types != null
																&& types.length > 0) {
															for ( var i = 0; i < types.length; i++) {
																if (types[i].id == value) {
																	return types[i].type;
																}
															}
														}
													},
													editor : {
														type : 'combobox',
														options : {
															// required : true,
															panelHeight : 'auto',
															editable : false,
															valueField : "id",
															textField : "type",
															url : "TrainServlet?t=type",
														/*
														 * formatter :
														 * function(row){ var
														 * opts =
														 * $(this).combobox('options');
														 * return
														 * '['+row[opts.textField]+']'; },
														 */
														// mode : "remote",
														/*
														 * data : [
														 * {id:"1",type:"动车"},
														 * {id:"2",type:"普快"},
														 * {id:"3",type:"特快"},
														 * {id:"4",type:"直达"}],
														 */
														}
													},

												}, {
													align : 'center',
													halign : 'center',
													field : 'runtime',
													title : '运行时间（小时）',
													width : 50,
													// sortable:true,
													disabled : true,
													readonly : true,
												}, {
													align : 'center',
													halign : 'center',
													field : 'mile',
													title : '里程',
													width : 50,
													// sortable:true,
													editor : {
														type : "validatebox",
														options : {
															required : true,
														}
													},

												}, ] ],
										onHeaderContextMenu : function(e, field) {
											e.priventDefault();
										},
										onRowContextMenu : function(e,
												rowIndex, rowData) {
											e.prventDefault();
											/*
											 * console.log(rowData);
											 * $('#menu').menu('show', { left :
											 * e.pageX, top : e.pageY, });
											 */
										},
										onClickRow : function(rowIndex, rowData) {

										},
										onClickCell : function(rowIndex,
												fielld, value) {

										},
										onUnselect : function(rowIndex, rowData) {

										},
										onCheck : function(rowIndex, rowData) {

										},
										onCancelEdit : function(rowIndex,
												rowData) {

										},
										onSortColumn : function(sort, order) {

										},
										onResizable : function() {

										},
									});
				},
			});

});