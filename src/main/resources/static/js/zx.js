function window_request_paramter(name) {
	var reg=new RegExp("(^|&)"+name+"=([^&]*)(&|$)","i");
	var r = window.location.search.substr(1).match(reg);
	if( r != null)
		return decodeURI(r[2]);
	return null;
};
window.webdz="http://120.79.28.144:8080/adidas"

