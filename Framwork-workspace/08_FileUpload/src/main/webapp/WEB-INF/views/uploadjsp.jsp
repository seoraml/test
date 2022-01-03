<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드 </h1>

	<br>
	<!--  enctype="multipart/form-data"  => 파일 넣을 일이 있다면 반드시 작성 -->
	<form action="upload.do" method="post" enctype="multipart/form-data">
		작성자명 : <input type="text" name="uploader"> <br><br>
		첨부파일 : <input type="file" name="upfile" multiple accept=".jsp, .png, .gif"> <br><br>	
		<!-- 
			input type="file"의 추가 속성
			- multiple : 한 파일탐색기 창으로 여러 개의 파일을 업로드 가능하게 하겠다.
			- accept : 확장자명들 작성 => 작성한 확장자명에 해당하는 파일들만 업로드가 가능해짐.
		 -->
		
		<button type="submit">업로드</button>
	</form>
</body>
</html>