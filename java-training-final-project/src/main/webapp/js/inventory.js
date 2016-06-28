$(document).ready(function(){  
	$("#designSelect").change(function() {
		var design = $("#designSelect").val();
		$.ajax({
			   url: '/inventoryrest/design/'+design,
			   data: {
			      format: 'json'
			   },
			   error: function() {
			      $('#result').html('<p>An error has occurred</p>');
			   },
//			   dataType: 'jsonp',
			   success: function(data) {
				  var result = "<table border='1'>" +
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
				  $("#result").html(result);
			   },
			   type: 'GET'
		});
	});
});