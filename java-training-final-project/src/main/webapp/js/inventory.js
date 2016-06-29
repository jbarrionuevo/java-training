$(document).ready(function(){  
	
	$("#designSelect").change(function(){
//		alert("designSelect");
//	$(document).on("change",$("#designSelect"),function() {
		updateCases(false);
	});
	
	$("#deviceSelect").change(function(){
//		alert("deviceSelect");
//	$(document).on("change",$("#deviceSelect"),function() {
		updateCases(false);
	});
	
	$("#pageSelect").change(function(){
//	$(document).on("change",$("#pageSelect"),function() {
//		alert("pageSelect");
		updateCases(false);
	});
	
	$("#sizeSelect").change(function(){
//	$(document).on("change",$("#sizeSelect"),function() {
//		alert("sizeSelect");
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
		   url: '/inventoryrest/count?design='+design+'&device='+device,
		   data: {
		      format: 'json'
		   },
		   error: function() {
		      $('#result').html('<p>An error has occurred</p>');
		   },
		   success: function(data) {
			   updatePagination(data,size,currentPage);
			   $.ajax({
				   url: '/inventoryrest/?design='+design+'&device='+device+"&page="+page+"&size="+size,
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
		var result = "<select id='pageSelect'>";
		if(data==0) result += "<option>1</option>";
		else{
			for (var i = 1; i<= data; i++) {
				if(page==i) result += "<option selected>"+i+"</option>";
				else result += "<option>"+i+"</option>";
				data = data -size;
			}
		}
		result += "</select>";
		$("#pagination").html(result);
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