<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" url="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>메뉴판</h1>
	
	<table border="1">
		<tr>
			<th>메뉴명</th>
			<th>가격</th>
		</tr>
		
		<c:choose>
			<c:when test="${ empty list }">
				<tr>
					<td colspan="2">메뉴가 존재하지 않습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="m" items="${ list }">
					<tr>
						<td>${ name }</td>
						<td>${ price }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
			
		</c:choose>

		<tr>
			<td>모든초밥</td>
			<td>23000</td>
		</tr>
	</table>

</body>
</html>