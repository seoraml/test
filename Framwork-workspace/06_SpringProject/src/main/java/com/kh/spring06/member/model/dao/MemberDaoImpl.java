package com.kh.spring06.member.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring06.member.model.vo.Member;

// Repository : "저장소" 라는 뜻
//			    Spring 에서는 주로 DB(== 데이터를 보관하는 저장소) 와 관련된 작업 을 처리하겠다.
//				즉, DB 와 관련된 작업이라고 하면 CRUD 를 일컫는다. (== "영속성" 작업)
@Repository // Dao 단임을 명시
public class MemberDaoImpl implements MemberDao {

	// 모듈화 작업 7단계 => 영속성 작업을 위한 sqlSession 도구를 연동
	@Autowired
	private SqlSession sqlSession;
	
	// 실제 메소드를 오버라이딩해서 구현해서 쓸 것
	// 모듈화 작업 8단계 => Dao 인터페이스에서 만들었던 메소드 오버라이딩 하기
	// 아이디 중복체크
	@Override
	public Member idCheck(Member m) {
		return sqlSession.selectOne("member.idCheck", m.getMemberId());
	}

	// 회원가입 진행 => INSERT
	@Override
	public int join(Member m) {
		return sqlSession.insert("member.join", m);
	}

	// 로그인 진행 메소드 => SELECT
	@Override
	public Member login(Member member) {
		return sqlSession.selectOne("member.loginMember", member);
	}

	// 회원전체조회 기능 메소드 => SELECT (여러행)
	@Override
	public List<Member> memberList() {
		return sqlSession.selectList("member.selectList");
	}
}







