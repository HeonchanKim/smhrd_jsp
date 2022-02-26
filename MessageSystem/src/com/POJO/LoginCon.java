package com.POJO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Command.Command;
import com.DAO.memberDAO;
import com.VO.memberVO;

public class LoginCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		memberDAO dao = new memberDAO();
		memberVO vo = dao.login(email, pw);
		
		if(vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginvo", vo);
		}
		
		//어디로 이동할건지
		return "main.jsp";
	}

	

} // end of class