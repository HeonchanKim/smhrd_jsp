package com.POJO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.memberDAO;

public class JoinCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		memberDAO dao = new memberDAO();
		int cnt = dao.join(email, pw, tel, address);
		
		return "main.jsp";
	}
}