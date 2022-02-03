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
		<tr>
			<%--1~20까지 숫자를 아래의 td태그에 출력하시오 --%>
			<%--ex04.html파일을 만들어서 입력받은 값만큼 아래의 반복문 반복 --%>
			
			<%
				int num = Integer.parseInt(request.getParameter("num"));
				for(int i=1;i<=num;i++) {%>
				<td><%=i %></td>
			<%} %>
			
			
			
			
			<%--
			<%for(int i=1;i<=20;i++) {%>
				<%
					String color = "";
					if(i%10==3||i%10==6){
						color = "green";
					}else if(i%10==5){
						color = "blue";
					}
				%>
				<td bgcolor="<%=color%>"><%=i %></td>
			<%} %>
			 --%>
		</tr>
	</table>
</body>
</html>