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
        <form action="/decodeMessage">
        	<div>
	        	<label for="id">Message Id</label>
	        	<input name="id" id="id"/>
	        	
	        	<label for="pass">Message Pass</label>
	        	<input name="pass" id="pass"/>
        	</div>
        	<input type="submit" value="create"/>
        </form>
      </div>

    </div>
</html>


