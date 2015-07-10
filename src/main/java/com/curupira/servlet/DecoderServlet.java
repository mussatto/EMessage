package com.curupira.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curupira.entity.EMessage;

public class DecoderServlet extends HttpServlet{

	private static final long serialVersionUID = 257061602133135926L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/decoded.jsp");
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		if(id ==null || pass==null){
			dispatcher.forward(req, resp);
		}
		
		long longId = Long.valueOf(id);
		EMessage message = EMessage.find(longId);
		
		String decodedMessage = message.decodeContent(pass);
		req.setAttribute("decodedMessage", decodedMessage);
		
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}
}
