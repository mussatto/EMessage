package com.curupira;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 26169230929589631L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		req.setAttribute("prayer", getStarred());
		
		dispatcher.forward(req, resp);
	}

	private EMessage getStarred(){
		return new EMessage("123", "My Starred Prayer", "ye shall be as gods", "pt-br", new Date());
	}
	
}
