<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	pageContext.setAttribute("path",request.getContextPath());
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="../themes/icon.css"></link>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">   
<script type="text/javascript" src="../js/jquery.min.js"></script>   
<script type="text/javascript" src="../js/echarts.js"></script>   
<script type="text/javascript" src="../js/china.js"></script>   
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/datagrid-detailview.js"></script>
<script src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
<script type="text/javascript">
	/* 菜单处理  */
	$(function(){
		$.ajax({
			url:"${path}/menu/showMenu",
			type:"GET",
			dataType:"json",
			success:function(data){
				
				$.each(data.menu,function(index,menu){
					/* 分类中的内容 */
					var content="<div align='center' style='margin-top:5px'>";
					$.each(menu.children,function(index,children){
						/* js不允许传递json对象，将json对象转换成json字符串进行传递 */
						var child=JSON.stringify(children);
						content+="<a class='easyui-linkbutton' data-options='plain:true,iconCls:\""+children.iconCls+"\"' onclick='addTab("+child+")'>"+children.title+"</a><br>";
					});
					content+="</div>";
					
					/* 添加分类 */
					$('#aa').accordion('add', {
						title: menu.title,
						iconCls:menu.iconCls,
						content: content,
						selected: false
					});
					
				});
				
			}
		});
	});
	
	/* 点击添加选项卡 */
	function addTab(child){
		var tab =$("#tt").tabs("exists",child.title);
		if(tab){
			$("#tt").tabs("select",child.title);
		}else{
			$('#tt').tabs('add',{    
			    title:child.title,    
			    href:"${path}"+child.href,
			    closable:true,    
			    tools:[{    
			        iconCls:'icon-mini-refresh',    
			        handler:function(){    
			           var tab = $('#tt').tabs('getSelected'); // 获取选择的面板
			           tab.panel('refresh', "${path}"+child.href);
	    
			        }    
			    }]    
			});  
		}
	}
	
	/* 密码表单验证  */
	$.extend($.fn.validatebox.defaults.rules, {    
		    equals: {    
		        validator: function(value,param){    
		            return value == $(param[0]).val();    
		        },    
		        message: '两次输入密码不一致！'   
		    }    
		}); 
	/* 修改密码 */
	function modifyPassword(){
		/* 对话框 */
		$('#modifyPasswordDialog').dialog({    
		    title: '修改密码',    
		    width: 380,    
		    height: 300, 
		    iconCls : "icon-edit",    
		    href: '${path}/admin/modifyPassword.jsp',    
		    modal: true,
		    buttons : [ {
						text : "提交",
						iconCls : "icon-ok",
						handler : modifyPwd
					} ],   
		});
	}
	
	/* 修改密码表单提交 */
		function  modifyPwd(){
			$('#modifyPasswordForm').form({    
			    url:"${path}/admin/modifyPassword",    
			    onSubmit: function(){    
			        // do some check    
			        // return false to prevent submit;
			         $('#modifyPasswordForm').form('validate');   
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
					$('#modifyPasswordDialog').dialog("close");
			        
			    }    
			});    
			// submit the form    
			$('#modifyPasswordForm').submit(); 
		}
	
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.username} &nbsp;<a href="javascript:void(0)" onclick="modifyPassword()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${path}/admin/exit" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 zhangcn@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div> 
    
    
    
    
    
	<!-- 修改密码对话窗口 -->
	<div id="modifyPasswordDialog"></div>
    
      
</body> 
</html>