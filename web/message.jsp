<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<base href="<c:url value='/' />">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册成功</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
</head>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div style="text-align: center">
		<c:choose>
			<c:when test="${userMsg.msgCode==1001}">
				<h1 style="color: green">恭喜${userMsg.username},注册成功！我们将会发送一份邮件到${userMsg.email},请注意查收！</h1>
			</c:when>
			<c:when test="${userMsg.msgCode==1002}">
				<h1 style="color: green">您注册的账号：${userMsg.username}已经存在！</h1>
			</c:when>
			<c:when test="${userMsg.msgCode==1003}">
				<h1 style="color: green">系统异常，请联系客服！</h1>
			</c:when>

			<c:when test="${userMsg.msgCode==2001}">
				<h1 style="color: green">恭喜${userMsg.username},激活成功！</h1>
			</c:when>
			<c:when test="${userMsg.msgCode==2002}">
				<h1 style="color: green">${userMsg.username}已经激活！</h1>
			</c:when>
			<c:when test="${userMsg.msgCode==2003}">
				<h1 style="color: green">所激活的用户不存在！</h1>
			</c:when>


			<c:when test="${userMsg.msgCode==3001}">
				<h1 style="color: green">登陆成功！</h1>
			</c:when>
			<c:when test="${userMsg.msgCode==3002}">
				<h1 style="color: green">用户未激活！</h1>
			</c:when>
			<c:when test="${userMsg.msgCode==3003}">
				<h1 style="color: green">用户不存在</h1>
			</c:when>
			<c:when test="${userMsg.msgCode==3004}">
				<h1 style="color: green"> 用户名或者密码错误</h1>
			</c:when>
			
			<c:otherwise>
				<h1 style="color: green"> ${message}</h1>
			</c:otherwise>
		</c:choose>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>




