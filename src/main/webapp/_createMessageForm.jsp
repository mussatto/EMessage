<div>
   <form role="form" id="createMessageForm" action="/createMessage">
   	<div class="form-group">
    	<label for="title">Title</label>
    	<input name="title" id="title" class="form-control"/>
   	</div>
   	<div class="form-group">
    	<label for="passwordCreate">Password</label>
    	<input name="passwordCreate" id="passwordCreate" class="form-control"/>
   	</div>
   	<div class="form-group">
   		<label for="content">Content</label>
   		<textarea name="content" id="content" class="form-control" ></textarea>
   	</div>
   	<input type="button" value="create" class="btn btn-default" onclick="submitCreateMessage()"/>
   </form>
 </div>
 
<div id="response"  class="response">
</div>
<script src="/js/createMessage.js"></script>