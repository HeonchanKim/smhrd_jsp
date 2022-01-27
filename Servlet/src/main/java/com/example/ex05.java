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
		out.print("pw확인 : " + pwCheck+"<br>");
		out.print("성별 : " + gender+"<br>");
		out.print("혈액형 : " + bloodType+"<br>");
		out.print("생일 : " + date+"<br>");
		out.print("취미 : " + hobby_res+"<br>");
		out.print("좋아하는 색깔 : " + color+"<br>");
		out.print("적고 싶은 말 : " + text);
		
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("pw확인 : " + pwCheck);
		System.out.println("성별 : " + gender);
		System.out.println("혈액형 : " + bloodType);
		System.out.println("생일 : " + date);	
		System.out.println("취미 : " + hobby_res);	
		System.out.println("좋아하는 색깔 : " + color);
		System.out.println("적고 싶은 말 : " + text);
		
		
		
		
		
		
		
		
		
		
	}
}