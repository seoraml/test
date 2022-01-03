package com.kh.spring03.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/multi") // 공용주소를 맵핑
public class MultiController {

	// 항상 컨트롤러의 메소드 위에다가
	// Get 이라던지 Post 던지 간에 url 주소를 맵핑해줘야 한다!!!!!!!!!
	// 화면 먼저 띄우자 => GET 방식 (굳이 민감정보가 들어갈 일이 없으니깐)
	@GetMapping("/test.do")
	public String test() {
		
		// 응답뷰 띄우기
		return "test"; // "/WEB-INF/views/test.jsp"
	}
	
	// 실제적으로 값을 넘겨받아서 처리하는 메소드를 만들자
	// => 같은 url 주소라도 요청이 겹치지 않게 POST 방식으로 맵핑
	@PostMapping("/test.do")
	public String test(
			@RequestParam(required = false) ArrayList<String> fruit, 
			Model model) {
		// Spring 에서는 체크박스의 경우 String[] 형태 뿐만 아니라
		// ArrayList<String> 형식으로도 값을 받을수가 있다.
		
	// public String test(@RequestParam(required = false) String[] fruit) { // 메소드명이 중복 : 오버로딩
		// 체크박스의 경우 @RequestParam String[] 매개변수명 형태로 
		// 매개변수로써 값을 전달받을 수 있다.
		// 키값이랑 매개변수명은 반드시 동일해야한다.
		// fruit = ["사과", "바나나", "딸기"];
		// 아무것도 체크 안하고 넘길경우 fruit = null;
		// => required = false 속성 부여 X : 400 잘못된 요청 에러 발생 (아무것도 체크 안해서 발생한 오류)
		// => required = false 속성 부여 O : 아무것도 체크 안하고 넘겨도 오류가 발생하지 않는것
		
		if(fruit != null) {
			// 향상된 for 문
			for(String f : fruit) {
				System.out.println(f);
			}
		}
		
		// VO 객체로 가공 -> Service 단으로 토스 -> 결과값 (다 했다라는 가정 하에)
		
		// 수하물 붙이기 : request.setAttribute("키", 밸류); => 기존 servlet 방식
		// Model 이라는 객체를 이용 (매개변수로 전달받아서) => Spring 방식
		// 사용되는 메소드 : model.addAttribute("키", 밸류);
		model.addAttribute("fruit", fruit);
		
		// 다른 페이지로 넘겨보자
		return "testResult";
		
		// 화면이 넘어가지 않고 기존 화면으로 재요청 (redirect:/공용주소를포함한요청할url)
		// return "redirect:/multi/test.do";
	}
	
}







