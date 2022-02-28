package com.FrontController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.POJO.DeleteCon;
import com.POJO.IdCheckCon;
import com.POJO.JoinCon;
import com.POJO.LoginCon;
import com.POJO.LogoutCon;
import com.POJO.UpdateCon;

//확장자 패턴 사용 : 어떤 요청이던 간에 뒤에 .do가 붙어있으면 이 서블릿에서 받아서 처리
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		System.out.println("frontcontroller 도착!");
		
		//요청 URI
		String reqURI = request.getRequestURI();
		System.out.println("요청 URI : " + reqURI);
		
		//프로젝트명
		String path = request.getContextPath();
		System.out.println("프로젝트 명 : " + path);
		
		//문자열자르기 -> reqURI - 프로젝트명/
		String result = reqURI.substring(path.length()+1);
		System.out.println(result);
		
		Command command = null;		
		
		if(result.equals("LoginCon.do")) {
			//LoginCon(Command 구현)
			//execute 메서드 호출
			command = new LoginCon();
		}else if(result.equals("JoinCon.do")) {
			command = new JoinCon();
		}else if(result.equals("UpdateCon.do")) {
			command = new UpdateCon();		
		}else if(result.equals("DeleteCon.do")) {
			command = new DeleteCon();		
		}else if(result.equals("LogoutCon.do")) {
			command = new LogoutCon();
		}else if(result.equals("IdCheckCon.do")) {
			command = new IdCheckCon();			
		}
		
		String url = command.execute(request, response);
		
		if(url.equals("true")||url.equals("false")) {
			PrintWriter out = response.getWriter();
			out.print(url);
		}else if(url.equals("joinSuccess.jsp")){
			//포워딩 방식으로 이동할 경로 지정
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		}else{
			response.sendRedirect(url);
		}
		
		
	}
}