<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메뉴 등록</h1>
	
	<form action="insert.do" method="post">
		이름 : <input type="text" name="name"> <br><br>
		가격 : <input type="text" name="price"> <br><br>
		<button type="submit">등록</button>
	</form>
</body>
</html>