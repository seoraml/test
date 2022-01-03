package com.kh.spring06.controller;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring06.member.model.service.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	// @Autowired
	// private SqlSession sqlSession;
	
	@Autowired
	private MemberService memberService;
	
	// 회원 정보 리스트를 띄어주는 메소드
	@GetMapping("/memberList.do")
	public String memberList(Model model) {
		
		// 화면을 뿌려주기 전에
		// 조회부터 할거 => DB 에 저장된 회원의 정보를 싹 긁어와야함 (SELECT)
		// Spring +MyBatis => 도구를 가져다 쓰겠다고 연동 먼저 ( == 객체 생성, @Autowired)
		// 도구 이름 : sqlSession
		
		// 모듈화 전
		//List<Member> list = sqlSession.selectList("member.selectList");
		
		// 모듈화 후
		// Service 단으로 토스
		List<Member> list = memberService.memberList();
		
		// 조회를 다 했다면 => 수화물을 붙이고 (Model 객체를 이용해서 addAttribute 메소드 이용)
		model.addAttribute("list", list);
		// 응답뷰 지정
		return "admin/memberList";
	}
	
	
}
