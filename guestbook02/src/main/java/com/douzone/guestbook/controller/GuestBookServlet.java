package com.douzone.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.guestbook.dao.GuestBookDao;
import com.douzone.guestbook.vo.GuestBookVo;




public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		String action;
		action = request.getParameter("a");
		
		if ("add".equals(action)) {

			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String message=request.getParameter("message");
			
			GuestBookVo vo= new GuestBookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setContents(message);
			
			if(!(vo.getName().isEmpty()||vo.getPassword().isEmpty()||vo.getContents().isEmpty()))
				new GuestBookDao().insert(vo);
			

			response.sendRedirect(request.getContextPath()+"/gb");
		} else if ("delete".equals(action)) {

			String no=request.getParameter("no");
			String password=request.getParameter("password");
			Long reno=Long.parseLong(no);
			
			GuestBookVo vo= new GuestBookVo();
			vo.setNo(reno);
			vo.setPassword(password);
			
			new GuestBookDao().delete(vo);
			response.sendRedirect(request.getContextPath()+"/gb");
		} else if ("deleteform".equals(action)) {

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
		} 
		
		else {
			// list(default)

			List<GuestBookVo> list = new GuestBookDao().findAll();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);

		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
