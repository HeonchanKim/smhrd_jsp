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
		String str = (String)session.getAttribute("NewSession");
	%>
	NewSession�� �ִ� ������ : <%=str %>
	
	<a href="ex03Session.jsp">���ǻ����ϱ�</a>
</body>
</html>