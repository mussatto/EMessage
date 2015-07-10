<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curupira.entity.EMessage" %>
<!DOCTYPE html>
<html>
	<jsp:include page="includes/head.jsp"></jsp:include>
	<body>
	<jsp:include page="includes/menu.jsp"></jsp:include>
	<% String decoded = (String) request.getAttribute("decodedMessage"); %>
	
	<div class="container">

      <p><%= decoded %></p>

    </div>
</html>


