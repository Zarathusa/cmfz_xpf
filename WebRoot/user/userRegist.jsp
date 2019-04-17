<%@page  pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("path",request.getContextPath());
%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">   
<script type="text/javascript" src="../js/jquery.min.js"></script> 
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script> 
	<script>
		/* 提交 */
		$(function(){
			$("#registButton").click(function(){
    			$.ajax({
    				type:"POST",
    				url:"${path}/userRegist",
    				data:$("#userRegist").serialize(),
    				success:function(r){
    					
    				}
    			});
    		});
		
		});
    		
	</script>
</head>
<body>
	<div style="text-align: center;width:75%;">
		<h2>用户注册</h2>
		<form id="userRegist" method="post">   
		    <div>   
		        <label for="phone">手机号:</label>   
		        <input class="easyui-validatebox" type="text" name="phone" data-options="required:true" />   
		    </div> 
		    <div>   
		        <label for="password">密码:</label>   
		        <input class="easyui-validatebox" type="password" name="password" data-options="required:true" />   
		    </div> 
		    <div>   
		        <label for="name">名字:</label>   
		        <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />   
		    </div> 
		    <div>   
		        <label for="legal_name">法名:</label>   
		        <input class="easyui-validatebox" type="text" name="legal_name" data-options="required:true" />   
		    </div> 
		    <div>   
		        <label for="sex">性别:</label>   
		        <input class="easyui-validatebox" type="radio" name="sex" data-options="required:true" value="m" />男   
		        <input class="easyui-validatebox" type="radio" name="sex" data-options="required:true" value="f" />女   
		    </div>
		    <div>   
		        <label for="city">城市:</label>   
		        <input class="easyui-validatebox" type="text" name="city" data-options="required:true" />   
		    </div>
		    <div>
				<input type="button" id="registButton" value="注册"/>  
		    </div>
		      
		</form>  
	</div>
</body>
</html>
