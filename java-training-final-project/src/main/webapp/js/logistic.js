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
					   alert("Order succesfully registered to the corresponding provider!")
				   }
			 });
		}
	});
	
	$(document).on("click",".makeRequest",function(){
		var providerId = this.id.split("_")[0];
		var quantity = $("#"+providerId+"_quantity");
		if ((quantity.val().length === 0) || (quantity.val()<=0)){
			alert("Must enter a quantity to order!");
			return false;
		}
		 if (confirm('Confirm the order?')) {
			 alert("Not implemented!");
//			 var design = $("#"+providerId+"_designSelect").val();
//			 var device = $("#"+providerId+"_deviceSelect").val();
//			 //obtain the product id
//			 var quantity = $("#"+providerId+"_quantity").val();
//			 var caseOrderDTO = {
//					 dateOfRequest: getCurrentDate(),
//					 requestCases : {
//						 productId:quantity
//					 }
//			};
//			 $.ajax({
//				   url: '/providers/'+providerId+'/order',
//				   data: {
//					   caseOrderDTO: caseOrderDTO
//				   },
//				   error: function() {
//				      $('#result').html('<p>An error has occurred</p>');
//				   },
//				   success: function(data) {
//					   
//				   },
//				   type: 'PUT'
//			});
		 }
	});
});

function getCurrentDate(){
	var today = new Date();
	var dd = today.getDate(); 
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