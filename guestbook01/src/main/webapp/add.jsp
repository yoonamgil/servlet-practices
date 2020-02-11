
<%@ page import="com.douzone.guestbook.vo.GuestBookVo" %>
<%@ page import="com.douzone.guestbook.dao.GuestBookDao" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("name");
	String password=request.getParameter("password");
	String message=request.getParameter("message");
	
	GuestBookVo vo= new GuestBookVo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setContents(message);
	
	if(!(vo.getName().isEmpty()||vo.getPassword().isEmpty()||vo.getContents().isEmpty()))
		new GuestBookDao().insert(vo);
	

	response.sendRedirect("/guestbook01/index.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>