$(document).ready(function(){  
	
	
	$("#designSelect").change(function() {
		updateCases();
	});
	
	$("#deviceSelect").change(function() {
		updateCases();
	});
	
	function updateCases(){
		var design = $("#designSelect").val();
		var device = $("#deviceSelect").val();
		$.ajax({
			   url: '/inventoryrest/design/'+design+'/device/'+device,
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
	}
	
	function updateTable(data){
		var result="";
		if(data.length==0) return "There are no cases with such parameters"; 
		result = "<table border='1'>" +
  		"								<tr>" +
  		"									<th>INDEX</th>" +
  		"									<th>DESIGN</th>" +
  		"									<th>DEVICE</th>" +
  		"									<th>PROVIDER</th>" +
  		"									<th>CURRENT STOCK</th>" +
  		"									<th>MINIMUM STOCK</th>" +
  		"</tr>";
		  $.each(data, function(i,v) {
			  result+="<tr>";
			  result+="<td>"+(i+1)+"</td>";
			  result+="<td>"+v.myCase.design.name+"</td>";
			  result+="<td>"+v.myCase.device.name+"</td>";
			  result+="<td>Name: "+v.myCase.provider.name+". Location: "+v.myCase.provider.location+"</td>";
			  result+="<td>"+v.currentStock+"</td>";
			  result+="<td>"+v.minimumStock+"</td>";
			  result+="</tr>";
		  });
		  result+="</table>";
		  return result;
	}
});