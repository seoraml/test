<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 상세</h1>
	
	<br>
	
	<h3>상품 번호 : ${ product.productNo }</h3>
	<h3>상품명 : ${ product.productName }</h3>
	<h3>가격 : ${ product.price }원</h3>
	<h3>분류 : ${ product.type }</h3>
	<h3>등록일 : ${ product.enrollDate}</h3>
</body>
</html>