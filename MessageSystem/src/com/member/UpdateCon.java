package com.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.memberDAO;
import com.VO.memberVO;

@WebServlet("/UpdateCon")
public class UpdateCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 데이터 인코딩
		request.setCharacterEncoding("euc-kr");
		
		//pw, tel, address / email -> session
		HttpSession session = request.getSession();
		memberVO vo = (memberVO)session.getAttribute("loginvo");
		
		String email = vo.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		//JDBC_WEB 프로젝트 => UpdateCon 참고
		//MessageSystem -> JoinCon 참고
		
		//수정 성공 -> 콘솔창에 "수정성공" 출력 (페이지 이동x)
		//수정 실패 -> 콘솔창에 "수정실패" 출력 (페이지 이동x)
		
		memberDAO dao = new memberDAO();
		int cnt = dao.update(email, pw, tel, address);
		
		if(cnt>0) {
			System.out.println("수정성공");
			
			//사용자의 수정된 값을 가지고 있는 vo
			memberVO vo2 = new memberVO(email, tel, address);
			session.setAttribute("loginvo", vo2);
			
			response.sendRedirect("main.jsp");
		}else {
			System.out.println("수정실패");				
			response.sendRedirect("main.jsp");
		}
	} // end of service
}// end of class