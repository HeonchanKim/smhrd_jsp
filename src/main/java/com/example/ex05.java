package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05")
public class ex05 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pwCheck = request.getParameter("pwCheck");		
		String gender = request.getParameter("gender");
		String bloodType = request.getParameter("bloodType");
		String date = request.getParameter("date");	
		String hobby[] = request.getParameterValues("hobby");
		String color = request.getParameter("color");		
		String text = request.getParameter("text");
		
		String hobby_res = "";		
		for (int i = 0; i < hobby.length; i++) {
			hobby_res += hobby[i]+" ";
		}
				
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		out.print("id : " + id+"<br>");
		out.print("pw : " + pw+"<br>");
		out.print("pwȮ�� : " + pwCheck+"<br>");
		out.print("���� : " + gender+"<br>");
		out.print("������ : " + bloodType+"<br>");
		out.print("���� : " + date+"<br>");
		out.print("��� : " + hobby_res+"<br>");
		out.print("�����ϴ� ���� : " + color+"<br>");
		out.print("���� ���� �� : " + text);
		
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("pwȮ�� : " + pwCheck);
		System.out.println("���� : " + gender);
		System.out.println("������ : " + bloodType);
		System.out.println("���� : " + date);	
		System.out.println("��� : " + hobby_res);	
		System.out.println("�����ϴ� ���� : " + color);
		System.out.println("���� ���� �� : " + text);
		
		
		
		
		
		
		
		
		
		
	}
}