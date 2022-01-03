<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 목록</h1> <br>
	
	<!-- 필터바 -->
	<a href="list.do?col=PRICE&order=DESC">높은 가격순</a> |
	<a href="list.do?cols=PRICE&order=ASC">낮은 가격순</a> |
	<a href="list.do?cols=PRODUCT_NAME&order=ASC">상품명순</a> |
	<a href="list.do?cols=ENROLL_DATE&order=DESC">최신 등록순</a>
	
	<!--  ORDER BY ${cols} ${order} -->
	
	<table border="1">
		<thead>
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>판매가</th>
				<th>분류</th>
				<th>등록일</th>
				<th>관리메뉴</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${ empty list }">
					<tr>
						<td colspan="6">현재 등록된 상품이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="product" items="${ list }">
						<tr>
							<td>${ product.productNo }</td>
							<td>${ product.productName }</td>
							<td>${ product.price }</td>
							<td>${ product.type }</td>
							<td>${ product.enrollDate }</td>
							<td>
								<%--
									* 기존방식 : Request parameter 방식 (요청 파라미터 방식)
									=> 쿼리스트링을 이용해서 키-밸류 세트로 넘기는 기존 방식 (정석)
									주소창 : /product/detail.do?pno=x
									<a href="detail.do?pno=${ product.productNo }">상세</a> | 수정 | <a>삭제</a>
								 --%>
								 <%--
								 	* Path variable 방식 (주소 변수 방식)
								 	=> 파라미터(밸류)를 URL 경로에 포함시키는 방식 (예. 티스토리 블로그 주소체계)
								 	주소창 : /product/detail/x
								  --%>
								 <a href="detail/${ product.productNo }">상세</a> | 
								 수정 |
								 <a href="detail/${ product.productNo }">삭제</a>
							 </td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>