package com.POJO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.memberDAO;

public class DeleteCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		
		memberDAO dao = new memberDAO();
		int cnt = dao.delete(email);
		
		return "selectMember.jsp";
	}
}