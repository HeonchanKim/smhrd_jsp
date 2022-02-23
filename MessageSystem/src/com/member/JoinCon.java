package com.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.memberDAO;

@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. main.jsp���� ����ڰ� �����ִ� ������ �����ÿ�(POST)
		//2. JDBC�� ���� DB�� �����Ͽ� message_member���̺� ������� ������ �����Ͻÿ�	
		//3. ���� �Ϸ� �� main.jsp �̵��Ͻÿ�. 
		
		request.setCharacterEncoding("euc-kr");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		memberDAO dao = new memberDAO();
		int cnt = dao.join(email, pw, tel, address);
		
		if(cnt>0) {
			response.sendRedirect("main.jsp");
		}else {
			response.sendRedirect("main.jsp");			
		}
	}// end of service
}// end of class