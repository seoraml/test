package com.kh.spring06.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring06.board.model.service.BoardService;
import com.kh.spring06.board.model.vo.Board;
import com.kh.spring06.member.model.vo.Member;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private BoardService boardService;

	// 전체 게시글 목록을 보여주는 화면을 띄워주는 메소드
	@GetMapping("/boardList.do")
	public String boardList(Model model) {
		
		// sqlSession 을 이용하여 게시글 전체 조회 => SELECT => 여러 행 조회 => selectList()
		List<Board> list = sqlSession.selectList("board.selectList");
		
		// 수하물 => Model 객체 (매개변수로 정의)
		// => model.addAttribute("키", 밸류)
		model.addAttribute("list", list);
		
		// 응답뷰 지정 => return
		return "board/boardList"; // "/WEB-INF/views/board/boardList.jsp" 
	}
	
	// 게시글을 조건에 맞게 조회해서 결과물을 띄워주는 메소드
	@GetMapping("/search.do")
	public String search(
			@RequestParam String type, 
			@RequestParam String keyword, 
			Model model) {
		
		// 값을 가공해서 (적어도 개별값 2개 이상일 경우는 무조건 가공)
		// case 1) VO 객체로 가공(이건 이제 우리가 안해도됨 => @ModelAttribute 로 알아서 해서 넘겨주니까)
		// case 2) 개별값들이 따로따로 넘겨짐 => 절대로 VO 객체로 가공할수가 없는 사이
		// 		      이 경우에는? Map 이용
		//  	   => 임의로 키(일종의 필드명)-밸류 세트로 묶어서 일종의 VO 객체화
		Map<String, String> param = new HashMap<>(); // 다형성
		// Map 계열에 값을 넣을때 쓰는 메소드 => put(키, 밸류);
		param.put("type", type);
		param.put("keyword", keyword);
		
		// sqlSession 을 이용해서 조건에 맞는 게시글을 조회 (가공한 값도 같이 넘겨줌)
		List<Board> list = sqlSession.selectList("board.search", param);
		
		// 수하물을 붙여서 => Model 객체
		model.addAttribute("list", list);
		
		// 응답 화면을 띄워줌
		return "board/boardList"; // 기존에 쓰던 boardList 화면
	}
	
	// 한개의 url 로 검색도 되고 전체 조회도 되게끔
	@GetMapping("/union.do")
	public String union(
			@RequestParam(required = false) String type,
			@RequestParam(required = false) String keyword, 
			Model model) {
		
		// VO 가 아닌 Map 으로 가공해서 넘겨야함
		Map<String, String> param = new HashMap<>();
		
		// type, keyword 를 키-밸류 세트로 put
		param.put("type", type);
		param.put("keyword", keyword);
		
		// 쿼리문 실행 시 구멍을 매꿀 수도 있으니까 param 을 같이 보냄
		List<Board> list = sqlSession.selectList("board.unionList", param);
		
		// 화면에 뿌려줘야하니까 수하물
		model.addAttribute("list", list);
		
		// 수하물 다 붙였으면 응답뷰 지정
		return "board/boardList"; // 화면단은 재활용 가능
	}
	
	// 게시글 작성 폼을 띄워주는 메소드
	@GetMapping("/write.do")
	public String write() {
		
		return "board/write"; // "/WEB-INF/views/board/write.jsp"
	}
	
	// 게시글 등록 처리를 위한 메소드
	@PostMapping("/write.do")
	public String write(
			@ModelAttribute Board board,
			HttpSession session) {
		
		// System.out.println(board);
		// boardWriter 가 null
		
		// 사용자 정보를 어딘선가는 얻어와야함
		// 세션으로부터 현재 사용자의 정보를 뽑아서 boardWriter 필드에 담는다.
		String boardWriter =((Member)session.getAttribute("loginUser")).getMemberId();
		
		board.setBoardWriter(boardWriter);
		
		// Service 단으로 토스
		int result = boardService.write(board);
		
		// 결과에 따라서 메세지 띄우고 응답뷰를 지정
		if(result > 0) { // 성공
			session.setAttribute("alertMsg", "게시글 등록 성공!");
			return "redirect:union.do"; // union.do 로 리다이렉트
		}
		else { // 실패 
			session.setAttribute("alertMsg", "게시글 등록 실패!");
			return "redirect:write.do"; // write.do 리다이렉트
		}
	}
	
	// 게시글 상세보기 메소드
	@GetMapping("/content.do")
	public String content(
			@RequestParam int boardNo,
			Model model) {
		
		// 게시글 조회 FLOW 
		// => 조회수 증가 먼저, 성공했다면 SELECT 문을 실행
		
		// 조회수 증가
		int result = boardService.increaseCount(boardNo);
		
		// 조회수 증가가 성공했다면 => BOARD 에서 SELECT
		if(result > 0) {
			Board board = boardService.content(boardNo);
			
			// 수하물 붙이기
			model.addAttribute("board", board);
			
			// 응답뷰 지정
			return "board/content";
		}
		else {
			return "redirect:union.do";
		}
		
	}
	
	
}









