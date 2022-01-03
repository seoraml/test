package com.kh.spring06.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring06.member.model.dao.MemberDao;
import com.kh.spring06.member.model.vo.Member;

@Service // Service 단임을 명시
public class MemberServiceImpl implements MemberService {

	// 모듈화 작업 5단계 => MemberDao 객체를 @Autowired 로 생성해두기
	@Autowired
	private MemberDao memberDao;
	// 인터페이스 객체 생성가능? 안됨
	// => 엄밀히 따지면 new 문으로 객체를 생성한거는 아니고
	//    도구를 가져다 쓰겠다고 연동한것!
	// => 부모격인 MemberDao 인터페이스를 선언했지만 자바의 동적바인딩에 의해서 
	// 	    자식인 MemberDaoImpl 클래스 의 메소드가 호출되어서 실행되는 구조
	
	// 인터페이스의 추상메소드를 오버라이딩 해서 쓸것
	
	// 모듈화 작업 4단계 => Service 구현체에 메소드 오버라이딩
	@Override
	public int join(Member m) {

		// 결과값을 담을 변수 초기화
		int result = 0;
		
		// DAO 단을 호출해서 진행 => MemberDao 객체 필요
		// 일단 아이디 중복체크를 하고 => SELECT 문
		Member findMem = memberDao.idCheck(m);
		
		// 중복되는 아이디가 없다면 가입 진행 => INSERT 문
		if(findMem == null) { // 중복 아이디가 없다면 => 가입 진행
			result = memberDao.join(m);
		} // 성공하면 result == 1
		
		return result;
	}

	// 로그인 처리 메소드
	@Override
	public Member login(Member member) {

		// 마지막 로그인시간 업데이트 해보기 => 숙제
		
		// 로그인
		Member loginUser = memberDao.login(member);
		
		return loginUser;
	}

	// 회원 전체조회 메소드
	@Override
	public List<Member> memberList() {

		List<Member> list = memberDao.memberList();
		
		return list;
	}

	
}








