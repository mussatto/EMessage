package com.curupira.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.curupira.entity.EMessage;

public class DecoderServlet extends HttpServlet{

	private static final long serialVersionUID = 257061602133135926L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		if(id ==null || pass==null){
			resp.getWriter().print("");
			resp.getWriter().close();
			return;
		}
		
		long longId = Long.valueOf(id);
		
		EMessage message = EMessage.find(longId);
		String decodedMessage = message.decodeContent(pass);
		
		JSONObject response = getJsonObject(decodedMessage, message.getTitle());
		
		resp.getWriter().print(response.toString());
		resp.getWriter().close();
		
	}

	private JSONObject getJsonObject(String decodedMessage, String title) {
		JSONObject response = new JSONObject();
		response.put("response", decodedMessage);
		response.put("title", title);
		return response;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}
}
