<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- taglib 지시어 3종류 : core, fmt, functions 도 menubar.jsp 같은데 넣어두고 항상 include -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> <!-- 온라인 방식 -->
</head>
<body>
	<h1>게시판 목록</h1>
	
	<!-- 일회성 메세지 띄우기 : menubar.jsp 같은데 넣어두고 항상 include -->
	<c:if test="${ !empty alertMsg }">
		<script>
			var msg = "${ alertMsg }";
			alert(msg);
		</script>
		<c:remove var="alertMsg" scope="session" />
	</c:if>
	
	<!-- 로그인한 사용자만 보이게끔 -->
	<c:if test="${ loginUser != null }">
		<a href="write.do">글작성</a>
	</c:if>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<!-- 일단 리스트가 비어있으면 없습니다 찍고 있으면 반복 돌려서 다 찍어냈음 -->
		<c:choose>
			<c:when test="${ empty list }">
				<tr>
					<td colspan="5">조회 결과가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="b" items="${ list }">
					<tr>
						<td>${ b.boardNo }</td>
						<td>${ b.boardTitle }</td>
						<td>${ b.boardWriter }</td>
						<td>${ b.createDate }</td>
						<td>${ b.boardRead }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
	<script>
		$(function() {
			$("table tr").click(function() {
				
				var bno = $(this).children().eq(0).text();
				
				console.log(bno);
				
				location.href="${ pageContext.request.contextPath }/board/content.do?boardNo=" + bno;
				
				// Context Root == Context Path == url 주소의 최상위(메인) 페이지 주소
				// 기존 스크립틀릿 방식 : request.getContextPath()
				// EL 방식 : pageContext.request.contextPath
				// JSTL 방식 : c:url 태그의 value 속성에 값을 지정해서 쓰면 됨 (value="/")
				// => 단, JSTL 같은 경우는 스크립트 태그 안에서 사용 불가
				
			});
		});
	</script>
	
	<br>
	
	<!-- 검색창 -->
	<form action="union.do" method="get">
		<select name="type">
			<option value="BOARD_TITLE">제목</option>
			<option value="BOARD_WRITER">작성자</option>
		</select>
		<input type="text" name="keyword" placeholder="검색어">
		<button type="submit">검색</button>
	</form>
</body>
</html>











