package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBPKG.DAO;
import DBPKG.MemberVO;

public class Comm_insert implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberVO mvo = new MemberVO();
		DAO dao = new DAO();
		String result = "";
		mvo.setCustname(request.getParameter("custname"));
		mvo.setPhone(request.getParameter("phone"));
		mvo.setAddress(request.getParameter("address"));
		mvo.setGrade(request.getParameter("grade"));
		mvo.setCity(request.getParameter("city"));
		if(dao.insertMember(mvo)>0){
			result = "success";
		}else{
			result = "fail";
		}
		request.getServletContext().setAttribute("insertResult", result);
		return "views/insert.jsp";
	}
}
