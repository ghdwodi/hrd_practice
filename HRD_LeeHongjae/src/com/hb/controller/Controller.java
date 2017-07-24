package com.hb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.Comm_GoIndexPage;
import com.hb.model.Comm_GoInsertPage;
import com.hb.model.Comm_GoListPage;
import com.hb.model.Comm_GoModifyPage;
import com.hb.model.Comm_GoSalesPage;
import com.hb.model.Command;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,char=utf-8");
//		PrintWriter out = response.getWriter();
		
		String cmd = request.getParameter("cmd");
		Command comm = null;
		System.out.println(cmd);
		if(cmd.equals("index")){
			comm = new Comm_GoIndexPage(); 
		}else if(cmd.equals("insert")){
			comm = new Comm_GoInsertPage();
		}else if(cmd.equals("list")){
			comm = new Comm_GoListPage();
		}else if(cmd.equals("modify")){
			comm = new Comm_GoModifyPage();
		}else if(cmd.equals("sales")){
			comm = new Comm_GoSalesPage();
		}
		
		String result = comm.exec(request, response);
		response.sendRedirect(result);
	}

}
