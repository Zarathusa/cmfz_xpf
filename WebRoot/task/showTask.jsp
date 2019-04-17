<%@page  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	pageContext.setAttribute("path",request.getContextPath());
 %>
<script>
	$(function(){
		$('#taskdg').datagrid({    
		    url:'${path}/task/showAll',
		    fitColumns:true,
			fit:true,     
		    columns:[[    
		        {field:'id',title:'ID',width:100,align:'center'},    
		        {field:'title',title:'标题',width:100,align:'center'},    
		        {field:'mark',title:'属性',width:100,align:'center'},
		        {field:'pub_date',title:'时间',width:100,align:'center'},      
		        {field:'value',title:'用户ID',width:100,align:'center',
		        	formatter: function(value,row,index){
						return row.user.id;
					}
		        },
		        {field:'value1',title:'用户姓名',width:100,align:'center',
		        	formatter: function(value,row,index){
						return row.user.name;
					}
		        },
		        
		        
		    ]],
			pagination:true,
		    pageList:[5,10,15,20],
		    pageSize:5,
		    striped:true,
		    ctrlSelect:true, 
		    view: detailview, 
			detailFormatter: function(rowIndex, rowData){
				var counters=rowData.counters;
				var content='<table><tr>';
				//计数器
				for(var i=0;i<counters.length;i++){
					content+='<td style="border:0">';
					content+='<p>计数器ID: ' + counters[i].id + '</p>';
					content+='<p>计数器标题: ' + counters[i].title + '</p>';
					content+='<p>计数器时间: ' + counters[i].last_date + '</p>';
					content+='<p>计数数量: ' + counters[i].count + '</p>';
					content+='<td>&nbsp;&nbsp;</td>';
				}
				
				content+='</tr></table>'; 
				return content;
				
			} 
			 
		});
	});
 	
 
</script>
 
 <!-- 数据表格 -->
<table id="taskdg"></table>