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
		
		// 1.����ڰ� �Է��� ID/PW�� �������ÿ�.
		// 2.����ڰ� �Է��� ID�� 'smart'�̰� PW�� '123'�� ��
		//   �������� ���� 'LoginS.jsp'�� �̵��ϰ�
		//   �������� ���� 'LoginF.jsp'�� �̵�
		
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