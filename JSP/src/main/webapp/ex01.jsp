<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% //스크립틀릿(Scriptlet) : JSP에서 Java코드를 구현할 수 있는 영역
	
		/*JSP(Java Server Page)
			응답하는 페이지를 쉽게 만들 수 있는 서버페이지(개발자를 위한 페이지)
			실행과정 : 요청 -> JSP -> Tomcat -> Servlet -> class -> 메모리저장 -> HTML -> 응답
			실행과정(두번째부터) : 요청 -> JSP -> 메모리에 저장된 class -> HTML -> 응답
		*/
		
		int num = 10;
		
	%>
	
	num변수 안에 있는 값 : <b><%= num %></b>
	<%-- 표현식(expression) : JSP내에서 변수나 메소드를 출력할 수 있는 영역 --%>
	
	
	<%
		//1~100까지의 합을 출력하시오
		int sum = 0;
		for(int i = 1;i <= 100;i++){
			sum += i;
		}
		
	%>
	<br><br>1~100까지의 합 : <%= sum %>
	
	
	
	
	<table border="1">
		<tr>
			<%-- 아래에 있는 td태그를 10번 반복하시오 --%>
			<%for(int i=1;i<=10;i++){%>	
			<td><%= i %></td>
			<%}%>
		</tr>
	</table>
	
	
	
	<%! // 선언문 : JSP내에서 메소드나 상수를 선언(X) -> .java파일을 만ㄷ늘어서 메소드를 선언
	
		public void sum(int num1, int num2){
			System.out.print(num1+num2);
		}
	%>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>