<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>����������</h1>
	<a href="Join.html"><button>ȸ������</button></a>
	<a href="Delete.html"><button>ȸ������</button></a>
	<a href="Update.html"><button>ȸ������</button></a>
	
	<a href="Select.jsp"><button>ȸ����ü�˻�</button></a>
	<a href="OneSelect.html"><button>ȸ���˻�</button></a>
	
	<%--
		//��Ű
		Cookie[] cookies = request.getCookies();
		
		if(cookies!=null){
			for(int i = 0;i<cookies.length;i++){
				
				if(cookies[i].getName().equals("loginid")){
					out.print("<a href='#'><button>�α׾ƿ�</button></a>");
				}
				
				if(cookies[i].getName() == null){
					out.print("<a href='Login.html'><button>�α���</button></a>");
				}
			}//end of for
		}else{
			out.print("<a href='Login.html'><button>�α���</button></a>");
	 	}
	 --%>
	
	<%
		//����
		String login = (String)session.getAttribute("loginid");
	
		if(login == null){
			out.print("<a href='Login.html'><button>�α���</button></a>");
		}else{
			out.print("<a href='#'><button>�α׾ƿ�</button></a>");
		}
	
	%>
	
</body>
</html>