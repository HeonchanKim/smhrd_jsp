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
		int num1 = Integer.parseInt(request.getParameter("num1"));
	
	%>


	<table border="1">
		<%for(int i=1;i<=9;i++){ %>
			<tr>
				<td>
					<%=num1 %>*<%=i %>=<%=num1*i %>
				</td>
			</tr>
		<%} %>
	</table>
</body>
</html>