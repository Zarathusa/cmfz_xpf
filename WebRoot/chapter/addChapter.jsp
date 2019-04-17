<%@page  pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("path",request.getContextPath());
 %>


<form id="addChapterForm" method="post" enctype="multipart/form-data">
	<div>   
        <label >章节标题:</label> <br>   
        <input class="easyui-validatebox" type="text" name="title" data-options="required:true" style="width:300px;height:20px;margin-top:10px "/>   
    </div>
   
	<div> 
        <label >音频上传:</label><br>   
        <input class="easyui-filebox" name="audioUpload" data-options="required:true" style="width:300px;height:20px;margin-top:10px ">   
    </div> 
       
    <div>   
        <input  type="hidden" name="album_id" value="${param.id}" style="width:300px;height:20px;margin-top:10px "/>   
    </div>       
</form>  