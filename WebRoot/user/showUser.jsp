<%@page  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	pageContext.setAttribute("path",request.getContextPath());
 %>
 <script>
 	$(function(){
 		/* 数据表格展示 */
 		$('#userdg').datagrid({    
		    url:'${path}/user/showAll', 
		    fitColumns:true,
			fit:true,
			toolbar: "#userToolbar",   
		    columns:[[    
		        {field:'id',title:'ID',width:100,align:'center'},    
		        {field:'phone',title:'手机号',width:100,align:'center'},    
		        {field:'password',title:'密码',width:100,align:'center'},    
		        {field:'salt',title:'盐值',width:100,align:'center'},    
		        {field:'head_img',title:'头像',width:100,align:'center'},    
		        {field:'name',title:'姓名',width:100,align:'center'},    
		        {field:'legal_name',title:'法名',width:100,align:'center'},    
		        {field:'sex',title:'性别',width:100,align:'center'},    
		        {field:'city',title:'城市',width:100,align:'center'},    
		        {field:'sign',title:'签名',width:100,align:'center'},    
		        {field:'status',title:'状态',width:100,align:'center',
		        	formatter:function(value,row,index){
		        		if(value==1){
		        			return "<input class='swbutton' value='"+row.id+"' checked/>";
		        		}else{
		        			return "<input class='swbutton' value='"+row.id+"' />";
		        		}
		        	}
		        }, 
		        {field:'reg_date',title:'注册时间',width:100,align:'center'}, 
		    ]],
		    /* 分页 */
		    pagination:true,
			pageList:[5,10,15,20,25],
			pageSize:5,
			pageNumber:1,
			striped:true,
			ctrlSelect:true,//选中模式   
			
			/* 数据表格详细展示 */
			view: detailview, 
			detailFormatter: function(rowIndex, rowData){
				var guru=rowData.guru; 
				return '<table><tr>' + 
				'<td rowspan=2 style="border:0"><img src="${path}'+rowData.head_img+'" style="height:200px;width:150px"></td>' + 
				'<td style="border:0">' + 
				'<p>法名: ' + rowData.legal_name + '</p>' + 
				'<p>手机号: ' + rowData.phone + '</p>' + 
				'<p>签名: ' + rowData.sign + '</p>' + 
				'<p>所承上师法名: ' + guru.legal_name + '</p>' + 
				'<p>所承上师头像: <img src="${path}' + guru.head_img + '" style="height:40px;width:30px"></p>' + 
				'</td>' + 
				'</tr></table>'; 
			},
			/* 加载成功 */
			onLoadSuccess:function(data){
				$(".swbutton").switchbutton({
					onText:"online",
					offText:"block",
					onChange:function(r){
						var status;
						/* 若r为true，则开启  */
						if(r){status=1;}else{status=0;}
						$.ajax({
							type:"POST",
							dataType:"json",
							data:{"id":$(this).val(),"status":status},
							url:"${path}/user/updateStatus",
							success:function(data){
								$.messager.show({
									title:'提示消息',
									msg:data.message,
									timeout:5000,
									showType:'slide'
								});
							}
						});
						$("#userdg").datagrid('load');
					}
				});
			},
			
		}); 
		 
 	});
 	
 	/* 下载用户表格 */
 	function downloadUserTable(){
 		$.ajax({
 			type:"GET",
 			dataType:"json",
 			url:"${path}/user/downloadTable",
 			success:function(data){
 				$.messager.show({
					title:'提示消息',
					msg:data.message,
					timeout:5000,
					showType:'slide'
				});
 			}
 		});
 	}
 	
 	
 </script>
 
 <!-- 数据表格 -->
<table id="userdg"></table>

<div id="userToolbar">
<a href="javascript:void(0)" class="easyui-linkbutton" onclick="downloadUserTable()"  data-options="iconCls:'icon-download',plain:true">导出用户表格</a>
</div>
 