<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세보기</h1>
	
	<br>
	
	<h3>카테고리 : ${ board.boardHead }</h3>
	<h3>제목 : ${ board.boardTitle }</h3>
	<h3>작성자 : ${ board.boardWriter }</h3>
	<h3>내용 : ${ board.boardContent }</h3>
	<h3>조회수 : ${ board.boardRead }</h3>
	
	<br>
	
	<a href="${ pageContext.request.contextPath }/board/union.do">목록가기</a>
	
</body>
</html>









