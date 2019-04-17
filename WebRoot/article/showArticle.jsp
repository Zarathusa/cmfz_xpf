<%@page  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	pageContext.setAttribute("path",request.getContextPath());
 %>
 <script>
 	$(function(){
 		/* 数据表格展示 */
 		$('#articledg').datagrid({    
		    url:'${path}/article/showAll', 
		    fitColumns:true,
			fit:true,
			toolbar: "#articleToolbar",   
		    columns:[[    
		        {field:'id',title:'ID',width:100,align:'center'},    
		        {field:'title',title:'标题',width:100,align:'center'},    
		        {field:'author',title:'作者',width:100,align:'center'},    
		        {field:'insert_img',title:'图片',width:100,align:'center'},    
		        {field:'content',title:'内容',width:100,align:'center'},    
		        {field:'pub_date',title:'发布时间',width:100,align:'center'},    
		        
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
				return '<table><tr>' + 
				'<td rowspan=2 style="border:0"><img src="${path}'+rowData.insert_img+'" style="height:200px;width:150px"></td>' + 
				'<td style="border:0">' + 
				'<p>标题: ' + rowData.title + '</p>' + 
				'<p>作者: ' + rowData.author + '</p>' + 
				'<p>内容: ' + rowData.content + '</p>' + 
				'<p>发布时间: ' + rowData.pub_date + '</p>' + 
				'<p>所属上师法名:' + rowData.guru.legal_name + '</p>' + 
				'</td>' + 
				'</tr></table>'; 
			},
		});	
		
		
		$("#articless").searchbox({
				searcher : function(value, name) {
					$('#articledg').datagrid('load', {
						like:value,
					});
				}
		}); 
 	});
 </script>
 
  <!-- 数据表格 -->
<table id="articledg"></table>

<div id="articleToolbar">
	<!-- 搜索框 -->
		<input id="articless" class="easyui-searchbox" style="width:300px"
			data-options="prompt:'Please Input Value',menu:'#mm'"></input>
		<!-- 搜索菜单 -->
		<div id="mm" style="width:120px">
			<div data-options="name:'like',iconCls:'icon-search'">文章</div>
		</div>
</div> 

