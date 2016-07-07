$(document).ready(function(){  
	
	var sellerId=1; //load it from logged user!!
	$("#receiptDetails").hide();
	
	var isAdmin=false;
	var isStoreSeller=false;
	var isDeliverySeller=false;
	if($("#isAdmin").val()!=undefined) isAdmin=true;
	if($("#isStoreSeller").val()!=undefined) isStoreSeller=true;
	if($("#isDeliverySeller").val()!=undefined){
		isDeliverySeller=true;
		sellerId=2;
	}
	
	$(document).on("click",".confirmSale",function(){
		var saleId = this.id;
		 if (confirm('Sure to confirm the sale?')) {
			 updateSale("paid",saleId);
		 }
	});
	
	$(document).on("click",".cancelSale",function(){
		var saleId = this.id;
		 if (confirm('Sure to cancel the sale?')) {
			 updateSale("cancelled",saleId);
		 }
	});
	
	$(document).on("click",".refundSale",function(){
		var saleId = this.id.split("_")[0];
		var saleDate = this.id.split("_")[1];
		var saleDelay = delay(new Date(saleDate),null);
		if( saleDelay > 30){
			alert("WARRANTY PERIOD EXPIRED FOR THIS SALE!");
			return false;
		}
		if (confirm('Sure to refund the sale?')) {
			var refundType = $("#"+saleId+"_refundType").val();
			switch (refundType) {
			    case "justrefund":
			    	updateSale("refund",saleId);
			        break;
			    case "samemodel":
			    	//do something
			    	updateSale("refundSame",saleId);
			        break;
			}
		}
	});
	
	
	$(document).on("click",".saleReceipt",function(){
		var saleId = this.id;
		$.ajax({
			   url: '/sales/'+saleId+'/receipt',
			   data: {
				 saleId : saleId
			   },
			   error: function() {
			      $('#result').html('<p>An error has occurred</p>');
			   },
			   success: function(receipt) {
				   $("#receiptDetails").show();
				   $("#receiptDetails").css("visibility","visible");
				   var result="<h3>Sale "+saleId+": Receipt details</h3>";
				   result+="<p>Store name: "+receipt.storeName+"</p>";
				   result+="<p>Date of sale: "+getDateString(new Date(receipt.dateOfSale))+"</p>";
				   result+="<p>Customer: Name: "+receipt.customer.name+", Location: "+receipt.customer.location+", Age: "+receipt.customer.age+", Gender: "+receipt.customer.gender+"</p>";
				   $("#receiptDetails").html(result);
			   },
			   type: 'GET'
		});
	});
	
	
	$("#statusSelect").change(function(){
		updateSales(false);
	});
	
	$("#pageSelect").change(function(){
		updateSales(false);
	});
	
	$("#sizeSelect").change(function(){
		updateSales(true);
	});
	
	function updateSales(resetPage){
		$("#receiptDetails").hide();
		var status = $("#statusSelect").val();
		var currentPage = parseInt($("#pageSelect").val());
		var page = currentPage-1;
		var size = parseInt($("#sizeSelect").val());
		if(resetPage){
			page=0;
			currentPage=1;
		}
		$.ajax({
		   url: '/sales/seller/'+sellerId+'/count?status='+status,
		   data: {
		      format: 'json'
		   },
		   error: function() {
		      $('#result').html('<p>An error has occurred</p>');
		   },
		   success: function(data) {
			   updatePagination(data,size,currentPage);
			   $.ajax({
				   url: '/sales/seller/'+sellerId+'?status='+status+"&page="+page+"&size="+size,
				   data: {
				      format: 'json'
				   },
				   error: function() {
				      $('#result').html('<p>An error has occurred</p>');
				   },
				   success: function(data) {
					  $("#result").html(updateTable(data));
				   },
				   type: 'GET'
			   });
		   },
		   type: 'GET'
		});
	}
	
	function updatePagination(data,size,page){
		$('#pageSelect').html("");
		if(data==0)
			$('#pageSelect').append($("<option></option>")
	                    .attr("value",1).text(1)); 
		else{
			for (var i = 1; i<= data; i++) {
				if(page==i)
					$('#pageSelect').append($("<option selected></option>")
		                    .attr("value",i).text(i)); 

				else
					$('#pageSelect').append($("<option></option>")
		                    .attr("value",i).text(i)); 
				data = data -size;
			}
		}
	}
	
	function updateSale(status,saleId){
		$.ajax({
			   url: '/sales/'+saleId+"?status="+status,
//			   headers: { 
//			        'Accept': 'application/json',
//			        'Content-Type': 'application/json' 
//			   },
			   data: {
				 saleId : saleId
			   },
			   error: function() {
			      alert("Error. The required products may not have available stock for now");
			   },
			   success: function(data) {
				   $.ajax({
					   url: '/sales/seller/'+sellerId,
					   error: function() {},
					   success: function(data) {
						   $('#result').html(updateTable(data));
						   if(status=="refund") alert("Sell cases were returned to the inventory!");
					   },
					   type: 'GET'
				   }); 
			   },
			   type: 'PUT'
		});
	}

	function updateTable(data){
		var result="";
		result += "<table border='1'>" +
			"								<tr>" +
			"									<th>INDEX</th>" +
			"									<th>SALE ID</th>" +
			"									<th>CUSTOMER</th>"+
			"									<th>STATUS</th>"+
			"									<th>DATE OF REQUEST</th>"+
			"									<th>TOTAL PRICE</th>";
		if(isStoreSeller||isDeliverySeller) {
			result +="									<th>ACTION 1</th>"+
			"									<th>ACTION 2</th>";
		}
		result +="</tr>";
		
		$.each(data, function(i,s) {
			  result+="<tr>";
			  result+="<td>"+(i+1)+"</td>";
			  result+="<td>"+s.id+"</td>";
			  var customer = s.receipts[0].customer;
			  result+="<td>Name: "+customer.name+", Location: "+customer.location+", Age: "+customer.age+", Gender: "+customer.gender+"</td>";
			  result+="<td>"+s.status+"</td>";
			  result+="<td>"+getDateString(new Date(s.caseOrder.dateOfRequest))+"</td>";
			  result+="<td>$"+s.totalPrice+"</td>";
			  if(isStoreSeller||isDeliverySeller) {
				  if(s.status.toLowerCase()=='paid'){
					  var saleDelay = delay(new Date(s.caseOrder.dateOfRequest),null);
					  if(saleDelay>30)
						  result+="<td>WARRANTY EXPIRED</td>";
					  else {
						  result+="<td>";
						  result+="<select id='"+s.id+"_refundType'>" +
						  		"<option value='justrefund'>Just Refund</option>" +
						  		"<option value='samemodel'>Choose same model</option>" +
						  		"</select><button type='button' class='refundSale' id='"+s.id+"_"+s.caseOrder.dateOfRequest+"'>REFUND</button></td>";
					  }
					  result+="<td><button type='button' class='saleReceipt' id="+s.id+">SEE RECEIPT</button></td>";
				  }
				  else if(s.status.toLowerCase()=='draft'){
					  result+="<td><button type='button' class='confirmSale' id="+s.id+">CONFIRM</button></td>";
					  result+="<td><button type='button' class='cancelSale' id="+s.id+">CANCEL</button></td>";
				  }
				  else if (s.status.toLowerCase()=='cancelled'){
					  result+="<td></td><td></td>";
				  }
				  else{
					  result+="<td><button type='button' class='saleReceipt' id="+s.id+">SEE RECEIPT</button></td><td></td>";
				  }
			  }
			  result+="</tr>";
		  });
		  result+="</table>";
		  return result;
	}
});

function getDateString(date){
	var dd = date.getDate()+1; 
	if(dd<10) dd = "0"+dd;
	var mm = date.getMonth()+1; 
	if(mm<10) mm = "0"+mm;
	var yyyy = date.getFullYear(); 
	return (yyyy+"-"+mm+"-"+dd);
}

function delay(dateOfRequest,dateOfDelivery){
	if(dateOfDelivery==null) dateOfDelivery = new Date();
	else {
		dateOfDelivery= new Date(dateOfDelivery);
		if(getDateString(dateOfRequest)==getDateString(dateOfDelivery)) return 0;
	}
	var timeDiff = Math.abs((new Date(dateOfDelivery)).getTime() - (dateOfRequest.getTime()));
	var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)); 
	return diffDays;
}
