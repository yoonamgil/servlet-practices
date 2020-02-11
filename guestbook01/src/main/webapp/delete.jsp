<%@ page import="com.douzone.guestbook.vo.GuestBookVo" %>
<%@ page import="com.douzone.guestbook.dao.GuestBookDao" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String no=request.getParameter("no");
	String password=request.getParameter("password");
	Long reno=Long.parseLong(no);
	
	GuestBookVo vo= new GuestBookVo();
	vo.setNo(reno);
	vo.setPassword(password);
	
	new GuestBookDao().delete(vo);
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