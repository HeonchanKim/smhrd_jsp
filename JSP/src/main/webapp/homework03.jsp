<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


	<table border="1">
		<%for(int i=1;i<=9;i++){%>
			<tr>
				<%for(int j=1;j<=9;j++){ %>
					<% 
						String color = "";
						if(i*j % 2 == 0) {
							color="yellow";
						}else{
							color="white";
						}
					%>
					<td bgcolor="<%=color %>"><%=i %>*<%=j %>=<%=i*j %></td>
				<%} %>
			</tr>
		<%}%>
	</table>




</body>
</html>