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
		    $( "#response" ).html( "<div class='alert alert-success'>"
		    		+"<h2> Message ID:</h2>"
		    		+"<p>"+ parsed.id + "</p>"
		    		+"<h2>Message Pass:</h2><p>"
		    		+ parsed.pass+"</p>"
		    		+"<h2>Message Encoded</h2>"
		    		+"<p>"+parsed.encodedMessage +"<p>"
		    		+"</div>" );
		  }
		});
}