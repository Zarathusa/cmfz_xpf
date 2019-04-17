<%@page  pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("path",request.getContextPath());
 %>

 <form id="modifyPasswordForm" method="post">   
			<div>   
		        <label >ID:</label><br>   
		        <input class="easyui-validatebox" type="text" name="id" value="${sessionScope.admin.id}" readonly="readonly" style="width:300px;height:20px;margin-top:10px;margin-left: 10px "/>   
		    </div> 
		    <div>   
		        <label >旧的密码:</label> <br>   
		        <input class="easyui-validatebox" type="password" name="password" data-options="required:true" style="width:300px;height:20px;margin-top:10px;margin-left: 10px "/>   
		    </div>
		    <div>   
		        <label >新的密码:</label> <br>   
		        <input class="easyui-validatebox" type="password" id="pwd" name="npassword" data-options="required:true" style="width:300px;height:20px;margin-top:10px;margin-left: 10px "/>   
		    </div> 
			<div>   
		        <label >确认密码:</label> <br>   
		        <input class="easyui-validatebox" type="password" data-options="required:true" validType="equals['#pwd']"  style="width:300px;height:20px;margin-top:10px;margin-left: 10px "/>   
		    </div> 
		         
</form> 