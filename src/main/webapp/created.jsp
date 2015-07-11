<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curupira.entity.EMessage" %>
<!DOCTYPE html>
<html>
	<jsp:include page="includes/head.jsp"></jsp:include>
	<body>
	<jsp:include page="includes/menu.jsp"></jsp:include>
	
	<%
		Long id = (Long) request.getAttribute("id"); 
		String pass = (String) request.getAttribute("pass");
	%>
	<div class="container">

      <p>Message created successfully!</p>
      <p>message id: <%= id %></p>
      <p>message pass: <%= pass %>

    </div>
</html>


