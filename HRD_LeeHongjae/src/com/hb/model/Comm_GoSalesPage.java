package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Comm_GoSalesPage implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "views/sales.jsp";
	}
}
