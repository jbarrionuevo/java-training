$(document).ready(function(){ 
		$("#result").hide();
		
		$("#providerSelect").change(function(){
			if($("#providerSelect").val()=="none"){
				$("#help").show();
				$("#help").css("visibility","visible");
				$("#result").hide();
			}else{
				$("#result").show();
				$("#result").css("visibility","visible");
				$("#help").hide();
				var providerId = $("#providerSelect").val().split("_")[0];
				var providerInfo = $("#providerSelect").val().split("_")[1];
				$.ajax({
					   type: 'GET',
					   url: '/providers/'+providerId+'/orders',
					   data: {},
					   error: function (request, status, error) {
					        alert("Error in the request");
					   },
					   success: function(data) {
						  $("#result").html(updateTable(data,providerInfo));
					   }
				});
			}
		});
});

function updateTable(data,providerInfo){
	var result="<h2>Orders from "+providerInfo+"</h3>";
	if(data.length==0) {
		result+= "<h3>There are no orders from this provider</h3>"; 
		return result;
	}
	result += "<table border='1'>" +
		"<tr>" +
		"									<th>INDEX</th>" +
		"									<th>ORDER DATE OF REQUEST</th>"+
		"									<th>ORDER DATE OF DELIVERY</th>"+
		"									<th>DELAY</th>"+
		"</tr>";

	$.each(data, function(i,o) {
		  result+="<tr>";
		  result+="<td>"+(i+1)+"</td>";
		  result+="<td>"+getDateString(new Date(o.dateOfRequest))+"</td>";
		  if(o.dateOfDelivery==null) result+="<td>Not yet delivered</td>";
		  else result+="<td>"+getDateString(new Date(o.dateOfDelivery))+"</td>";
		  var deliveryDelay = delay(new Date(o.dateOfRequest),o.dateOfDelivery);
		  var delayDetails = "(On Time)";
		  if(deliveryDelay>3)
			  delayDetails = "("+(deliveryDelay-3)+" days delay)";
		  result+="<td>"+deliveryDelay+" days "+delayDetails+"</td>";
		  result+="</tr>";
	  });
	  result+="</table>";
	  return result;
}

function getDateString(date){
	var dd = date.getDate(); 
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