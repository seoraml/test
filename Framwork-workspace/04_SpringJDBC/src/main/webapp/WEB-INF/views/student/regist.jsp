<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 등록</h1>
	
	<form action="regist.do" method="post">
		이름 : <input type="text" name="name"> <br><br>
		나이 : <input type="text" name="age"> <br><br>
		점수 : <input type="text" name="score"> <br><br>
		<button type="submit">등록</button>
	</form>
</body>
</html>