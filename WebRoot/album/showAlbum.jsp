<%@page pageEncoding="UTF-8" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
 %>
 <script>
 	$(function(){
 		/*  树形数据表格 */
 		$('#albumTable').treegrid({    
		    url:'${path}/album/showAll',    
		    fit:true,
		    fitColumns:true,
		    idField:'id',    
		    treeField:'title',
		    toolbar:'#albumToobar',    
		    columns:[[    
		        {title:'名称',field:'title',width:100,align:'center'},    
		        {field:'size',title:'大小',width:100,align:'center'},    
		        {field:'url',title:'路径',width:100,align:'center'},    
		        {field:'duration',title:'时长',width:100,align:'center'},    
		        {field:'pub_date',title:'发布时间',width:100,align:'center'}    
		    ]],
		    pagination:true,
			pageList:[5,10,15,20,25],
			pageSize:5,
			pageNumber:1,
			striped:true,
			ctrlSelect:true,//选中模式    
		});  
 		
 		
 		/* 添加专辑 */
		$("#addAlbum").click(function(){
			$("#addAlbumDialog").dialog({
				title: "添加专辑",
				iconCls:"icon-add",    
				width: 380,    
				height: 380,  
				href:"${path}/album/addAlbum.jsp",  
				modal: true,
				buttons : [ {
							text : "提交",
							iconCls : "icon-ok",
							handler : saveAlbum
						} ],
			});
		});
		/* 添加专辑表单的提交 */
		function saveAlbum(){
			$('#addAlbumForm').form({    
				    url:"${path}/album/add",    
				    onSubmit: function(){    
				        // do some check    
				        // return false to prevent submit;
				         $('#addAlbumForm').form('validate');   
				    },    
				    success:function(r){
				        //将json字符串转为json对象
				        r=eval("("+r+")");    
				        $.messager.show({
							title:'温馨提示',
							msg:r.message,
							timeout:5000,
							showType:'slide'
						});
						
						//关闭对话窗
						$('#addAlbumDialog').dialog("close");
				        //刷新页面
				        $("#albumTable").treegrid('reload');
				    }    
				});    
				// submit the form    
				$('#addAlbumForm').submit();
		}
		
		
		
		
		
 		
 		
 		/* 添加章节的对话窗口 */
 		$("#addChapter").click(function(){
 			var row= $("#albumTable").treegrid('getSelected');
 			if(row==null||row.count==null){
 				$.messager.confirm('提示信息','请选择专辑');
 			}else{
 				$("#addChapterDialog").dialog({
	 				title: "添加章节",
					iconCls:"icon-add",    
					width: 350,    
					height: 200,  
					href:"${path}/chapter/addChapter.jsp", 
					queryParams:row, 
					modal: true,
					buttons : [ {
								text : "提交",
								iconCls : "icon-ok",
								handler : saveChapter
							} ],
	 			});
 			}
 			
 		});
 		/* 添加章节的表单 */
 		function saveChapter(){
 			$('#addChapterForm').form({    
				    url:"${path}/chapter/add",    
				    onSubmit: function(){    
				        // do some check    
				        // return false to prevent submit;
				         $('#addChapterForm').form('validate');   
				    },    
				    success:function(r){
				        //将json字符串转为json对象
				        r=eval("("+r+")");    
				        $.messager.show({
							title:'温馨提示',
							msg:r.message,
							timeout:5000,
							showType:'slide'
						});
						
						//关闭对话窗
						$('#addChapterDialog').dialog("close");
				        //刷新页面
				        $("#albumTable").treegrid('reload');
				    }    
				});    
				// submit the form    
				$('#addChapterForm').submit();
 		}
 		
 		
 	});//$(function(){})
 	
 	
 	/* 专辑详情 */
 		function detailAlbum(){
			var row= $("#albumTable").treegrid('getSelected');
			if(row==null){
				$.messager.confirm('提示信息','请选择一行');
			}else{
				if(row.count==null){
					$.messager.confirm('提示信息','请选择专辑');
				}else{
					var detailContent="<div align='center'>";
					detailContent+="<table><tr>";
					detailContent+="<td rowspan=2 style='border:0'><img src='${path}/" + row.img_path+" 'style='height:200px;width:150px'></td>"; 
					detailContent+="<td style='border:0'>"; 
					detailContent+="<p>ID："+row.id+"</p>";	
					detailContent+="<p>标题："+row.title+"</p>";	
					detailContent+="<p>评分："+row.score+"</p>";
					detailContent+="<p>作者："+row.author+"</p>";
					detailContent+="<p>播音："+row.beam+"</p>";
					detailContent+="<p>章节数："+row.count+"</p>";
					detailContent+="<p>内容："+row.content+"</p>";
					detailContent+="<p>发布日期："+row.pub_date+"</p>";
					detailContent+="</td></tr></table>"; 
					detailContent+="</div>";
					
					$('#albumDialog').dialog({    
					    title: row.title,
					    iconCls:"icon-help",     
					    width: 400,    
					    height: 300,  
					    content:detailContent,  
					    modal: true   
					});
					/* 表单填充 */
				}
			}
		}
	
	/* 音频下载 */
	function downloadChapter(){
		var row= $("#albumTable").treegrid('getSelected');
		if(row==null||row.size==null){
			$.messager.confirm('提示信息','请选择一行章节');
		}else{
			location.href="${path}/chapter/download?url="+row.url;
		}
		
	}
	
	
	/* 音频播放 */
	function playAudio(){
		var row= $("#albumTable").treegrid('getSelected');
		if(row==null||row.size==null){
			$.messager.confirm('提示信息','请选择一行章节');
		}else{
			//location.href="${path}/chapter/playAudio?url="+row.url;
			$('#playAudioDialog').dialog({    
					    title: row.title,
					    iconCls:"icon-help",     
					    width: 300,    
					    height: 120,  
					   	href:"${path}/chapter/playAudio.jsp",
					   	queryParams:row,  
					    modal: true,
					    closable:false,
					    buttons:[{
							text:'关闭',
							handler:function(){
								$('#playAudioDialog').dialog("close");
								$("#playAudioJsp").prop("src","");
							}
						}],   
					});
		}
		
	}
	
		
 </script>
 
 <!-- 树形数据表格 -->
 <table id="albumTable"></table> 
 
 <!-- 工具栏 -->
<div id="albumToobar">
<a href="javascript:void(0)" class="easyui-linkbutton" onclick="detailAlbum()" data-options="iconCls:'icon-help',plain:true">专辑详情</a>
<a href="javascript:void(0)" class="easyui-linkbutton" id="addAlbum" data-options="iconCls:'icon-add',plain:true">添加专辑</a>
<a href="javascript:void(0)" class="easyui-linkbutton" id="addChapter" data-options="iconCls:'icon-add',plain:true">添加章节</a>
<a href="javascript:void(0)" class="easyui-linkbutton" onclick="downloadChapter()" data-options="iconCls:'icon-download',plain:true">下载音频</a>
<a href="javascript:void(0)" class="easyui-linkbutton" onclick="playAudio()" data-options="iconCls:'icon-bell',plain:true">在线播放</a>
</div>

<!-- 专辑详情对话窗口 -->
<div id="albumDialog"></div>  

<!-- 添加专辑对话窗口 -->
<div id="addAlbumDialog"></div>

<!-- 添加章节对话窗口 -->
<div id="addChapterDialog"></div>

<!-- 添加音频播放的对话窗口 -->
<div id="playAudioDialog"></div>

