<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>회원검색 페이지</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>NICK</th>
		</tr>
		<%	
			// OneSelect.html에서 검색하는 id를 받아 해당 id의 정보를 출력하시오
			
			Connection conn = null;
			PreparedStatement psmt = null;
			String id = request.getParameter("id");
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
				String dbid = "hr";
				String dbpw = "hr";
				
				conn = DriverManager.getConnection(url,dbid,dbpw);
				
				String sql = "select * from web_member where id = ?";
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				
				ResultSet rs = psmt.executeQuery();
				
				while(rs.next()){
					String getid = rs.getString(1);
					String pw = rs.getString(2);
					String nick = rs.getString(3);
					
					//1. Scritlet
					//2. out내장객체
									
					out.print("<tr>");
					out.print("<td>"+getid+"</td>");
					out.print("<td>"+pw+"</td>");
					out.print("<td>"+nick+"</td>");
					out.print("</tr>");
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
		%>
	</table>
	<a href="Main.html">메인페이지로 돌아가기</a>
</body>
</html>