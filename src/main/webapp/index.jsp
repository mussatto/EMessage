<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curupira.entity.EMessage" %>
<!DOCTYPE html>
<html>
	<jsp:include page="includes/head.jsp"></jsp:include>
	<body>
	<jsp:include page="includes/menu.jsp"></jsp:include>
	
	
	<div class="container">

      <div>
        <h1>eMessaging</h1>
        <p class="lead">Send messages to your friends in any language!</p>
        
        <div>
        	<a href="/create_message.jsp">Create a Message!</a>
        </div>
        <div>
        	<a href="/decode_message.jsp">Decode a Message!</a>
        </div>
      </div>

    </div>
</html>


