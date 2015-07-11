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
				    $( "#response" ).html( "<div class='alert alert-success'><h1>Message decoded:</h1><p>"+parsed.title+"</p><p>" + parsed.response + "</p></div>" );
				  }
				});
		}
	</script>
	
	<div class="content">

      <div>
        <form role="form" action="/decodeMessage">
        	<div>
        		<div class="form-group">
		        	<label for="id">Message Id</label>
		        	<input name="id" id="id" class="form-control"/>
	        	</div>
	        	<div class="form-group">
		        	<label for="pass">Message Pass</label>
		        	<input name="pass" id="pass" class="form-control"/>
	        	</div>
        	</div>
        	<input type="button" value="decode" class="btn btn-default"  onclick="submitDecodeMessage();"/>
        </form>
      </div>
      
      <div id="response" class="response">
      </div>

    </div>
    </body>
</html>


