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

@WebServlet("/DeleteCon")
public class DeleteCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String email = request.getParameter("email");
		memberDAO dao = new memberDAO();
		int cnt = dao.delete(email);
		
		if(cnt > 0) {
			response.sendRedirect("selectMember.jsp");
		}else {
			response.sendRedirect("selectMember.jsp");			
		}
		
	}//end of service
}