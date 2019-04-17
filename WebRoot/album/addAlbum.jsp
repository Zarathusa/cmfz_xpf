<%@page  pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("path",request.getContextPath());
 %>


<form id="addAlbumForm" method="post" enctype="multipart/form-data">
	<div>   
        <label >标题名称:</label> <br>   
        <input class="easyui-validatebox" type="text" name="title" data-options="required:true" style="width:300px;height:20px;margin-top:10px "/>   
    </div>
    <div>   
        <label >专辑评分:</label> <br>   
        <input class="easyui-validatebox" type="text" name="score" data-options="required:true" style="width:300px;height:20px;margin-top:10px "/>   
    </div> 
    <div>   
        <label >专辑作者:</label> <br>   
        <input class="easyui-validatebox" type="text" name="author" data-options="required:true" style="width:300px;height:20px;margin-top:10px "/>   
    </div>
	<div> 
        <label >图片上传:</label><br>   
        <input class="easyui-filebox" name="pictureUpload" data-options="required:true" style="width:300px;height:20px;margin-top:10px ">   
    </div> 
    <div>   
        <label >播音:</label> <br>   
        <input class="easyui-validatebox" type="text" name="beam" data-options="required:true" style="width:300px;height:20px;margin-top:10px "/>   
    </div>   
    <div>   
        <label >专辑简介:</label> <br>   
        <input class="easyui-validatebox" type="text" name="content" data-options="required:true" style="width:300px;height:20px;margin-top:10px "/>   
    </div>       
</form>  