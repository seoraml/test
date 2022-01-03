<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<hr>

<!-- 
	* 프레임워크
	- 개발자가 보다 편리한 환경에서 개발할 수 있도록 제공하는 뼈대, 틀 이라고 생각
	- 소프트웨어 개발의 입장으로써는 공통적으로 사용되는 라이브러리 / 개발도구 / 인터페이스 등을 의미한다
	
	* 프레임워크를 왜 쓰는가 ? 필요성
	- 현재 웹프로그래밍 프로젝트 규모가 커지는 중
	=> 거대하고, 복잡도가 높은 프러젝트를 완성시키지 위해서는 많은 개발자들이 필요함
	=> 그 개발자들이 "통일성"있게 "빠르고" "안정적"으로 개발하기 위한 걸로 프레임워크가 좋은 성과를 내고 있음
	=> 즉, "생산성" 향상에 큰 도움이 된다.
	 
	 * 프레임워크의 특징
	 - 자유롭게 설계하고 코딩하는게 아니라 프레임워크가 제공하는 가이드대로 설계하고 코딩해야함 (+ 세싱도 마찬가지 **)
	 - 개발할 수 있는 범위 다소 정해져 있기는 함
	 - 개발자를 위한 다양한 도구 / 플러그인 들이 지원됨
	 
	 * 프레임워크의 장단점
	 > 장점 : 개발시간을 줄일 수 있음
	 		오류로부터 자유로워 질 수 있음 
	 > 단점 : 너무 의존하다 보면 개발능력이 떨어져서 프레임워크 없이 개발하는 것이 어려워질 수 있음
	 		습득하기까지 시간이 오래걸릴 수 있음
	 		
	 * 프레이워크의 종류
	 - 영속성 : 데이터의 추가, 조회, 수정, 삭제 CRUD(DB)기능들을 편리하게 작업할 수 있도록 하는 프레임워크
			ex) MyBatis, Hibernate, ..
	 - 자바 : 웹 애플리케이션에 초점을 맞춰 필요한 요소들을 모듈화 해서 제공하는 프레임워크
	 		ex) Spring, 전자정부프레임워크( ==Spring Legacy), Struts
	 - 화면구현 : Front-end를 보다 쉽게 구현할 수 있게 틀을 제공하는 프레임워크
	 			ex) Bootstrap, ...
	 - 기능 및 지원 : 특정 기능이나 업무 수행에 도움을 주는 기능을 제공하는 프레임워크
	 				ex) Log4j, JUnit, ...
 -->
 
 <div>
 	
 	<h1>Framework</h1>
 
 	<h2> * Spring</h2>
 	<P>
 		스프링이란 ? <br>
 		
 		JSP, Servlet 보다 향상된 백엔드 구출 툴 <br>
 		스프링을 이용하면 체계적인 홈페이지 구조를 구축 가능 <br>
 		단, 무수히 많은 규칙을 지켜야 가능하다 (강제적 성향이 짙다) <br>
 		
 		스프링의 종류 : Spring Legacy, Spring Boot, Spring Security, ..
 		
 	</P>
 	
 	<hr>
 	
 	<h3>스프링 프로젝트의 구조</h3>
 	
 	<p>
 		- Spring 프로젝트에서 가장 중심이 되는 파일 : web.xml (배포 서술자) <br>
 		- Spring 프로젝트에서 가장 최상위 설정 파일 : root-context.xml <br>
 		- 모든 요청 처리를 하는 메인 서블릿 : DisoatcherServlet (요청 분배자) <br>
 		 => DisoatcherServlet이 설정 내용물에 따라서 요청에 대한 응답 (view) 을 지정 <br>
 		- DisoatcherServlet의 상세 설정 내용을 담은 파일 : servlet-context.xml
		- Maven을 위한 파일: pom.xml
 	</p>
 	
 	<hr>
 	
 	<h2> * Maven</h2>
 	
 	<p>
 		메이븐이란? <br>
 		
 		자바 프로젝트의 빌드를 자동화 해주는 빌드 툴 (도구) <br>
 		즉, 라이브러리들 (.jsp 파일 등)을 링크만 추가하고 가져다 쓸 수 있게끔 구현해 놓은 것<br>
 		=> pom.xml에 추가할 링크를 작성하면 라이브러리가 자동으로 추가된다 <br>
 		=> 추가된 라이브러리는 Maven Dependencies 에 존재한다.
 	</p>
 	
 </div>
 
</body>
</html>
