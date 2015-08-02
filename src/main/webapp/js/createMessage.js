function submitCreateMessage(){
	var title = $("#title").val();
	var content = $("#content").val();
	var passwordCreate = $("#passwordCreate").val();
	
	$.ajax({
		  url: "/createMessage",
		  data: {
		    title: title,
		    content: content,
		    pass: passwordCreate
		  },
		  success: function( data ) {
			var parsed = JSON.parse(data);
		    $( "#response" ).html( "<div class='alert alert-success'>"
		    		+"<h2>ID:</h2>"
		    		+"<p>"+ parsed.id + "</p>"
		    		+"<h2>Pass:</h2><p>"
		    		+ parsed.pass+"</p>"
		    		+"<h2>Encoded</h2>"
		    		+"<p>"+parsed.encodedMessage +"<p>"
		    		+"</div>" );
		  }
		});
}