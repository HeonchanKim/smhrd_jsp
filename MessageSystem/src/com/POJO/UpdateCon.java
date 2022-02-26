package com.POJO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Command.Command;
import com.DAO.memberDAO;
import com.VO.memberVO;

public class UpdateCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
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
		}
		return "main.jsp";
	}
}