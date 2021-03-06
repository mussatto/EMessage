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
		    $( "#responseDecode" ).html( "<div class='alert alert-success'>" +
		    		"<p>title: "+parsed.title+"</p>" +
		    		"<p>content:" + parsed.response + "</p>" +
					"</div>" );
		  }
		});
}

function submitDecodeContentMessage(){
	var pass = $("#pass2").val();
	var encodedcontent = $("#encodedcontent").val();
	$.ajax({
		  url: "/contentDecodeMessage",
		  data: {
			pass: pass,
			encodedcontent: encodedcontent
		  },
		  success: function( data ) {
			var parsed = JSON.parse(data);
		    $( "#responseDecode" ).html( "<div class='alert alert-success'>" +
		    		"<p>content: " + parsed.response + "</p>" 
		    		+ "</div>" );
		  }
		});
}