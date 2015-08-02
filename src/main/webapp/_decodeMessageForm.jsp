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

<div>
  <form role="form" action="/contentDecodeMessage">
  	<div>
  		<div class="form-group">
    	<label for="pass2">Message Pass</label>
    	<input name="pass2" id="pass2" class="form-control"/>
   	</div>
   	<div class="form-group">
    	<label for="encodedcontent">Encoded Content</label>
    	<input name="encodedcontent" id="encodedcontent" class="form-control"/>
   	</div>
  	</div>
  	<input type="button" value="decode" class="btn btn-default"  onclick="submitDecodeContentMessage();"/>
  </form>
</div>



<div id="responseDecode" class="response">
</div>

<script src="/js/decodeMessage.js"></script>