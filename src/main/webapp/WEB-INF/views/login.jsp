<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>

<link rel="stylesheet" href="resources/style/bootstrap.min.css" />
<link rel="stylesheet" href="resources/style/signin.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function login() {
		$.ajax({
			url : "login.json",
			contentType : "application/json",//application/xml  
			processData : true,//contentType为xml时，些值为false  
			data : {
				yhdm : $("#yhdm").val(),
				fydm : $("#fydm").val(),
				yhkl : $("#yhkl").val()
			},
			dataType : "json",//json--返回json数据类型；xml--返回xml  
			success : function(msg) {
				window.location.href = 'toHome.do';
			},
			error : function(jqXHR, textStatus, errorThrown) {
			},
		});
	}
</script>
</head>
<body>
	<div class="form-signin">
		<h2 class="form-signin-heading" style="text-align: center">XXXX系统</h2>
		<input id="yhdm" type="text" class="form-control" name="username">
		<input id="yhkl" type="password" class="form-control" name="password">
		<label class="checkbox"> </label>
		<button class="btn btn-lg btn-primary btn-block" onclick="login();">登录</button>
	</div>
</body>
</html>