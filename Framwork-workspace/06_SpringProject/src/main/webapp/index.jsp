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
	
	<c:if test="${ !empty alertMsg }"> <!-- 띄울 메세지가 있다면 -->
		<script>
			var msg = "${ alertMsg }"; // "메세지 내용"
			alert(msg);
		</script>
		
		<!-- 일회성 알람이므로 지우기 -->
		<c:remove var="alertMsg" scope="session" />
	</c:if>

	<h1>메인페이지</h1>
	
	<br>
	
	<c:choose>
		<c:when test="${ !empty loginUser }"> <!-- 로그인이 되었다면 -->
			<!-- '닉네임' 님 환영합니다^^ -->
			<!-- 만약 메인페이지 접속 시점에서 로그인 정보가 없다면 닉네임이 안찍히고 말것 -->
			<h3>${ loginUser.memberNick } 님 환영합니다^^</h3>
			<a href="member/logout.do">로그아웃</a>
		</c:when>
		<c:otherwise> <!-- 로그인이 안되었다면  : 로그인 폼 include -->
			<!-- include 방식 : include 지시어 쓰는 방법, jsp:include -->
			<%@ include file="WEB-INF/views/member/login.jsp" %>
		</c:otherwise>
	</c:choose>
	
	<a href="board/union.do">자유게시판 가기</a>
	
</body>
</html>



