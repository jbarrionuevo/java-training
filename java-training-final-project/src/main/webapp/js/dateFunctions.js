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

function getDateString(date){
	var dd = date.getDate(); 
	if(dd<10) dd = "0"+dd;
	var mm = date.getMonth()+1; 
	if(mm<10) mm = "0"+mm;
	var yyyy = date.getFullYear(); 
	return (yyyy+"-"+mm+"-"+dd);
}

function getDatePlusOneString(date){
	var dd = date.getDate()+1; 
	if(dd<10) dd = "0"+dd;
	var mm = date.getMonth()+1; 
	if(mm<10) mm = "0"+mm;
	var yyyy = date.getFullYear(); 
	return (yyyy+"-"+mm+"-"+dd);
}

function getCurrentDate(){
	var today = new Date();
	var dd = today.getDate()+1; 
	if(dd<10) dd = "0"+dd;
	var mm = today.getMonth()+1; 
	if(mm<10) mm = "0"+mm;
	var yyyy = today.getFullYear(); 
	return (yyyy+"-"+mm+"-"+dd);
}