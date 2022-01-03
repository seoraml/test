package com.kh.spring04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	// 필드부
	// jdbcTemplate 이라는 도구를 사용하고 싶다면 Spring 한테 부탁
	// @Autowired 라는 어노테이션을 이용해서 부탁
	@Autowired // 자동으로 객체 생성
	private JdbcTemplate jdbcTemplate;

	// 메소드부
	// 메뉴 추가하는 폼을 띄워주는 요청을 할수있는 메소드
	@GetMapping("/insert.do")
	public String insert() {
		
		// 응답뷰의 경로를 문자열로 리턴
		return "menu/insert";
		// "/WEB-INF/views/menu/insert.jsp" => View Resolver 설정 (접두어, 접미어 생략)
	}
	
	// 메뉴를 실제로 추가해주는 요청을 할수있는 메소드
	@PostMapping("/insert.do")
	public String insert(
			@RequestParam String name,
			@RequestParam int price) {
		
		// 우선 값이 잘 뽑혀왔나 테스트
		System.out.println(name);
		System.out.println(price);
		
		// 처리 (DB 로 INSERT)
		// Service, Dao 는 일단 패스하고 Controller 에서 처리
		// 쿼리문 => xxx-mapper.xml 파일로부터 (MyBatis 에서)
		// 일단은 하드코딩으로 쿼리문 작성
		// 실행할 쿼리문
		String sql = "INSERT INTO MENU VALUES(?, ?)";
		
		// 빵꾸 메꾸고 (메꿀 준비)
		// => Spring JDBC 의 경우 메꿀 값들을 Object 타입의 배열에 담아두면
		// 알아서 빵꾸가 메꿔짐 (Object 타입인 이유? 무슨값이 들어올지 몰라서)
		Object[] param = {name, price}; // 선언과 동시에 초기화
		
		// 실행 => 실행할 구문과 메꿀 Object 타입의 배열을 같이 매개변수로 넘긴다.
		// JDBC 때는 쿼리문 실행하려면 PreparedStatement 객체의 executeUpdate() 메소드를 이용했는데
		// Spring JDBC 에서는 명령도구 를 이용
		// => 우리가 추가했던 명령도구는 컴파일된 클래스 형태
		// => 그 컴파일된 클래스에서 제공하는 쿼리문을 실행시키는 메소드를 호출해서 쓰겠다.
		
		// 스텝
		// 1. 도구의 이름(id 속성값) 을 이용해서 객체를 생성 (new 클래스명() X => Spring 에서 내가 등록한 도구(클래스)를 객체로 생성하겠다.)
		// => @Autowired 어노테이션 이용 (전역변수로)
		System.out.println(jdbcTemplate);
		// 객체가 잘 만들어졌다면? jdbcTemplate 객체의 주소값이 찍힘
		
		// 2. 메소드 호출해서 쿼리문을 실행
		// insert 의 경우에는 JdbcTemplate 클래스에서 제공하는 update() 메소드 사용
		jdbcTemplate.update(sql, param);
		// => 성공이면 COMMIT, 실패면 ROLLBACK => 자동으로 이미 다 끝남
		
		// 응답뷰 지정
		// return "redirect:insert.do"; // 상대경로
		return "redirect:/menu/insert.do"; // 절대경로
	}
	
}










