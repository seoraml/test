package com.kh.spring06.member.model.dao;

import java.util.List;

import com.kh.spring06.member.model.vo.Member;

public interface MemberDao {

	// 모듈화 작업 6단계 => MemberDao 인터페이스에 메소드 틀 만들기
	
	// 추상메소드 틀을 정의
	// 아이디 중복 체크 메소드 틀
	Member idCheck(Member m);
	
	// 회원가입 진행 메소드 틀
	int join(Member m);
	
	// 로그인기능 메소드 틀
	Member login(Member member);
	
	// 회원 전체조회기능 메소드 틀
	List<Member> memberList();
}












