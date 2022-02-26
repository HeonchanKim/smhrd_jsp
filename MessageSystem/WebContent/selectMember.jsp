<%@page import="com.VO.memberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		
	</head>
	<style>
	
	</style>
	<body style="text-align: center;">
		<!-- 
			1. DAO 생성(memberDAO)
			2. DAO - 메서드(selectAll) 생성 -> BoardDAO(getList()참고)
			3. jsp 파일 -> board_list.jsp 참고
		 -->
		 <%
		 	memberDAO dao = new memberDAO();
		 	ArrayList<memberVO> al = dao.selectAll();
		 %>
		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<table>
							<caption><h2>회원관리페이지</h2></caption>
							<tr>
								<td>Email</td>
								<td>HP</td>
								<td>Addr</td>						
							</tr>
							<%
								for(int i = 0;i < al.size();i++){
									out.print("<tr>");
									out.print("<td>"+al.get(i).getEmail()+"</td>");
									out.print("<td>"+al.get(i).getTel()+"</td>");
									out.print("<td>"+al.get(i).getAddress()+"</td>");
									out.print("<td><a href='DeleteCon.do?email=" + al.get(i).getEmail() + "'>삭제</a></td>");
									out.print("</tr>");
								}
							%>
						</table>
						<a href="main.jsp">메인페이지이동</a>
					</nav>			
			</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
	</body>
</html>

