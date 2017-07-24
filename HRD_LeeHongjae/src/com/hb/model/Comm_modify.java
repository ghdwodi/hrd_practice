package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBPKG.DAO;
import DBPKG.MemberVO;

public class Comm_modify implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberVO mvo = new MemberVO();
		DAO dao = new DAO();
		mvo.setCustno(Integer.parseInt(request.getParameter("custno")));
		mvo.setCustname(request.getParameter("custname"));
		mvo.setPhone(request.getParameter("phone"));
		mvo.setAddress(request.getParameter("address"));
		mvo.setGrade(request.getParameter("grade"));
		mvo.setCity(request.getParameter("city"));
		dao.modifyMember(mvo);
		return "views/list.jsp";
	}
}
