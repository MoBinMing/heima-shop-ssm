<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top: 20px">
		<c:if test="${USER!=null}">
				欢迎【${USER.username}】光临！
		</c:if>
		
		<ol class="list-inline">
			<c:choose>
				<c:when test="${USER!=null}">
					<li><a href="cart.jsp">购物车</a></li>
					<li><a href="order_list.jsp">我的订单</a></li>
					<li><a href="<c:url value='/user/logout'/>">退出</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="login.jsp">登录</a></li>
					<li><a href="register.jsp">注册</a></li>
				</c:otherwise>
			</c:choose>
		</ol>
	</div>
</div>
<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="default.jsp">首页</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<c:forEach var="category" items="${categories}" varStatus="varStatus">
						<c:choose>
							<c:when test="${category.cid==param.cid}">
								<li class="active"><a href="<c:url value='/product/findByCid'/>?cid=${category.cid}">${category.cname}<span
									class="sr-only">(current)</span></a></li>
							</c:when>
							<c:otherwise>
								<li><a href="<c:url value='/product/findByCid'/>?cid=${category.cid}">${category.cname}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</nav>
</div>