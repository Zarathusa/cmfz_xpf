<%@page  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	pageContext.setAttribute("path",request.getContextPath());
 %>


<form id="addBannerForm" method="post" enctype="multipart/form-data">   
	<div>   
        <label >图片上传:</label><br>   
        <input class="easyui-filebox" name="pictureUpload" data-options="required:true" style="width:300px;height:20px;margin-top:10px ">   
    </div> 
    <div>   
        <label >图片名称:</label> <br>   
        <input class="easyui-validatebox" type="text" name="picName" data-options="required:true" style="width:300px;height:20px;margin-top:10px "/>   
    </div>   
    <div>   
        <label >图片简介:</label> <br>   
        <input class="easyui-validatebox" type="text" name="description" data-options="required:true" style="width:300px;height:20px;margin-top:10px "/>   
    </div>       
</form>  