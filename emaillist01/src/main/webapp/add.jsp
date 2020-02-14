<%@ page import="com.douzone.emaillist.vo.EmaillistVo" %>
<%@ page import="com.douzone.emaillist.dao.EmaillistDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");

	String firstName=request.getParameter("fn");
	String lastName= request.getParameter("ln");
	String emaile= request.getParameter("email");
	
	EmaillistVo vo = new EmaillistVo();
	vo.setFirstName(firstName);
	vo.setLastName(lastName);
	vo.setEmail(emaile);
	
	new EmaillistDao().insert(vo);
	response.sendRedirect("/emaillist01");
 %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>성공적으로 추가되었습니다</h1>
</body>
</html>