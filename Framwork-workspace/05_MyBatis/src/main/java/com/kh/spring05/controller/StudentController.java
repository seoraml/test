package com.kh.spring05.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring05.model.vo.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	//MyBatis
	@Autowired  // 미리 등록했던 도구를 자동으로 객체로 생성해서 쓰겠다 (== 도구를 연장해서 쓰겠다)
	private SqlSession sqlSession;
	
	// 학생 등록 폼을 띄울 수 있는 메소드
	@GetMapping("/regist.do")
	public String regist() {
		
		return "student/regist"; // "WEB-INF/views/student/regist/jsp"
	}
	
	// 등록 버튼을 눌렀을 때 처리해주는 메소드
	@PostMapping("/regist.do")
	public String regist(@ModelAttribute Student student) {
		
		// Spring JDBC 에서는
		// jdbcTemplate 이라는 객체를 생성해서 쿼리문을 실행
		// 위치 홀더로 구멍 뚫어놓은거 Object[] 로 메꿔서 실행
		
		// MyBatis 에서는
		// sqlSession 을 이용해서 mapper 를 호출하고 실행
		// => 우선적으로 sqlSession 객체를 생성 (도구를 이미 등록했으므로 @Autowired 를 이용하면 됨)
		// insert, update, delect, selectOne => 단일행 조회(VO), selectList => 여러행 조회(ArrayList)
		
		// insert 를 실행할 계획이므로
		// sqlSession.insert("구문이름", 데이터);
		// => 구문이름 ? mapper의 namespace.id
		sqlSession.insert("student.registStudent", student);
		
		return "redirect:regist.do";
		
	}
	
	@GetMapping("/list.do")
	public String studentList() {
		
		// 잘 조회해서 
		
		// 수화물 붙인 다음에
		
		// 응답뷰 지정
		return "student/regist.do";
	}
}
