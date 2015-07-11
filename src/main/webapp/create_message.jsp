<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curupira.entity.EMessage" %>
<!DOCTYPE html>
<html>
	<jsp:include page="includes/head.jsp"></jsp:include>
	<body>
	<jsp:include page="includes/menu.jsp"></jsp:include>
	
	<script type="text/javascript">
		function submitCreateMessage(){
			var title = $("#title").val();
			var content = $("#content").val();
			
			$.ajax({
				  url: "/createMessage",
				  data: {
				    title: title,
				    content: content
				  },
				  success: function( data ) {
					var parsed = JSON.parse(data);
				    $( "#response" ).html( "<div class='alert alert-success'><h1>Message Created! Info:</h1><h2> Message ID:</h2><p>" + parsed.id + "</p> <h2>Message Pass:</h2><p>"+parsed.pass+"</p></div>" );
				  }
				});
		}
	</script>
	<div class="content">

      <div>
        <form role="form" id="createMessageForm" action="/createMessage">
        	<div class="form-group">
	        	<label for="title">Title</label>
	        	<input name="title" id="title" class="form-control"/>
        	</div>
        	<div class="form-group">
        		<label for="content">Content</label>
        		<textarea name="content" id="content" class="form-control" >
        		</textarea>
        	</div>
        	<input type="button" value="create" class="btn btn-default" onclick="submitCreateMessage()"/>
        </form>
      </div>
      
      <div id="response"  class="response">
      </div>

    </div>
    </body>
</html>


