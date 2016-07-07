$(document).ready(function(){  
	
	$("#customerData").hide();
	
	var products = new Object(); //to show them in the view
	var requestCases = new Object(); //object to be sent to the controller
	var index = 0;
	
	var isDeliverySeller=$("#isDeliverySeller").val();
	var allSales = [];
	$("#registeredSales").html("<h3>No sales registered up to the moment</h3>");
	
	$(document).on("click",".buyCase",function(){
		var wrapperId= this.id;
		var quantity = $("#"+wrapperId+"_quantity").val();
		var data = $("#"+wrapperId+"_data").val();
		var design = data.split("_")[0];
		var device = data.split("_")[1];
		var price = data.split("_")[2];
		var prod_id = data.split("_")[3];
		$("#productQuantity").val(parseInt($("#productQuantity").val)+parseInt(quantity));
		
		
		var product = new Object();
		product["wrapper_id"]=wrapperId;
		product["quantity"]=quantity;
		product["design"]=design;
		product["device"]=device;
		product["price"]=price;
		product["prod_id"]=prod_id;
		
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
	
	$(document).on("click","#resetAllSales",function(){
		allSales = [];
		$("#registeredSales").html("<h3>No sales registered up to the moment</h3>");
		$("#resetSale").click();
	});
	
	$(document).on("click","#confirmAllSales",function(){
		if(allSales.length==0){
			alert("Must register 1 sale at least first");
			return false;
		}
		if (confirm('Confirm all the sales?')) {
			var sellerId = 2;  //actually should get it from seller
			$.ajax({
				   url: '/caseSellers/'+sellerId+'/addSales',
				   headers: { 
				        'Accept': 'application/json',
				        'Content-Type': 'application/json' 
				   },
				   data: JSON.stringify(allSales),
				   error: function() {
				      $('#result').html('<p>An error has occurred</p>');
				   },
				   success: function(data) {
					  alert("Sales registered succesfully. You can check the sales in sales menu.");
					  $("#resetAllSales").click();
				   },
				   type: 'PUT'
			});
		}
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
					casesJson += '"'+v["prod_id"]+'":"'+v["quantity"]+'"';
					totalPrice+=(v["quantity"]*v["price"]);
				});
				casesJson+="}";
				var saleDTO = {
						"caseOrder":{
						    "requestCases":JSON.parse(casesJson),
						    "dateOfRequest":getCurrentDate()
						},
						"totalPrice":totalPrice,
						"status":"PAID",
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
				if(isDeliverySeller=="true"){
					saleDTO.status = $("#statusSelect").val();
					allSales.push(saleDTO);
					alert("Sale saved. You've registered "+allSales.length+" sales up to now. Click Confirm All Sales to register them in the database; if not, "+
							"all of them will be lost.");
					$("#resetSale").click();
					var newHtml="";
					$.each(allSales, function(i,s) {
						newHtml+="<p>"+(i+1)+") $"+s.totalPrice+" to customer "+s.receipts[0].customer.name+" ("+s.receipts[0].customer.location+"). Status: "+s.status+"</p>";
					});
					$("#registeredSales").html(newHtml);			
				}
				else{
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
							  alert("Paid Sale registered succesfully. You can check the sale in sales menu.");
							  $("#resetSale").click();
						   },
						   type: 'PUT'
					});
				}
				
		}else{
				$("#customerData").show();
				$("#customerData").css("visibility","visible");
		}
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