<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% //��ũ��Ʋ��(Scriptlet) : JSP���� Java�ڵ带 ������ �� �ִ� ����
	
		/*JSP(Java Server Page)
			�����ϴ� �������� ���� ���� �� �ִ� ����������(�����ڸ� ���� ������)
			������� : ��û -> JSP -> Tomcat -> Servlet -> class -> �޸����� -> HTML -> ����
			�������(�ι�°����) : ��û -> JSP -> �޸𸮿� ����� class -> HTML -> ����
		*/
		
		int num = 10;
		
	%>
	
	num���� �ȿ� �ִ� �� : <b><%= num %></b>
	<%-- ǥ����(expression) : JSP������ ������ �޼ҵ带 ����� �� �ִ� ���� --%>
	
	
	<%
		//1~100������ ���� ����Ͻÿ�
		int sum = 0;
		for(int i = 1;i <= 100;i++){
			sum += i;
		}
		
	%>
	<br><br>1~100������ �� : <%= sum %>
	
	
	
	
	<table border="1">
		<tr>
			<%-- �Ʒ��� �ִ� td�±׸� 10�� �ݺ��Ͻÿ� --%>
			<%for(int i=1;i<=10;i++){%>	
			<td><%= i %></td>
			<%}%>
		</tr>
	</table>
	
	
	
	<%! // ���� : JSP������ �޼ҵ峪 ����� ����(X) -> .java������ �����þ �޼ҵ带 ����
	
		public void sum(int num1, int num2){
			System.out.print(num1+num2);
		}
	%>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>