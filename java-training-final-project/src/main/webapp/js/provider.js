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
	
	$(document).on("change","#typeSelect",function(){
		var delivered = $("#typeSelect").val();
		$.ajax({
			   type: 'GET',
			   url: '/providers/1/orders?delivered='+delivered,
			   data: {},
			   error: function (request, status, error) {
			        alert("Error in the request");
			   },
			   success: function(data) {
				  $("#result").html(updateTable(data,delivered));
			   }
		});
	});
});

function updateTable(data,delivered){
	var result="<table border='1'>" +
			"<tr>" +
			"		<th>INDEX</th>" +
			"		<th>ORDER DETAILS</th>" +
			"		<th>ORDER DATE OF REQUEST</th>" +
			"		<th>ORDER DATE OF DELIVERY</th>" +
			"		<th>DELAY</th>" +
			"		<th>DELIVER</th>" +
			"	</tr>";
	
	$.each(data, function(i,o) {
		  result+="<tr>";
		  result+="<td>"+(i+1)+"</td>";
		  result+="<td>";
		  $.each(o.requestCases, function(i,r) {
			  result+=r+" items of product with id "+i;
		  });
		  result+="</td>";
		  result+="<td>"+getDateString(new Date(o.dateOfRequest))+"</td>";
		  if(o.dateOfDelivery==null) result+="<td>Not yet delivered</td>";
		  else result+="<td>"+getDateString(new Date(o.dateOfDelivery))+"</td>";
		  var deliveryDelay = delay(new Date(o.dateOfRequest),o.dateOfDelivery);
		  var delayDetails = "(On Time)";
		  if(deliveryDelay>3)
			  delayDetails = "("+(deliveryDelay-3)+" days delay)";
		  result+="<td>"+deliveryDelay+" days "+delayDetails+"</td>";
		  if(delivered=="true") result+="<td></td>";
		  else result+="<td><button type='button' class='deliver' id="+o.id+">Deliver!</button></td>";
	});
	result+="</tr></table>";
	return result;
}
