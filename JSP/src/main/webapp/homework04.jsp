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
		<%for(int i=1;i<=5;i++){%>
			<tr>
				<%for(int j=1;j<=i;j++){ %>
					<% 
						String color = "";
						if(i%2==1) {
							color="green";
						}else{
							color="white";
						}
					%>
					<td bgcolor="<%=color %>">*</td>
				<%} %>
			</tr>
		<%}%>
	</table>



</body>
</html>