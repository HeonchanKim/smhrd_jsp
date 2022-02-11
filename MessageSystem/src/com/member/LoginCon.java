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
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			
			conn = DriverManager.getConnection(url,dbid,dbpw);
			
			String sql = "select * from message_member where email = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			
			rs = psmt.executeQuery();
			
			if(rs.next()){
				String getemail = rs.getString(1);
				String getpw = rs.getString(2);
				String tel = rs.getString(3);
				String address = rs.getString(4);
				String date = rs.getString(5);
				
				System.out.println(getemail+"\t"+getpw+"\t"+tel+"\t"+address+"\t"+date);
				
				if(pw.equals(getpw)) {
					
					memberVO vo = new memberVO(email, tel, address);
					
					HttpSession session = request.getSession();
					
					session.setAttribute("loginvo", vo);
					
					response.sendRedirect("main.jsp");
				}else {
					
				}
			}else {
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				psmt.close();
				conn.close();			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}// end of service
}// end of class