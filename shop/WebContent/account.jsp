<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Account</title>
<!-- 静态引用header -->
<%@ include file="/WEB-INF/jspf/header.jspf"%>
<!--//header-->
<div class="account">
	<div class="container">
		<h1>登录	</h1>
		<div class="account_grid">
			<div class="col-md-6 login-right">
				<form action="login" method="post">

					<span>用户名</span> <input type="text" name="mail" /> <span>密码</span>
					<input type="password" name="password" />
					<div class="word-in">
						<input type="submit" value="登录" />
					</div>
				</form>
			</div>
			<div class="col-md-6 login-left">
				
				<a class="acount-btn" href="register.jsp">注册</a>
			</div>
			<div class="clearfix"></div>
			<span class="label label-warning" id="warning">${loginError}</span>
		</div>
	</div>
</div>

<!-- 静态引用footer -->
<%@ include file="/WEB-INF/jspf/footer.jspf"%>
<!--//footer-->
</body>
</html>