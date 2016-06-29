$(document).ready(function(){  
	$(document).on("click",".buyCase",function(){
		var wrapperId= this.id;
		var quantity = $("#"+wrapperId+"_quantity").val();
		$.ajax({
			   url: '/inventoryrest/buy/'+wrapperId+'/'+quantity,
			   data: {
			      format: 'json'
			   },
			   error: function() {
			      $('#result').html('<p>An error has occurred</p>');
			   },
			   success: function(data) {
				  alert(data);
			   },
			   type: 'GET'
		 });
	});
});