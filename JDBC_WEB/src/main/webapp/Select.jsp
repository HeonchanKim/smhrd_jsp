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
	<h1>ȸ����ü�˻� ������</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>NICK</th>
			<th>����</th>
		</tr>
		<%
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
				String dbid = "hr";
				String dbpw = "hr";
				
				conn = DriverManager.getConnection(url,dbid,dbpw);
				
				String sql = "select * from web_member";
				
				psmt = conn.prepareStatement(sql);
				
				rs = psmt.executeQuery();
				
				while(rs.next()){
					String id = rs.getString(1);
					String pw = rs.getString(2);
					String nick = rs.getString(3);
					
					//1. Scritlet
					//2. out���尴ü
									
					out.print("<tr>");
					out.print("<td>"+id+"</td>");
					out.print("<td>"+pw+"</td>");
					out.print("<td>"+nick+"</td>");
					out.print("<td><a href='DeleteCon?id="+id+"'>����</a></td>");
					//DeleteCon�� �̵��ϰ� QueryString ����� ����
					//name(id) = value(����id)�� �����ÿ�
					out.print("</tr>");
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
		%>
	</table>
	<a href="Main.jsp">������������ ���ư���</a>
</body>
</html>