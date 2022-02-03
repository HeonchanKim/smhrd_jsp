<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		//response.setContentType("text/html;charset=euc-kr");
		//PrintWriter out = response.getWriter();
		
		//response.sendRedirect("http://naver.com");
		// 외부,내부페이지로 이동하는 기능
		//response.sendRedirect("ex04.html");
		response.sendRedirect(request.getParameter("page"));				
	%>
	
	
</body>
</html>