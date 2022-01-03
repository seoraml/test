package com.kh.spring06.board.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring06.board.model.vo.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int write(Board board) {
		return sqlSession.insert("board.write", board);
	}

	@Override
	public int increaseCount(int boardNo) {
		return sqlSession.update("board.increaseCount", boardNo);
	}

	@Override
	public Board content(int boardNo) {
		return sqlSession.selectOne("board.selectDetailView", boardNo);
	}
}







