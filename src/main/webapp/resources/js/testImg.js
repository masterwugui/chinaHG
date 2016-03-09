$(function(){
	$("#showBtn").on("click",function(){
		$(".img_wrapper").html("").append('<img id="myImg" />');
		$("#myImg").prop("src","D://test//1.png");
	});
	$("#rotateBtn").on("click",function(){
		var img=$('#myImg');
		var angle=img.getRotateAngle()[0]==null?45 :(img.getRotateAngle()[0]+45);
		img.rotate(angle);
	});
	$("#bigBtn").on("click",function(){
		var img=$('#myImg');
		var img_height=img.height();
		var img_width=img.width();
		img_width=img_width * 1.5;
		img_height=img_height * 1.5;
		img.css("width",img_width+"px");
		img.css("height",img_height+"px");
	});
	$("#smallBtn").on("click",function(){
		var img=$('#myImg');
		var img_height=img.height();
		var img_width=img.width();
		img_width=img_width/1.5;
		img_height=img_height/1.5;
		img.css("width",img_width+"px");
		img.css("height",img_height+"px");
	});
});