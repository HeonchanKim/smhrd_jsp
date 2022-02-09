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
		//세션데이터생성 / session은 내장객체
		session.setAttribute("NewSession", "HeonchanKim");
	%>
	<h1>세션생성</h1>
</body>
</html>