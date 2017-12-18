<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>后台登录</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style>
body {
	height: 100%;
	background:0066ff;
	overflow: hidden;
}

canvas {
	z-index: -1;
	position: absolute;
}
</style>
<script src="js/jquery.js"></script>
<script src="js/verificationNumbers.js"></script>
<script src="js/Particleground.js"></script>

</head>
<body>
	<dl class="admin_login">
		<dt>
			<strong>站点后台管理系统</strong>
		</dt>
		<form action="login" method="post">
			<dd class="user_icon">
				<input type="text" name="account" placeholder="账号"
					class="login_txtbx" />
			</dd>
			<dd class="pwd_icon">
				<input type="password" name="password" placeholder="密码"
					class="login_txtbx" />
			</dd>
			
			<dd>
				<input type="submit" value="立即登录" class="submit_btn" />
			</dd>
		</form>
		
	</dl>
</body>
</html>
