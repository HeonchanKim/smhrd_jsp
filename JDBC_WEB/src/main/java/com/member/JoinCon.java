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


@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		
		//JDBC
		//0. ojdbc6라이브러리 추가
		
		//자바에서는 크게 2가지오류
		//1. 컴파일오류 : 문법적인 오류
		//2. 런타일오류 : 실행을 해야지만 알 수 있는 오류(채팅, 파일...) => 무조건 예외처리를 해줘야한다
		
		try {
			//1. 동적로딩(Servlet파일은 우리가 어떤 DBMS를 사용하는지 모르기때문에)
			//DB->DBMS(oracle,mysql,mssql ...)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. oracle에 가서 id/pw를 인증받아야함
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			
			Connection conn = DriverManager.getConnection(url,dbid,dbpw);
			
			//3. SQL준비
			String sql = "insert into web_member values(?,?,?)";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, nick);
			
			//4. SQL실행
			int cnt = psmt.executeUpdate();
			
			//5. 실행 후 처리
			if(cnt>0) {
				response.sendRedirect("Main.html");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}




















