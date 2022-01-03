package com.kh.spring06.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring06.member.model.service.MemberService;
import com.kh.spring06.member.model.vo.Member;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	// 모듈화 작업 0단계
	// sqlSession : DB 연동과 관련된 도구 => DB 와 관련된 작업은 DAO 단에서
	// 앞으로 sqlSession 객체는 쿼리문을 실행하고 결과를 받아오는 DAO 단에서만 생성할 것!
	// @Autowired
	// private SqlSession sqlSession;
	
	// 모듈화 작업 1단계
	// 앞으로 항상 Controller 단 에서는 Service 단으로 토스 할 것이기 때문에
	// 전역변수로 항상 위에 Service 객체를 만들어 둘 것임 => new 구문 이용? ㄴㄴ
	// @Autowired 어노테이션을 이용해야 한다!!!! (스프링의 IoC 특성)
	@Autowired
	private MemberService memberService;

	// 회원가입 폼을 띄워주는 요청을 하는 메소드
	@GetMapping("/join.do")
	public String join() {
		return "member/join";
	} // 모듈화 작업 X
	
	// 회원가입 요청을 처리 해주는 메소드
	@PostMapping("/join.do")
	public String join(@ModelAttribute Member m) {
		
		// 완제품으로 받거나 / 개별값 잘 뽑아서
		
		// 모듈화 전 
		// DB 명령문을 실행한 다음에
		// 아이디 중복체크 하고
		// Member findId = sqlSession.selectOne("member.idCheck", m.getMemberId());
		/*
		 * selectList() : 여러 행 조회시 호출하는 메소드 => List 타입으로 리턴
		 * selectOne() : 한 행 조회시 호출하는 메소드 => 해당 VO 객체 타입으로 리턴
		 */

		/*
		// 중복된 계정이 없다면 가입 절차 진행
		if(findId == null) {
			sqlSession.insert("member.join", m);

			// 만약에 수하물이 있다면 붙이고
			
			// 응답뷰 지정
			return "redirect:joinSuccess.do";
		}
		else { // 이미 존재하는 경우
			
			return "redirect:join.do?error";
		}
		*/
		
		// 모듈화 후
		// 모듈화 작업 2단계 => Service 단으로 토스
		// 매개변수로 넘겨받았던 요청값인 Member m 을 Service 단으로 토스
		// INSERT 문 => 처리된 행의 갯수
		int result = memberService.join(m);
		
		// 결과에 따라서 응답뷰 지정
		if(result > 0) { // 성공
			return "redirect:joinSuccess.do";
		}
		else { // 실패
			return "redirect:join.do?error";
		}
		
	} // 모듈화 작업 필요
	
	// 성공 화면 띄워주는 메소드
	@GetMapping("/joinSuccess.do")
	public String joinSuccess() {
		return "member/joinSuccess";
	} // 모듈화 작업 필요 X
	
	// 로그인 폼을 띄워주는 메소드
	// /member/login.do 로 GET 방식으로 요청시 로그인 폼이 보여져야함
	@GetMapping("/login.do")
	public String login() {
		return "member/login"; // "/WEB-INF/views/member/login.jsp"
	} // 만약에 메인화면에 include 시켰다면 필요없는 메소드
	// 모듈화 작업 필요 X
	
	// 로그인 요청이 들어왔을 때 처리해주는 메소드
	// /member/login.do 로 POST 방식으로 입력한 값들이 들어가서 처리되야함
	@PostMapping("/login.do")
	public String login(
			@ModelAttribute Member member, 
			HttpSession session) {
		
		// System.out.println(member);
		// JVM 이 값이 안담긴 필드에 대해서는 초기값으로 초기화 해줌을 볼 수 있음
		// 참고로 String = null, int = 0, char = ' '
		
		// 모듈화 전
		/*
		// 값 뽑고 VO 로 가공해서 로그인 처리
		// ID 는 unique 제약조건이므로 조회되봤자 최대 한건
		Member loginUser = sqlSession.selectOne("member.loginMember", member);
		// => 만약에 유저 정보가 없다면 null 값이 들어갈것!!
		
		if(loginUser == null) { // 로그인 실패
			
			// 실패 시 알람메세지
			session.setAttribute("alertMsg", "로그인에 실패하였습니다.");
			
			// 로그인 실패 시 로그인 폼 다시 띄우기 => redirect 방식
			// return "redirect:/spring06/member/login.do"; 절대경로
			// return "redirect:login.do?error";
		}
		else { // 로그인 성공

			// session 객체를 사용하려면
			// 매개변수로 HttpSession 타입의 객체를 정의하면 된다.
			
			// 예전처럼 session alertMsg 담고
			session.setAttribute("alertMsg", "성공적으로 로그인이 되었습니");
			
			// login 한 회원정보도 담아서 보낼것 => session.setAttribute("키", 밸류);
			session.setAttribute("loginUser", loginUser);
			
			// 메인화면으로 redirect
			// return "redirect:/"; // 절대경로
		}
		*/
		
		// 모듈화 후
		// ~ VO 로 가공까지는 @ModelAttribute 가 해서 전달해줌 (완제품)
		// VO 객체 (Member member) 를 Service 단으로 토스
		Member loginUser = memberService.login(member);
		
		// 결과에 따른 응답뷰 지정
		if(loginUser == null) { // 로그인 실패
			// 실패시 알람메세지
			session.setAttribute("alertMsg", "로그인에 실패하였습니다.");
		}
		else { // 로그인 성공
			// session 에 성공메세지
			session.setAttribute("alertMsg", "로그인에 성공하였습니다.");
			
			// session 에 로그인한 회원의 정보 담기
			session.setAttribute("loginUser", loginUser);
		}
		// 성공이든 실패든 메인화면으로 redirect
		return "redirect:/";
		
	} // 모듈화 작업 필요
	
	// 로그아웃 처리를 해주는 메소드
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		
		// 로그아웃 : session 에 있는 회원 정보를 지우면 됨
		// => 방법 1) 세션 무효화 (invalidate 메소드)
		// => 방법 2) 해당 키값을 삭제 (removeAttribute 메소드)
		
		// 방법 1)
		// session.invalidate(); // 세션이 이미 무효화가 됨
		
		// 방법 2)
		session.removeAttribute("loginUser");
		
		// 로그아웃되었습니다. 알람메세지도 같이 띄우기
		session.setAttribute("alertMsg", "로그아웃 되었습니다.");
		// 이미 무효화가 된 세션에 수하물을 실어버림 => 오류
		// 오류 해결방법 : invalidate 쓰고 알람메세지 띄우는걸 포기하던가
		//			   removeAttribute 를 이용하고 알람메세지를 살리던가
		
		return "redirect:/";
	} // 모듈화 필요 X
	
}













