package com.kh.spring06.member.model.service;

import java.util.List;

import com.kh.spring06.member.model.vo.Member;

// 인터페이스를 만들고 거기에 따라서 따로 구현해야 하는 이유 : 코드의 확장성, 호환성을 높이기 위해서임!!
// => 로직이 바뀌면 틀은 그대로 두고 구현단의 코드만 살짝 바꾸면 되니깐
public interface MemberService {

	// 이곳에는 메소드의 틀만 정의 (추상메소드)
	
	// 모듈화 작업 3단계 => Service 인터페이스에 메소드 틀 만들기
	// 회원가입기능 메소드 틀
	int join(Member m);
	// public 생략 이유 : 어차피 재정의해서 써야하기 때문에 (다른곳에서 접근 가능해야하기 때문)

	// 로그인기능 메소드 틀
	Member login(Member member);
	
	// 회원전체조회 기능 메소드 틀
	List<Member> memberList();

}







