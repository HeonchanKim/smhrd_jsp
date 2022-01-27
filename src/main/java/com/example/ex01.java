package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex01")
public class ex01 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Servlet : Server + Applet
		//			WAS(Tomcat)���� ��ġ�Ǿ� �����ϴ� �������α׷�
		//			Java=main / Servlet = service
		
		//�� IP : 211.223.37.142 / 59.0.249.7
		System.out.println("����������");
		
		//request : �������α׷��� ��û�ϴ� ������� ��� �����͸� �����ִ� ��ü
		String ip = request.getRemoteAddr();//������� IP�� ������ �� �ִ� ���
		System.out.println("������ ������� IP : " + ip);
		
		
		//response : �������α׷����� ����ڿ��� ������ �� �� �ְ� ���ִ� ��ü
		response.setContentType("text/html;charset=euc-kr");
		//�����ϴ� ������ �����ϰ� ���ڵ���� ����
		PrintWriter out = response.getWriter();
		//�����ϴ� ���ϰ� ���� �۾��ϰ� �ִ� Servlet������ �̾��ִ� ��ΰ�ü����
		out.print("����������<br>");
		
		
		
		
		//�������� �������� ���� "������ ȯ���մϴ�"�� ���
		//������ �������� ���� "���� ȯ���մϴ�"�� ���
		//�ٸ� ���� �������� ���� "�մ� ȯ���մϴ�"�� ���
		if(ip.equals("59.0.249.7")) {
			out.println("������ ȯ���մϴ�.");
		}else if(ip.equals("59.0.234.149")) {
			out.println("������ IP");
		}else if(ip.equals("211.48.213.202")) {
			out.println("�������� IP");
		}
		else {
			out.println("�մ� ȯ���մϴ�.");
		}
	
		
	}
}