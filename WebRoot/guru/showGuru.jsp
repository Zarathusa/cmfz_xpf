<%@page  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	pageContext.setAttribute("path",request.getContextPath());
 %>
 <script>
 	$('#guruDatagrid').datagrid({    
	    url:'${path}/guru/showAll',
		fitColumns:true,
		fit:true,   
	    columns:[[    
	        {field:'id',title:'上师ID',width:100,align:'center'},    
	        {field:'legal_name',title:'上师法名',width:100,align:'center'},    
	        {field:'head_img',title:'上师头像',width:100,align:'center',
	        	formatter: function(value,row,index){
					return "<img class='head_img' src='${path}/"+value+"' width='40px' height='30px'/>";
				}
	        	
	        },    
	        {field:'status',title:'状态',width:100,align:'center',
	        	formatter: function(value,row,index){
	        		if(value==1){
	        			return "<input class='swbutton' value="+row.id+" checked/>";
	        		}else{
	        			return "<input class='swbutton' value="+row.id+" />";
	        		}
				}
	        },    
	        {field:'reg_date',title:'注册时间',width:100,align:'center'},    
	    ]],
	    pagination:true,
	    pageList:[5,10,15,20],
	    pageSize:5,
	    striped:true,
	    ctrlSelect:true,
	    onLoadSuccess:function(){
	    	/* 放大镜的实现 */
	    	var bigImg = $("<img id='bimg' src='' />");
			bigImg.hide();
			$("body").append(bigImg);
			$(".head_img").mouseover(function(e){
				bigImg.attr("src",$(this).attr("src"));
				$(bigImg).css({
					"top":e.pageY+5,
					"left":e.pageX+10,
					"position":"absolute",   
					"height":"300px", 
					"width":"200px", 
					"border":"5px dashed #cad", 
					"border-radius":"25px 10px"
				});
				bigImg.show();
			}).mouseout(function(){
				$("#bimg").hide();
			}).mousemove(function(e){
				$("#bimg").css({
					"top":e.pageY+5,
					"left":e.pageX+10,
					"position":"absolute",   
					"height":"300px", 
					"width":"200px", 
					"border":"5px dashed #cad", 
					"border-radius":"25px 10px"
				});
			});	
			
			/* 开关按钮的实现 */
			$(".swbutton").switchbutton({
				onText:"online",
				offText:"block",
				onChange:function(r){
					var status;
					r?status=1:status=0;
					$.ajax({
						type:"POST",
						url:"${path}/guru/updateStatus",
						dataType:"json",
						data:{"id":$(this).val(),"status":status},
						success:function(data){
							$.messager.show({
									title:'提示消息',
									msg:data.message,
									timeout:5000,
									showType:'slide'
							});
						}
					});
					/* 刷新页面 */
					$("#guruDatagrid").datagrid("reload");
				}
			});
			
	    },  
	    
	}); 
 </script>
 
 <!-- 上师数据表格  -->
 <table id="guruDatagrid"></table>  