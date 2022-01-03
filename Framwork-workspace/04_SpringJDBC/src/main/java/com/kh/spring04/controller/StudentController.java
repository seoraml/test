package com.kh.spring04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring04.model.vo.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	// 필드부
	// jdbcTemplate 객체 생성 => @Autowired
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 메소드부
	// 학생 등록 폼을 띄우는 요청 메소드
	@GetMapping("/regist.do")
	public String regist() {
		
		// 응답뷰를 문자열로 리턴
		return "student/regist";
		// "/WEB-INF/views/student/regist.jsp"
	}
	
	// 학생 정보를 실제로 DB 에 삽입시켜주는 요청을 하는 메소드
	@PostMapping("/regist.do")
	public String regist(@ModelAttribute Student student) {
		
		// 학생의 정보를 입력받아서 (@ModelAttribute 로 VO 로 가공된 형태로 매개변수로 받아보자)
		// INSERT
		
		// 값뽑기
		// VO 객체로 가공 => @ModelAttribute 가 여기까지 끝내서 보내준것
		
		// Service 단으로 토스
		// 아직은 Controller 에서 처리할것
		// 실행할 쿼리문
		String sql = "INSERT INTO STUDENT VALUES(?, ?, ?, DEFAULT)";
		
		// 위치홀더에 들어갈 값 => Object[] 로 순서대로 값을 대입
		Object[] param = {student.getName(), 
						  student.getAge(), 
						  student.getScore()};
		
		// 쿼리문 실행 => jdbcTemplate 을 만들었으니까 메소드를 호출
		jdbcTemplate.update(sql, param);
		
		// (결과에 따른) 응답뷰 지정 => 화면이동 X
		// return "redirect:regist.do"; // 상대경로, redirect 방식
		// return "student/regist"; 
		// INSERT, UPDATE, DELETE 문은 포워딩으로 응답뷰를 넘기면 새로고침했을때 같은 작업이 반복됨 => 두번 INSERT
		// SELECT 문의 경우는 상관 없다.
		
		// 응용문제) 만약에 성공했습니다 라는 화면으로 넘어가고 싶다면?
		// return "student/registSuccess"; // 부적합
		return "redirect:registSuccess.do";
		// 일단 내가 띄우고자 하는 화면을 띄워줄수 있는 요청 메소드를 하나 만들고
		// 그거를 url redirect 시켜주면 된다. => 한번 우회해서 띄우기
	}
	
	@GetMapping("/registSuccess.do")
	public String registSuccess() {
		
		return "student/registSuccess";
	}
	
	
}






