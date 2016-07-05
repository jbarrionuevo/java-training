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
			}
		});
});