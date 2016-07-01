$(document).ready(function(){  
	
	$(document).on("click",".confirmSale",function(){
		 if (confirm('Sure to confirm the sale?')) {
			 alert("sale confirmed");
		 }
	});
	
	$(document).on("click",".cancelSale",function(){
		 if (confirm('Sure to cancel the sale?')) {
			 alert("sale cancelled");
		 }
	});
});