package jstlel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/03")
public class _03Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 
		 * 1. 객체가 오래 지속되는 순서
		 *  Applcation(Context) Scope> Session Scope > Request Scope > page Scope
		 *  
		 * 2. EL이 같은 이름에 값을 찾는 순서 
		 *  page Scope > Request Scope > Session Scope > Applcation(Context) Scope
		 *  
		 * 주의 : 같은 이름으로 여러 범위에 값을 저장 하지 말것! 
		 * 
		 * 
		 * 
		 */
		
		
		//request scope(session 보단 request가 우선순위를 가진다 )
		List<UserVo> list= new ArrayList<>();
		
		UserVo vo1= new UserVo();
		vo1.setNo(1L);
		vo1.setName("유남길1");
		list.add(vo1);
		
		UserVo vo2= new UserVo();
		vo2.setNo(2L);
		vo2.setName("유남길2");
		
		list.add(vo2);
		UserVo vo3= new UserVo();
		vo3.setNo(3L);
		vo3.setName("유남길3");

		list.add(vo3);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/views/03.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
