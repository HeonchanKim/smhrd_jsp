package com.POJO;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.memberDAO;

public class IdCheckCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//1. email �� �ޱ�(getParameter���)
		String email = request.getParameter("email");
		
		//2. memberDAO email�� ����� �� �ִ� email���� Ȯ�����ִ� �޼���(idCheck())
		//��ȯ�� : �ִ� ���̵�� true / ���� ���̵�� false
		//=>Ÿ��Ȯ��
		
		//3. console�� true/false(��ȯ��) ���
		memberDAO dao = new memberDAO();
		boolean check = dao.idCheck(email);
		
		return String.valueOf(check); //boolean -> string
	}
}