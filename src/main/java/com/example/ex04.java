package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex04")
public class ex04 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		//POST방식일때 인코딩방식(습관)
		
		// String text = request.getParameter("text");
		String hobby[] = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		
		String hobby_res = "";
		
		for (int i = 0; i < hobby.length; i++) {
			hobby_res += hobby[i];
		}
		
		System.out.println("취미 : " + hobby_res);
		System.out.println("성별 : " + gender);
		
	}
}