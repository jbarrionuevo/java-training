$(document).ready(function(){  
	
	$("#customerData").hide();
	
	var products = new Object();
	
	$(document).on("click",".buyCase",function(){
		var wrapperId= this.id;
		var quantity = $("#"+wrapperId+"_quantity").val();
		var data = $("#"+wrapperId+"_data").val();
		var design = data.split("_")[0];
		var device = data.split("_")[1];
		$("#productQuantity").val(parseInt($("#productQuantity").val)+parseInt(quantity));
		
		products[wrapperId] = quantity;
		$("#currentSale").html("");
		$.each(products, function(i,v) {
			$("#currentSale").append("<p>"+v+" items of "+i+"</p>" );
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
			$("#customerData").show();
			$("#customerData").css("visibility","visible");
		}
	});
});