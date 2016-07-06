$(document).ready(function(){  
	
	$(document).on("click",".confirmNewStock",function(){
		if (confirm('Sure to update de stock?')) {
			var caseWrapperId = this.id;
			var newMinimumStock = $("#"+caseWrapperId+"_newMinimumStock");
			$.ajax({
				   url: '/inventory/caseWrappers/'+caseWrapperId,
				   data: {
					   ACA TIENE QUE IR EL WRAPPERDTO
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
	return result;
}