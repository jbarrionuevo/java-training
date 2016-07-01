$(document).ready(function(){  
	
	$("#customerData").hide();
	
	var products = new Object(); //to show them in the view
	var requestCases = new Object(); //object to be sent to the controller
	var index = 0;
	
	$(document).on("click",".buyCase",function(){
		var wrapperId= this.id;
		var quantity = $("#"+wrapperId+"_quantity").val();
		var data = $("#"+wrapperId+"_data").val();
		var design = data.split("_")[0];
		var device = data.split("_")[1];
		var price = data.split("_")[2];
		$("#productQuantity").val(parseInt($("#productQuantity").val)+parseInt(quantity));
		
		var product = new Object();
		product["wrapper_id"]=wrapperId;
		product["quantity"]=quantity;
		product["design"]=design;
		product["device"]=device;
		product["price"]=price;
		
		requestCases["wrapper_id"]=quantity;
		
		products[wrapperId] = product;
		index++;
		$("#currentSale").html("");
		var partialPrice=0;
		$.each(products, function(i,v) {
			$("#currentSale").append("<p>"+v["quantity"]+" items of "+v["design"]+", "+v["device"]+" ($"+(v["quantity"]*v["price"])+")</p>" );
			partialPrice+=(v["quantity"]*v["price"]);
		});
		$("#currentSale").append("<p>Partial price: $"+partialPrice);
	});
	
	$(document).on("click","#resetSale",function(){
		products = new Object();
		$("#currentSale").html("No product added");
		$("#productQuantity").val("0");
		$("#customerData").hide();
		$("#name").val("");
		$("#age").val("");
		$("#location").val("");
	});
	
	$(document).on("click","#confirmSale",function(){
		if($("#productQuantity").val()==0) alert("You must add at least 1 item!");
		else{
			if($('#customerData').is(':visible')) {
				if($("#name").val().length === 0){
					alert("Enter customer name!");
					return false;
				}
				if($("#age").val().length === 0){
					alert("Enter customer age!");
					return false;
				}
				if($("#location").val().length === 0){
					alert("Enter customer location!");
					return false;
				}
				var casesJson="{";
				var first=true;
				var totalPrice=0;
				$.each(products, function(i,v) {
					if(!(first)) casesJson += ",";
					else first=false;
					casesJson += '"'+v["wrapper_id"]+'":"'+v["quantity"]+'"';
					totalPrice+=(v["quantity"]*v["price"]);
				});
				casesJson+="}";
				var saleDTO = {
						"caseOrder":{
						    "requestCases":JSON.parse(casesJson),
						    "dateOfRequest":getCurrentDate()
						},
						"totalPrice":totalPrice,
						"receipts":[
						    {
						        "storeName":"store",
						        "dateOfSale":null,
						        "customer":{
						            "name":$("#name").val(),
						            "location":$("#location").val(),
						            "age":$("#age").val(),
						            "gender":$("#gender").val()
						        }
						    		}
						 ]
				};
				var sellerId = 1;  //actually should get it from seller
				$.ajax({
					   url: '/caseSellers/'+sellerId+'/addSale',
					   headers: { 
					        'Accept': 'application/json',
					        'Content-Type': 'application/json' 
					    },
					   data: JSON.stringify(saleDTO),
					   error: function() {
					      $('#result').html('<p>An error has occurred</p>');
					   },
					   success: function(data) {
						  alert("Draft Sale registered succesfully with id "+data+". You can confirm the sale in sales menu.");
						  $("#resetSale").click();
					   },
					   type: 'PUT'
				});
		}else{
				$("#customerData").show();
				$("#customerData").css("visibility","visible");
		}
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