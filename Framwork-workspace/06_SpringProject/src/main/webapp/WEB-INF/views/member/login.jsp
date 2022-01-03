<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	
	<!-- action 의 상대경로는 항상 현재 나의 주소창의 위치를 보고 정해야 한다. -->
	<form action="member/login.do" method="post">
		아이디 : <input type="text" name="memberId"> <br><br>
		비밀번호 : <input type="password" name="memberPwd"> <br><br>
		<button type="submit">로그인</button>
	</form>
</body>
</html>



















