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
		String id = request.getParameter("id");
	%>
	<h1><%=id %>님 로그인에 성공하셨습니다</h1>
	<a href="Main.html">메인으로 돌아가기</a>
</body>
</html>