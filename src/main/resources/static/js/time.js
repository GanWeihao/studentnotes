function getLocalTime(nS) { 
	//将时间戳（十三位时间搓，也就是带毫秒的时间搓）转换成时间格式
	// d.cTime = 1539083829787
	var date = new Date(nS);
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	month = month < 10 ? "0"+month:month;
	day = day < 10 ? "0"+day:day;
	date = year+'-'+month+'-'+day;

	return date;
} 
