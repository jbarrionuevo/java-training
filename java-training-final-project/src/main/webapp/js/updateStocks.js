$(document).ready(function(){  
	
	$(document).on("click",".confirmNewStock",function(){
		var caseWrapperId = this.id;
		var newStock = $("#"+caseWrapperId+"_newMinimumStock").val();
		if ((newStock.length === 0) || (newStock<0)){
			alert("Must enter a minimum stock!");
			return false;
		}
		if (confirm('Sure to update de stock?')) {
			$.ajax({
				   url: '/inventory/caseWrappers/'+caseWrapperId+'/minimumStock',
				   data: {
					   newStock:newStock
				   },
				   error: function() {
				      alert("An error has ocurred");
				   },
				   success: function(receipt) {
					   $.ajax({
						   url: '/inventory/wrappers',
						   data: {},
						   error: function() {
						      alert("An error has ocurred");
						   },
						   success: function(data) {
							   $("#result").html(updateTable(data));
						   },
						   type: 'GET'
					   });
				   },
				   type: 'PUT'
			});
		}
	});
	
});

function updateTable(data){
	var result="";
	result+="<table border='1'>" +
			"	<tr>" +
			"		<th>INDEX</th>" +
			"		<th>DESIGN</th>" +
			"		<th>DEVICE</th>" +
			"		<th>PRICE</th>" +
			"		<th>PROVIDER</th>" +
			"		<th>CURRENT STOCK</th>" +
			"		<th>MINIMUM STOCK</th>" +
			"		<th>NEW MINIMUM STOCK</th>" +
			"	</tr>		";
	$.each(data, function(i,v) {
		result+="<tr>";
		result+="<td>"+(i+1)+"</td>";
		result+="<td>"+v.myCase.design.name+"</td>";
		result+="<td>"+v.myCase.device.name+"</td>";
		result+="<td>$"+v.myCase.price+"</td>";
		result+="<td>Name: "+v.myCase.provider.name+". Location: "+v.myCase.provider.location+"</td>";
		result+="<td>"+v.currentStock+"</td>";
		result+="<td>"+v.minimumStock+"</td>";
		result+="<td><label>Enter new minimum: </label>" +
				"<input type='number' id='"+v.id+"_newMinimumStock'/>" +
				"<button type='button' class='confirmNewStock' id="+v.id+">CONFIRM</button>" +
				"</td>" +
				"</tr>";
	});
	result+="</table>";
	return result;
}