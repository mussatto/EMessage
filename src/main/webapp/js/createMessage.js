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
		    		+"<p>id: "+ parsed.id + "</p>"
		    		+"<p>pass: " parsed.pass+"</p>"
		    		+"<p>encoded: "+parsed.encodedMessage +"<p>"
		    		+"</div>" );
		  }
		});
}