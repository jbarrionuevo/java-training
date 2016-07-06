$(document).ready(function(){ 
	$(document).on("click",".deliver",function(){
		var orderId = this.id;
		$.ajax({
			   type: 'PUT',
			   url: '/inventory/supply/'+orderId,
			   data: {},
			   error: function (request, status, error) {
			        alert("Error in the request");
			   },
			   success: function(data) {
				  alert("Order successfully processed! Refresh the page")
			   }
		});
	});
});