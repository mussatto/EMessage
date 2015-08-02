	package com.curupira.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.curupira.MessageEncoder;

public class MessageContentDecoderServlet  extends HttpServlet{

	private static final long serialVersionUID = 1566713066669601572L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		String content = req.getParameter("encodedcontent");
		String pass = req.getParameter("pass");
		if(content ==null || pass==null || "".equals(content) || "".equals(pass)){
			resp.getWriter().print("");
			resp.getWriter().close();
			return;
		}
		
		String decodedMessage = MessageEncoder.decode(content.trim(), pass.trim());
		JSONObject response = getJsonObject(decodedMessage);
		
		resp.getWriter().print(response.toString());
		resp.getWriter().close();
		
	}
	
	private JSONObject getJsonObject(String decodedMessage) {
		JSONObject response = new JSONObject();
		response.put("response", decodedMessage);
		return response;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}

}
