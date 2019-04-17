<%@page  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	pageContext.setAttribute("path",request.getContextPath());
 %>
<script>
	$(function(){
		/* 数据表格展示 */
		$('#bannerdg').datagrid({    
		    url:'${path}/banner/showBanner',
		    fitColumns:true,
			fit:true,
			toolbar: '#bannertb',   
		    columns:[[    
		        {field:'id',title:'ID',width:100,align:'center'},    
		        {field:'picName',title:'图片名称',width:100,align:'center'},    
		        {field:'picPath',title:'图片路径',width:100,align:'center'},    
		        {field:'description',title:'图片简介',width:100,align:'center'},    
		        {field:'status',title:'图片状态',width:100,align:'center',
		        	formatter:function(value,row,index){
		        		if(value==1){
		        			return "<input class='swbutton' value='"+row.id+"' checked/>";
		        		}else{
		        			return "<input class='swbutton' value='"+row.id+"' />";
		        		}
		        	}
		        },    
		        {field:'createTime',title:'创建时间',width:100,align:'center'},    
		    ]],
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
				'<td rowspan=2 style="border:0"><img src="${path}'+rowData.picPath+'" style="height:200px;width:150px"></td>' + 
				'<td style="border:0">' + 
				'<p>图片名称: ' + rowData.picName + '</p>' + 
				'<p>图片简介: ' + rowData.description + '</p>' + 
				'<p>图片状态: ' + rowData.status + '</p>' + 
				'<p>图片创建时间:' + rowData.createTime + '</p>' + 
				'</td>' + 
				'</tr></table>'; 
			},
			/* 加载成功 */
			onLoadSuccess:function(data){
				$(".swbutton").switchbutton({
					onText:"online",
					offText:"hide",
					onChange:function(r){
						var status;
						/* 若r为true，则开启  */
						if(r){status=1;}else{status=0;}
						$.ajax({
							type:"POST",
							dataType:"json",
							data:{"id":$(this).val(),"status":status},
							url:"${path}/banner/updateStatus",
							success:function(data){
								$.messager.show({
									title:'提示消息',
									msg:data.message,
									timeout:5000,
									showType:'slide'
								});
							}
						});
						$("#bannerdg").datagrid('load');
					}
				});
			},
			
		}); 
		
		/* 添加轮播图 */
		$("#addBannerBtn").click(function(){
			$('#bannerdd').dialog({    
			    title: '添加轮播图',    
			    width: 400,    
			    height: 220,
			    iconCls : "icon-add",    
			    closed: false,    
			    cache: false,    
			    href: '${path}/banner/addBanner.jsp',    
			    modal: true ,
			    buttons : [ {
						text : "提交",
						iconCls : "icon-ok",
						handler : addBanner
					} ], 
			});
		});
		
		/* 轮播图的表单提交 */
		function addBanner(){
			$('#addBannerForm').form({    
			    url:"${path}/banner/add",    
			    onSubmit: function(){    
			        // do some check    
			        // return false to prevent submit;
			         $('#addBannerForm').form('validate');   
			    },    
			    success:function(data){    
			        //将json字符串转为json对象
			        data=eval("("+data+")");    
			        $.messager.show({
						title:'温馨提示',
						msg:data.message,
						timeout:5000,
						showType:'slide'
					});
					
					//关闭对话窗
					$('#bannerdd').dialog("close");
			        //刷新页面
			        $("#bannerdg").datagrid('reload');
			    }    
			});    
			// submit the form    
			$('#addBannerForm').submit(); 
		}
		
		
		
		/* 修改轮播图信息 */
		$("#editBannerBtn").click(function(){
			//获取选中的行
			var selRow=$("#bannerdg").datagrid("getSelected");
			//判断是否选中
			if(!selRow){
				$.messager.alert('温馨提示','请选中一行',"warning"); 
			}else{
				//初始化对话窗口
				$('#editbannerdd').dialog({    
				    title: '编辑轮播图信息',    
				    width: 400,    
				    height: 220,    
				    closed: false,    
				    cache: false,    
				    modal: true,
				    buttons : [ {
						text : "提交",
						iconCls : "icon-ok",
						handler : editBanner
					} ],
				       
				}); 
				
				//给表单填充数据
				$("#editBannerForm").form("load",{
					id:selRow.id,
					picName:selRow.picName,
					description:selRow.description
				});
			}
		});
		/* 编辑表单的提交 */
		function editBanner(){
			$('#editBannerForm').form({    
			    url:"${path}/banner/modify",    
			    onSubmit: function(){    
			        // do some check    
			        // return false to prevent submit;
			       $('#editBannerForm').form("validate");     
			    },    
			    success:function(data){    
			          //将json字符串转为json对象
			        data=eval("("+data+")");    
			        $.messager.show({
						title:'温馨提示',
						msg:data.message,
						timeout:5000,
						showType:'slide'
					});
					
					//关闭对话窗
					$('#editbannerdd').dialog("close");
			        //刷新页面
			        $("#bannerdg").datagrid('reload'); 
			    }    
			});    
			// submit the form    
			$('#editBannerForm').submit();  
			
		}
	});
</script>

<!-- 数据表格 -->
<table id="bannerdg"></table> 

<!-- 功能按钮 -->
<div id="bannertb">
<a href="javascript:void(0)" id="addBannerBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加轮播图</a>
<a href="javascript:void(0)" id="editBannerBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改轮播图</a>
</div>

<!-- 添加轮播图对话窗口 -->
<div id="bannerdd"></div>  

<!-- 编辑轮播图对话窗口 -->
<div id="editbannerdd">  

	<form id="editBannerForm" method="post">   
		<div>   
	        <label >图片id:</label><br>   
	        <input class="easyui-validatebox" type="text" name="id" readonly="readonly" style="width:300px;height:20px;margin-top:10px;margin-left: 10px "/>   
	    </div> 
	    <div>   
	        <label >图片名称:</label> <br>   
	        <input class="easyui-validatebox" type="text" name="picName" data-options="required:true" style="width:300px;height:20px;margin-top:10px;margin-left: 10px "/>   
	    </div>   
	    <div>   
	        <label >图片简介:</label> <br>   
	        <input class="easyui-validatebox" type="text" name="description" data-options="required:true" style="width:300px;height:20px;margin-top:10px ;margin-left: 10px"/>   
	    </div>       
	</form>  

</div>