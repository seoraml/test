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

	<!-- 일회성 메세지 띄우기 -->
	<c:if test="${ !empty alertMsg }">
		<script>
			var msg = "${ alertMsg }";
			alert(msg);
		</script>
		<c:remove var="alertMsg" scope="session" />
	</c:if>

	<h1>게시글 등록</h1>
	
	<form action="write.do" method="post">
		카테고리 : 
		<select name="boardHead">
			<option>정보</option>
			<option>공지</option>
			<option>유머</option>
		</select> &nbsp;&nbsp;
		제목 : <input type="text" name="boardTitle"> <br><br>
		<textarea name="boardContent" cols="70" rows="10" style="resize:none;"></textarea>
		<br><br>
		<button type="submit">작성하기</button>
	</form>

</body>
</html>











