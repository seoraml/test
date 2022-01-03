package com.kh.spring06.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring06.board.model.dao.BoardDao;
import com.kh.spring06.board.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	// 게시글 등록용 메소드
	@Override
	public int write(Board board) {

		int result = boardDao.write(board);
		
		return result;
	}

	// 조회수 증가용 메소드
	@Override
	public int increaseCount(int boardNo) {

		int result = boardDao.increaseCount(boardNo);
		return result;
	}

	// 상세조회용 메소드
	@Override
	public Board content(int boardNo) {
		
		Board board = boardDao.content(boardNo);
		return board;
	}
	
}








