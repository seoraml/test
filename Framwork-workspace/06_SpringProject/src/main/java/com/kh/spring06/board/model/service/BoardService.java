package com.kh.spring06.board.model.service;

import com.kh.spring06.board.model.vo.Board;

public interface BoardService {

	// 게시글 등록용 메소드 틀
	int write(Board board);
	
	// 게시글 상세조회용 메소드들 틀
	// 1. 조회수 증가
	int increaseCount(int boardNo);
	// 2. 게시글 조회
	Board content(int boardNo);
}
