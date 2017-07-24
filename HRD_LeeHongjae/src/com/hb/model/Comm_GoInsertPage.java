package com.hb.model;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBPKG.DAO;

public class Comm_GoInsertPage implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH)+1);
		String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		if(month.length()<2){
			month = "0"+month;
		}
		if(day.length()<2){
			day = "0"+day;
		}
		String date = year+month+day;
		DAO dao = new DAO();
		int newCustno = dao.getNextCustno();
		request.getSession().setAttribute("custno", newCustno);
		request.getSession().setAttribute("joindate", date);
		return "views/insert.jsp";
	}
}
