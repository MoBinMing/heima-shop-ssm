<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
</head>
<body>
	
	<script type="text/javascript">
	$(function(){
		$.post("demo/html",function(data,status){
			console.log(data);
			console.log(status);
			var arr = eval(data);
			console.log(arr);
			var phtml = "";
			for(var i=0;i<arr.length;i++) {
				if(arr[i]%2==0) {
					phtml += '<p style="color:red">'+arr[i] +"</p>"
				} else {
					phtml += '<p style="color:green">'+arr[i] +"</p>"
				}
			}
			console.log(phtml);
			$('body').html(phtml);
		})
	})
</script>
</body>
</html>