package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex02")
public class ex02 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request : ��û�� ���� ����
		String num1 = request.getParameter("num1");
		String num2 =  request.getParameter("num2");
		//����ڰ� �Է��� ������ �������� ���
		
		String cal = request.getParameter("cal");
		
		int num3 = Integer.parseInt(num1);
		int num4 = Integer.parseInt(num2);
		
		System.out.println(num3+num4);
		
		//response : ���信 ���� ����
		//���� ������ ����
		response.setContentType("text/html;charset=euc-kr");
		//Ŭ���̾�Ʈ - ���� �������ִ� ���(��Ʈ��)
		PrintWriter out = response.getWriter();
		
		//����ڰ� ������ ���� ���ؼ� �ش��ϴ� ��Ģ���� ������� ����Ͻÿ�.
		if(cal.equals("+")) {
			//��Ʈ���� ���ؼ� ���
			out.print(num3+num4);			
		}else if(cal.equals("-")) {
			out.print(num3-num4);						
		}else if(cal.equals("*")) {
			out.print(num3*num4);						
		}else if(cal.equals("/")) {
			out.print(num3*num4);						
		}
		
		
		
		
	}
}