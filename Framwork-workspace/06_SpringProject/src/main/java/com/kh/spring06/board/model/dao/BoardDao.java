package com.kh.spring06.board.model.dao;

import com.kh.spring06.board.model.vo.Board;

public interface BoardDao {

	// 게시글 등록용 메소드 틀
	int write(Board board);
	
	// 게시글 상세조회용 메소드들 틀
	// 1. 조회수 증가
	int increaseCount(int boardNo);
	// 2. 상세조회
	Board content(int boardNo);
}
