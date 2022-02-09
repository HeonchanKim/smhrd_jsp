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

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// 1.사용자가 입력한 ID/PW를 가져오시오.
		String id = request.getParameter("id");
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
			
			String sql = "select * from web_member where id = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()){
				String getId = rs.getString(1);
				String getPw = rs.getString(2);
				String nick = rs.getString(3);
				
				//사용자가 입력한 pw와 DB 가져온 pw가 일치하면 'LoginS.jsp'이동하고
				//							  일치하지않으면 'LoginF.jsp'이동
				
				if(pw.equals(getPw)) {
					
					//쿠키를 활용한 아이디값 저장
					//Cookie cook = new Cookie("loginid", id);
					//response.addCookie(cook);
					
					HttpSession session = request.getSession();
					//Servlet은 내장객체가 없기 때문에 session객체생성
					
					session.setAttribute("loginid", id);
					//session영역에 데이터생성
					
					response.sendRedirect("LoginS.jsp?id="+id);
					
					//URL을 통해서 데이터를 전송하는 방식
					//QueryString
					//        ex04         ?
					//보내려고하는 파일의 이름 QueryString시작
					//     name			= 	  value
					//보내려는 데이터에 이름표		보내는 데이터
					
					
				}else {
					response.sendRedirect("LoginF.jsp");
				}
			}else {
				response.sendRedirect("LoginF.jsp");				
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
}