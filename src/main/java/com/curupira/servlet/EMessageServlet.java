package com.curupira.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.curupira.entity.EMessage;

public class EMessageServlet extends HttpServlet{

	private static final long serialVersionUID = -3574198280539664812L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String pass = req.getParameter("pass");
		boolean isEncoded = true;
		
//		if("true".equals(isEncodedStr)){
//			isEncoded=true;
//		}
		EMessage eMessage = createMessage(title, content,isEncoded,pass);
		JSONObject response = getJsonObject(eMessage);
		resp.getWriter().print(response.toString());
		resp.getWriter().close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		doGet(req, resp);
	}

	private EMessage createMessage(String title, String content, boolean isEncoded, String pass) {
		EMessage eMessage = EMessage.createMessage(null, title, content, "pt-br", new Date(), pass);
		if(isEncoded){
			eMessage.encodeContent();
		}
		eMessage.persist();
		return eMessage;
	}

	private JSONObject getJsonObject(EMessage eMessage) {
		JSONObject response = new JSONObject();
		response.put("id", eMessage.getId());
		response.put("pass", eMessage.getPass());
		response.put("encodedMessage", eMessage.getContent());
		return response;
	}

}
