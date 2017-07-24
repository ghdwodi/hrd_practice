package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBPKG.DAO;

public class Comm_GoModifyPage implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		int custno = Integer.parseInt(request.getParameter("custno"));
		DAO dao = new DAO();
		request.getSession().setAttribute("mvo", dao.getOneMember(custno));
		return "views/modify.jsp";
	}
}
