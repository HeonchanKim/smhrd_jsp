<%@page import="java.util.Locale"%>
<%@page import="java.util.GregorianCalendar"%>
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
		//���尴ü : JSP������ Servlet���� ���� ���Ǵ� ��ü�� �̸� ����
	
		out.print("Hello~");
	%>
	
	<table border="1">
		<tr>
			<%-- �Ʒ��� �ִ� td�±׸� 10�� �ݺ��Ͻÿ� --%>
			<%for(int i=1;i<=10;i++){	
				out.print("<td>"+i+"</td>");		
			}%>
		</tr>
	</table>

	<br><br>

	<%
		GregorianCalendar gre = new GregorianCalendar(Locale.KOREA);
		//���� ��¥�� �ð��� �������� ��ü
		
		int year = gre.get(gre.YEAR);
		int month = gre.get(gre.MONTH);
		int date = gre.get(gre.DATE);
		int hour = gre.get(gre.HOUR);
		int min = gre.get(gre.MINUTE);
		int sec = gre.get(gre.SECOND);
		
		out.print(year + "�� " + (month+1) + "�� " + date + "��" + "<br>");
		out.print(hour + "��" + min + "��" + sec + "��" + "<br>");
		
	%>

	<%= year %>�� <%= month+1 %>�� <%=date %>��<br>
	<%= hour %>�� <%= min %>�� <%= sec %>��





















</body>
</html>