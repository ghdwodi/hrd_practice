package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Comm_GoIndexPage implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "views/index.jsp";
	}
}
