$(document).ready(function(){  
	
	var isAdmin=false;
	var isStoreSeller=false;
	if($("#isAdmin").val()!=undefined) isAdmin=true;
	if($("#isStoreSeller").val()!=undefined) isStoreSeller=true;
	
	$("#designSelect").change(function(){
		updateCases(false);
	});
	
	$("#deviceSelect").change(function(){
		updateCases(false);
	});
	
	$("#pageSelect").change(function(){
		updateCases(false);
	});
	
	$("#sizeSelect").change(function(){
		updateCases(true);
	});
	
	function updateCases(resetPage){
		var design = $("#designSelect").val();
		var device = $("#deviceSelect").val();
		var currentPage = parseInt($("#pageSelect").val());
		var page = currentPage-1;
		var size = parseInt($("#sizeSelect").val());
		if(resetPage){
			page=0;
			currentPage=1;
		}
		$.ajax({
		   url: '/inventory/count?design='+design+'&device='+device,
		   data: {
		      format: 'json'
		   },
		   error: function() {
		      $('#result').html('<p>An error has occurred</p>');
		   },
		   success: function(data) {
			   updatePagination(data,size,currentPage);
			   $.ajax({
				   url: '/inventory/?design='+design+'&device='+device+"&page="+page+"&size="+size,
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
	
	function updateTable(data){
		var result="";
		if(data.length==0) return "There are no cases with such parameters"; 
		result = "<table border='1'>" +
  		"								<tr>" +
  		"									<th>INDEX</th>" +
  		"									<th>DESIGN</th>" +
  		"									<th>DEVICE</th>";
		if(isAdmin){
			result += "<th>PROVIDER</th>" +
	  		"<th>CURRENT STOCK</th>" +
	  		"<th>MINIMUM STOCK</th>" +
	  		"<th>DELETE</th>" +
	  		"</tr>";
		}else if(isStoreSeller){
			result += "<th>BUY</th>" +
					"</tr>";
		}
		$.each(data, function(i,v) {
			  result+="<tr>";
			  result+="<td>"+(i+1)+"</td>";
			  result+="<td>"+v.myCase.design.name+"</td>";
			  result+="<td>"+v.myCase.device.name+"</td>";
			  if(isAdmin){
				  result+="<td>Name: "+v.myCase.provider.name+". Location: "+v.myCase.provider.location+"</td>";
				  result+="<td>"+v.currentStock+"</td>";
				  result+="<td>"+v.minimumStock+"</td>";
				  result+="<td><button type='button'>Delete</button></td>";
			  }	 else if(isStoreSeller) 
				  result+="<td>" +
				  		"<label>Quantity:</label>" +
						"<input type='hidden' id='"+v.id+"_data' value='"+v.myCase.design.name+"_"+v.myCase.device.name+"'/>"+
				  		"<select id='"+v.id+"_quantity'>" +
				  		"<option>1</option><option>2</option>" +
				  		"<option>3</option><option>4</option>" +
				  		"<option>5</option>" +
				  		"</select>" +
				  		"<button type='button' class='buyCase' id="+v.id+">Buy!</button>" +
				  				"</td>";
			  result+="</tr>";
		  });
		  result+="</table>";
		  return result;
	}
});