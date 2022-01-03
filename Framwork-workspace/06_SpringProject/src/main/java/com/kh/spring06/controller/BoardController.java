package com.kh.spring06.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.kh.spring06.board.model.vo.Member;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private SqlSession sqlSesson;
	
	@Autowired
	private BoardService boardService; 
	
	// 전체 게시글 목록을 보여주는 화면을 띄어주는 메소드
	@GetMapping("/boardList.do")
	public String boardList(Model model) {
		
		// sqlSession 을 이용해서 게시글 전체 조회 => SELECT => 여러 행 조회 => selectList()
		List<Board> list = sqlSesson.selectList("board.selectList");
		
		// 수하물 => Model 객체
		model.addAttribute("list", list);
		
		// 응답뷰 => return
		return "board/boardList"; 	// "/WEB-INF/views/board/boardList.jsp"
		
	}
	
	// 게시글을 조건에 맞게 조회해서 결과물을 띄어주는 메소드
	@GetMapping("search.do")
	public String search(
			@RequestParam String type,
			@RequestParam String keyword,
			Model model) {
		
		// 값을 가공해서 (적어도 개별 값 2개 이상일 경우는 무조건 가공( 가공한 값도 같이 넘겨줌)
		// case 1) VO 객체로 가공해서 넘김 ( 이건 이제 우리가 안해도 됨 -> @ModelAttribute 로 알아서 해서 넘겨주니깐)
		// case 2) 개별값들이 넘겨짐 => 절대로 VO 객체로 가공할 수가 없는 사이
		//		   이 경우에는? Map 이용
		//		  => 임의로 키-밸류 세트로 묶어서 일종의 VO 객체화
		Map<String, String> param = new HashMap<>(); // 다형성
		// Map 계열에 값을 넣을 때 쓰는 메소드 => put(키, 밸류);
		param.put("type", type);
		param.put("keyword", keyword);
		
		// sqlSession 을 이용해서 게시글 전체 조회 => SELECT => 여러 행 조회 => selectList()
		List<Board> list = sqlSesson.selectList("board.search", param);
		
		// 수하물 => Model 객체
		model.addAttribute("list", list);
		
		// 응답뷰 => return
		return "board/boardList"; 	// "/WEB-INF/views/board/boardList.jsp"
		
	}	
	
	// 한 개의 url로 검색도 되고 전체 조회도 되게끔
	@GetMapping("/union.do")
	public String union(
			@RequestParam(required = false) String type, // (required = false) : 텅 빈 값이 들어와도 넘기겠다
			@RequestParam(required = false) String keyword,
			Model model) {
		
		//VO 가 아닌 Map 으로 가공해서 넘겨야 함
		Map<String, String> param = new HashMap<>();
		
		// type, keyword 를 키-밸류 세트로 put
		param.put("type", type);
		param.put("keyword", keyword);
		
		// 쿼리문 실행 시 구멍을 매꿀 수도 있으니까 param을 같이 보냄
		List<Board> list = sqlSesson.selectList("board.unionList", param);
		
		// 화면에 뿌려줘야하니까 수화물
		model.addAttribute("list", list);
		
		// 수화물 다 붙였으면 응답뷰 지정
		return "board/boardList"; //화면단은 재활용 가능
	}
	
	// 게시글 작성 폼을 띄어주는 메소드
	@GetMapping("/write.do")
	public String write() {
		
		return "board/writer";
	}
	
	
	// 게시글 등록 처리를 위한 메소드
	@PostMapping("/write.do")
	public String write(@ModelAttribute Board board) {
		
		System.out.println(board);
		// boardWriter 가 null
		
		// 사용자 정보를 어디선가는 얻어와야함
		// 세선으로부터 현재 사용자의 정보를 뽑아서 boardWriter 필드에 담는다
		String boardWriter =((Member)session.getAttribute("loginUser")).getMemberId; 

		board.setBoardWriter(boardWriter);
		
		//Service 단으로 토스
		int result = boardService.write(board);
		
		// 결과에 따라서 메시지 띄우고 응답뷰 지정
		if( result > 0) {
			session.setAttribute("alertMsg", "게시글 등록 성공!");
			return "redirect:union.do"; // union.do 로 다이렉트
		}
		else { //실패
			session.setAttribute("alertMsg", "게시글 등록 실패!");
			return "redirect:write.do"; // write.do 로 다이렉트
			
		}
		return "redirect:write.do";
	}
	
}
