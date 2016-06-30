$(document).ready(function(){  
	
	$("#customerData").hide();
	
	var products = new Object();
	var index = 0;
	
	$(document).on("click",".buyCase",function(){
		var wrapperId= this.id;
		var quantity = $("#"+wrapperId+"_quantity").val();
		var data = $("#"+wrapperId+"_data").val();
		var design = data.split("_")[0];
		var device = data.split("_")[1];
		$("#productQuantity").val(parseInt($("#productQuantity").val)+parseInt(quantity));
		
		var product = new Object();
		product["wrapper_id"]=wrapperId;
		product["quantity"]=quantity;
		product["design"]=design;
		product["device"]=device;
		
		products[wrapperId] = product;
		index++;
		$("#currentSale").html("");
		$.each(products, function(i,v) {
			$("#currentSale").append(
					"<p>"+v["quantity"]+" items of "+v["design"]+", "+v["device"]+"</p>" );
		});
	});
	
	$(document).on("click","#resetSale",function(){
		products = new Object();
		$("#currentSale").html("No product added");
		$("#productQuantity").val("0");
		$("#customerData").hide();
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
				var saleDTO = {
						"caseOrder":{
						    "requestCases":[
						        {"1":"1000"},
						        {"2":"3000"}
						   ],
						    "dateOfRequest":"2016-10-10"
						},
						"receipts":[
						    {
						        "storeName":"store", //actually should get it from seller
						        "dateOfSale":"2016-10-10", //must be today!!
						        "customer":{  //then check that its not an already existent customer!
						            "name":$("#name").val(),
						            "location":$("#location").val(),
						            "age":parseInt($("#age").val()),
						            "gender":$("#gender").val()
						        }
						    }
						 ]
				};
				var sellerId = 1;  //actually should get it from seller
				$.ajax({
					   url: '/caseSellers/'+sellerId+'/addSale',
					   data: {
						   saleDTO : saleDto
					   },
					   error: function() {
					      $('#result').html('<p>An error has occurred</p>');
					   },
					   success: function(data) {
						  alert(data);
					   },
					   type: 'POST'
				 });
			}
			else{
				$("#customerData").show();
				$("#customerData").css("visibility","visible");
			}
		}
	});
});