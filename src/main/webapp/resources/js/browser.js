$(function(){
	if(/msie/.test(navigator.userAgent.toLowerCase())){
		var version=navigator.appVersion;
		var arr1=version.substring(version.indexOf("(")).split(";");
		var v=0;
		for(var i=0;i<arr1.length;i++){
			var str=arr1[i].toLowerCase();
			var index=str.indexOf("msie");
			if(index>=0){
				v=Number(str.substring(index+4));
				break;
			}
		}
		if(v<8.0)
			window.location.href="browser.jsp";
	}
});