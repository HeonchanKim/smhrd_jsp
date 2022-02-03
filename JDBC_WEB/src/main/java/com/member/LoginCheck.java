package com.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.사용자가 입력한 ID/PW를 가져오시오.
		// 2.사용자가 입력한 ID가 'smart'이고 PW가 '123'일 때
		//   성공했을 때는 'LoginS.jsp'로 이동하고
		//   실패했을 때는 'LoginF.jsp'로 이동
		
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("smart") && pw.equals("123")){
			response.sendRedirect("LoginS.jsp");
		}else{
			response.sendRedirect("LoginF.jsp");			
		}
	}
}