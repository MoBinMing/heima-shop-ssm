<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base href="<c:url value='/'/>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
	width: 100%;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
</head>

<body>


	<!-- 引入header.jsp -->
	<jsp:include page="/header"></jsp:include>


	<div class="row" style="width: 1210px; margin: 0 auto;">
		<c:forEach var="product" items="${products.list}">
			<div class="col-md-2">
				<a href="<c:url value='/product/findByPid?pid=${product.pid}'/>"> <img src="${product.pimage}"
					width="170" height="170" style="display: inline-block;">
				</a>
				<p>
					<a href="<c:url value='/product/findByPid?pid=${product.pid}'/>" style='color: green'>${product.pname}</a>
				</p>
				<p>
					<font color="#FF0000">商城价：&yen;${product.shop_price }</font>
				</p>
			</div>
		</c:forEach>
	</div>

	<!--分页 -->
	<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
		<ul class="pagination" style="text-align: center; margin-top: 10px;">
			<li><a href="<c:url value='/product/findByCid?cid=${param.cid}&pageNum=1'/>" aria-label="Previous"><span
						aria-hidden="true">首页</span></a></li>
			<li><a href="<c:url value='/product/findByCid?cid=${param.cid}&pageNum=${products.pageNum-1<1? products.pageNum:products.pageNum-1}'/>" aria-label="Previous"><span
					aria-hidden="true">&laquo;</span></a></li>

			<c:forEach var="curPage" items="${pageList}">
				<li class="${products.pageNum==curPage? 'active':''}">
					<a href="<c:url value='/product/findByCid?cid=${param.cid}&pageNum=${curPage}'/>">${curPage}</a>
				</li>
				<!-- <li><a href="#">2</a></li> -->
			</c:forEach>
			<li><a href="<c:url value='/product/findByCid?cid=${param.cid}&pageNum=${products.pageNum+1>products.pages? products.pages:products.pageNum+1}'/>" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			<li><a href="<c:url value='/product/findByCid?cid=${param.cid}&pageNum=${products.pages}'/>" aria-label="Next"> <span aria-hidden="true">末页</span>
			</a></li>
		</ul>
	</div>
	<!-- 分页结束 -->

	<!--商品浏览记录-->
	<div
		style="width: 1210px; margin: 0 auto; padding: 0 9px; border: 1px solid #ddd; border-top: 2px solid #999; height: 246px;">

		<h4 style="width: 50%; float: left; font: 14px/30px 微软雅黑">浏览记录</h4>
		<div style="width: 50%; float: right; text-align: right;">
			<a href="">more</a>
		</div>
		<div style="clear: both;"></div>

		<div style="overflow: hidden;">

			<ul style="list-style: none;">
				<li
					style="width: 150px; height: 216; float: left; margin: 0 8px 0 0; padding: 0 18px 15px; text-align: center;"><img
					src="products/1/cs10001.jpg" width="130px" height="130px" /></li>
			</ul>

		</div>
	</div>


	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>