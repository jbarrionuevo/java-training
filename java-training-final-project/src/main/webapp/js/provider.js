$(document).ready(function(){ 
	$(document).on("click",".deliver",function(){
		if (confirm('Confirm the delivery?')) {
			var orderId = this.id;
			$.ajax({
				   type: 'PUT',
				   url: '/inventory/supply/'+orderId,
				   data: {},
				   error: function (request, status, error) {
				        alert("Error in the request; Order may have already been delivered. Refresh your page!");
				   },
				   success: function(data) {
					  alert("Order successfully processed! Refresh the page")
				   }
			});
		}
	});
});