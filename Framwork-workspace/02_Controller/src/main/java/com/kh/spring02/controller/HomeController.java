package com.kh.spring02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //컨트롤러임을 명시(컨트롤러를 등록한다.)
public class HomeController {

	/*
	 * 컨트롤러 클래스 내부에
	 * 메소드를 만들어서 요청에 대한 처리 내용으 ㄹ작성
	 * => 메소드는 항상 public으로 구현
	 * => 반환 (return) 데이터는 반드시 연결될 주소가 포함 ( == 문자열 형식)
	 * => 메소드명은 내맘대로
	 * => 매개변수는 있어도 되고 없어도 된다.
	 */
	
	//@RequestMapping(value="url맵핑값")
	// 요청에 대한 맵핑 (url연결)을 설정하겠다.
	
	@RequestMapping(value="/home.do")
	public String home() {
		
		// ~~~ 처리할 코드 
		// 값 뽑아서 -> vo 로 가공하고 -> Service 단으로 토스 -> 결과에 따라서 응답뷰 지정
		
		// return "응답 뷰 파일의 위치";
		// 결과에 따라서 응답 뷰 지정
		
		return "home";
		// 항상 경로명은 "/WEB-INF/views/xxx.jsp" 이런 식으로 작성하기 때문ㅁ에
		// DispatcherServlet 의 설정파일인 servlet-context.xml에 설정을 작성해야한다.
		// 주소의 자동완성을 등록해주는 도구 : view resolver
	}
	
	@RequestMapping(value="/test.do")
	public String test() {
		
		return "test";
	}
	
	// 실습 : views 폴더에 java.jsp 파일 (내용물은 아무거나0
	// java 메소드를 만들어서 화면 띄우기 (요청 url은 java.do)
	
}
