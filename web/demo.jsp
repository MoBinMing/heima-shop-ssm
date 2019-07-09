<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="i" items="${list}">
		<c:if test="${i%2==1}">
			<p style="color: red">${i}</p>
		</c:if>
		<c:if test="${i%2==0}">
			<p style="color: green">${i}</p>
		</c:if>
	</c:forEach>
</body>
</html>