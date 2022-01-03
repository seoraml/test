<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	
	<form action="" method="post">
		아이디 : <input type="text" name="memberId"> <br><br>
		비밀번호 : <input type="password" name="memberPwd"> <br><br>
		닉네임 : <input type="text" name="memberNick"> <br><br>
		우편번호 : <input type="text" name="post"> <br><br>
		기본주소 : <input type="text" name="baseAddr"> <br><br>
		상세주소 : <input type="text" name="extraAddr"> <br><br>
		생년월일 : <input type="text" name="birth" placeholder="yyyymmdd 형식"> <br><br>
		전화번호 : <input type="text" name="phone" placeholder="- 포함 최대 13자"> <br><br>
		자기소개 (한글 최대 1333 글자 까지) <br>
		<textarea name="memberIntro" style="resize:none;" cols="70" rows="10"></textarea> <br><br>
		
		<button type="submit">가입하기</button>
	</form>
</body>
</html>







