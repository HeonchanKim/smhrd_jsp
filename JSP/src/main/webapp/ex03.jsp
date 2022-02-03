<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<style>
	tr{
		height: 40px;
		text-align: center;
	}
	table{
		margin: 0 auto;
		table-layout: fixed;
	}
</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%	//��ũ��Ʋ��(Scriptlet)
		request.setCharacterEncoding("euc-kr");
	
		String name = request.getParameter("name");
		String java = request.getParameter("java");
		String web = request.getParameter("web");
		String iot = request.getParameter("iot");
		String android = request.getParameter("android");
		
		int java1 = Integer.parseInt(java);
		int web1 = Integer.parseInt(web);
		int iot1 = Integer.parseInt(iot);
		int android1 = Integer.parseInt(android);
		
		int sum = java1+web1+iot1+android1;
		int avg = sum/4;
		String grade = "";
		
		if(avg >= 95){
			grade = "A+";
		}else if(avg >= 85){
			grade = "A";
		}else if(avg >= 75){
			grade = "B";		
		}else if(avg >= 65){
			grade = "C";
		}else {
			grade = "F";
		}
	%>
	
	<%-- 
	NAME : <%=name %><br>
	JAVA : <%=java %><br>
	WEB : <%=web %><br>
	IoT : <%=iot %><br>
	Android : <%=android %><br>
	--%>
	
	<fieldset>
		<legend>����Ȯ�����α׷�</legend>
		<table width="500">	
			<tr>
				<td>�̸�</td>
				<td><%=name %></td>
				<%--ǥ����(expression) --%>
			</tr>
			<tr>
				<td>JAVA����</td>
				<td><%=java %></td>
			</tr>
			<tr>
				<td>WEB����</td>
				<td><%=web %></td>
			</tr>
				<tr>
				<td>IOT����</td>
				<td><%=iot %></td>
			</tr>		
			<tr>
				<td>ANDROID����</td>
				<td><%=android %></td>
			</tr>																																			
			<tr>
				<td>��������</td>
				<td><%=sum %></td>
			</tr>																																			
			<tr>
				<td>�������</td>
				<td><%=avg %></td>
			</tr>
			<%-- ���:100~95 A+ / 94~85 A / 84~75 B / 74~65 C / 65 ~ F --%>																																			
			<tr>
				<td>����</td>
				<td><%=grade %></td>
			</tr>																																			
		</table>
	</fieldset>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>