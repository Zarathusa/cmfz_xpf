<%@page  pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("path",request.getContextPath());
 %>
<audio  id="playAudioJsp" src="${path}/audio/${param.url}" controls="controls">
你的浏览器不支持！
</audio>