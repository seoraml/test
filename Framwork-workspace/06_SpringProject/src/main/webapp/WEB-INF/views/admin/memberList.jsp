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
	<h1>관리자 페이지</h1>
	<h3>회원 목록</h3>
	
	<br>
	
	<table border="1">
		<tr>
			<th>회원 아이디</th>
			<th>닉네임</th>
			<th>회원 등급</th>
			<th>회원 가입일</th>
		</tr>
		<c:choose>
			<c:when test="${ empty list }">
				<tr>
					<td colspan="4">조회된 회원이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="m" items="${ list }">
					<tr>
						<td>${ m.memberId }</td>
						<td>${ m.memberNick }</td>
						<td>${ m.memberAuth }</td>
						<td>${ m.enrollDate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>











