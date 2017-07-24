package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBPKG.DAO;

public class Comm_GoListPage implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "views/list.jsp";
	}
}
