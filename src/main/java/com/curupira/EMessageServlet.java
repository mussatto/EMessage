package com.curupira;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EMessageServlet extends HttpServlet{

	private static final long serialVersionUID = -3574198280539664812L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		EMessage eMessage = new EMessage(null, title, content, "pt-br", new Date());
		
		eMessage.persist();
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/created.jsp");
		dispatcher.forward(req, resp);
	}

	private EMessage getStarred(){
		return new EMessage("123", "My Starred Prayer", "ye shall be as gods", "pt-br", new Date());
	}

}
