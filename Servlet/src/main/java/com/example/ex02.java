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
		
		//request : 요청에 대한 정보
		String num1 = request.getParameter("num1");
		String num2 =  request.getParameter("num2");
		//사용자가 입력한 정보를 가져오는 기능
		
		String cal = request.getParameter("cal");
		
		int num3 = Integer.parseInt(num1);
		int num4 = Integer.parseInt(num2);
		
		System.out.println(num3+num4);
		
		//response : 응답에 대한 정보
		//응답 데이터 형식
		response.setContentType("text/html;charset=euc-kr");
		//클라이언트 - 서버 연결해주는 통로(스트림)
		PrintWriter out = response.getWriter();
		
		//사용자가 선택한 값을 통해서 해당하는 사칙연산 결과값을 출력하시오.
		if(cal.equals("+")) {
			//스트림을 통해서 출력
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