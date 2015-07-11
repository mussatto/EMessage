<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curupira.entity.EMessage" %>
<!DOCTYPE html>
<html>
	<jsp:include page="includes/head.jsp"></jsp:include>
	<body>
	<jsp:include page="includes/menu.jsp"></jsp:include>
	
	<script type="text/javascript">
		function submitDecodeMessage(){
			var id = $("#id").val();
			var pass = $("#pass").val();
			
			$.ajax({
				  url: "/decodeMessage",
				  data: {
				    id: id,
				    pass: pass
				  },
				  success: function( data ) {
					var parsed = JSON.parse(data);
				    $( "#response" ).html( "<h1>"+parsed.title+"</h1><p> Message:" + parsed.response + "</p>" );
				  }
				});
		}
	</script>
	
	<div class="content">

      <div>
        <form action="/decodeMessage">
        	<div>
        		<div>
		        	<label for="id">Message Id</label>
		        	<input name="id" id="id"/>
	        	</div>
	        	<div>
		        	<label for="pass">Message Pass</label>
		        	<input name="pass" id="pass"/>
	        	</div>
        	</div>
        	<input type="button" value="decode" onclick="submitDecodeMessage();"/>
        </form>
      </div>
      
      <div id="response">
      </div>

    </div>
    </body>
</html>


