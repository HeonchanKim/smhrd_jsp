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
		String color = request.getParameter("color");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
	%>
	
	
	<table border="1">
		<%for(int i=num1;i<=num2;i++){%>
			<tr bgcolor="#<%=color %>">
				<%for(int j=1;j<=9;j++){ %>
					<td><%=i %>*<%=j %>=<%=i*j %></td>
				<%} %>
			</tr>
		<%}%>
	</table>
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>