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
        
        <div>
        	<p>Create a Message</p>
        	
        	<jsp:include page="_createMessageForm.jsp"></jsp:include>
        </div>
        <div>
        	<p>Decode a Message</p>
        	<jsp:include page="_decodeMessageForm.jsp"></jsp:include>
        </div>
      </div>

    </div>
</html>


