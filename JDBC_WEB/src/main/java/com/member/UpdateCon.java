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

@WebServlet("/UpdateCon")
public class UpdateCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String select = request.getParameter("select");
		String data = request.getParameter("data");
		
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			
			conn = DriverManager.getConnection(url,dbid,dbpw);
			
			//String sql = "update web_member set pw = ? where id = ?";
			
			String sql = "";
			
			if(select.equals("pw")) {
				sql ="update web_member set pw = ? where id = ?";
			}else if(select.equals("nick")) {
				sql = "update web_member set nick = ? where id = ?";
			}
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, data);
			psmt.setString(2, id);
			
			
			int cnt = psmt.executeUpdate();
			
			if(cnt>0) {
				response.sendRedirect("Main.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
				conn.close();			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
}