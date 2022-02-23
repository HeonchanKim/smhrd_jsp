package com.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.memberDAO;
import com.VO.memberVO;

@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. ����ڰ� �Է��� email�� pw�� �޾ƿ��ÿ�
		//2. JDBC�� ���� message_member���̺� �ִ� email�� ������ �˻��Ͻÿ�
		//3. �˻��� ������ pw�� ����ڰ� �Է��� pw�� ��ġ�� ��
		//   session�� 'loginemail'��� name������ �α��γ� ������ email�� �����Ͻÿ�.
		//4. ���� �Ŀ��� 'main.jsp'�� �̵��Ͻÿ�.
		//5. �������� ��(id�� ���� �� / pw�� Ʋ���� ��) �̵��������ÿ�.
		
		request.setCharacterEncoding("euc-kr");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		memberDAO dao = new memberDAO();
		memberVO vo = dao.login(email, pw);
		
		if(vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginvo", vo);
			
			response.sendRedirect("main.jsp");
		}else { // vo=null
			response.sendRedirect("main.jsp");			
		}
	}// end of service
}// end of class