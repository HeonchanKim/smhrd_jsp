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
		//Cookie : 사용자의 PC에 서버페이지에서 공유할 데이터를 저장하는 기술
		Cookie cook = new Cookie("NewCookie", "HeonchanKim"); //쿠키생성
								//Name			Value
		response.addCookie(cook); //사용자에게 쿠키를 응답
	%>

	<h1>쿠키생성완료</h1>


</body>
</html>