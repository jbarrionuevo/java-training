$(document).ready(function(){ 
	
	$(document).on("click",".makeAlertRequest",function(){
		if (confirm('Confirm the order?')) {
			 var productId = this.id.split("_")[0].toString();
			 var quantity = this.id.split("_")[1];
			 var providerId = this.id.split("_")[2];
			 var alertId = this.id.split("_")[3];
			 var casesJson = '{"'+productId+'":"'+quantity+'"}';
			 var jsonOrder = {
						    "requestCases":JSON.parse(casesJson),
						    "dateOfRequest":getCurrentDate()
			 };
			 $.ajax({
				   type: 'POST',
				   url: '/providers/'+providerId+'/orders?orderAlertId='+alertId,
				   headers: { 
				        'Accept': 'application/json',
				        'Content-Type': 'application/json' 
				    },
				   data: JSON.stringify(jsonOrder),
				   error: function (request, status, error) {
				        alert("Error. Order may have already been done. Refresh the page to check it!");
				    },
				   success: function() {
					   alert("Order succesfully registered to the corresponding provider!");
				   }
			 });
		}
	});
	
	$(document).on("click",".makeRequest",function(){
		var providerId = this.id.split("_")[0];
		var quantity = $("#"+providerId+"_quantity").val();
		if ((quantity.length === 0) || (quantity<=0)){
			alert("Must enter a quantity to order!");
			return false;
		}
		 if (confirm('Confirm the order?')) {
			 var design = $("#"+providerId+"_designSelect").val();
			 var device = $("#"+providerId+"_deviceSelect").val();
			 $.ajax({
				  type: 'GET',
				   url: '/products?design='+design+'&device='+device,
				   data: {},
				   error: function() {
					   alert("Error: there's no product with that design and device");
				   },
				   success: function(product) {
					     var casesJson = '{"'+product.id+'":"'+quantity+'"}';
						 var jsonOrder = {
								    "requestCases":JSON.parse(casesJson),
								    "dateOfRequest":getCurrentDate()
						 };
						 $.ajax({
							  type: 'POST',
							   url: '/providers/'+providerId+'/orders',
							   headers: { 
							        'Accept': 'application/json',
							        'Content-Type': 'application/json' 
							    },
							   data: JSON.stringify(jsonOrder),
							   error: function() {
								   alert("Error");
							   },
							   success: function(data) {
								   alert("Order succesfully registered to the corresponding provider!");
							   }
							  
						});
				   }
				  
			});
		 }
	});
});

function getCurrentDate(){
	var today = new Date();
	var dd = today.getDate()+1; 
	if(dd<10) dd = "0"+dd;
	var mm = today.getMonth()+1; 
	if(mm<10) mm = "0"+mm;
	var yyyy = today.getFullYear(); 
	return (yyyy+"-"+mm+"-"+dd);
}

function constructJson(jsonKey, jsonValue){
	   var jsonObj = {"key1": jsonValue};
	   jsonObj[jsonKey] = "2";
	   return jsonObj;
}