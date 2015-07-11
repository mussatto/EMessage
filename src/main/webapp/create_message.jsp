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
				    $( "#response" ).html( "<p> Message ID:</p><p>" + parsed.id + "</p> <p>Message Pass:</p><p>"+parsed.pass+"</p>" );
				  }
				});
		}
	</script>
	<div class="content">

      <div>
        <form id="createMessageForm" action="/createMessage">
        	<div>
	        	<label for="title">Title</label>
	        	<input name="title" id="title"/>
        	</div>
        	<div>
        		<label for="content">Content</label>
        		<input name="content" id="content"/>
        	</div>
        	<input type="button" value="create" onclick="submitCreateMessage()"/>
        </form>
      </div>
      
      <div id="response">
      </div>

    </div>
    </body>
</html>


