$(document).ready(function(){  
	
	$(document).on("click",".confirmSale",function(){
		var saleId = this.id;
		 if (confirm('Sure to confirm the sale?')) {
			 updateSale("paid");
		 }
	});
	
	$(document).on("click",".cancelSale",function(){
		var saleId = this.id;
		 if (confirm('Sure to cancel the sale?')) {
			 updateSale("cancelled");
		 }
	});
});

function updateSale(status){
	$.ajax({
		   url: '/sales/'+saleId+"?status="+status,
//		   headers: { 
//		        'Accept': 'application/json',
//		        'Content-Type': 'application/json' 
//		   },
		   data: {
			 saleId = saleId
		   },
		   error: function() {
		      $('#result').html('<p>An error has occurred</p>');
		   },
		   success: function(data) {
			   updateView(data);
		   },
		   type: 'PUT'
	});
}

function updateView(data){
	
}