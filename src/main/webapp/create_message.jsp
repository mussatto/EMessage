<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curupira.EMessage" %>
<!DOCTYPE html>
<html>
	<jsp:include page="includes/head.jsp"></jsp:include>
	<body>
	<jsp:include page="includes/menu.jsp"></jsp:include>
	
	
	<div class="container">

      <div>
        <form action="/createMessage">
        	<div>
	        	<label for="title">Title</label>
	        	<input name="title" id="title"/>
        	</div>
        	<div>
        		<label for="content">Content</label>
        		<input name="content" id="content"/>
        	</div>
        	<input type="submit" value="create"/>
        </form>
      </div>

    </div>
</html>


