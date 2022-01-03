package com.kh.spring05.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.spring05.model.vo.Menu;

@Controller
public class MenuController {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// 화면을 띄어주는 메소드
	@GetMapping("/insert.do")
	public String insertMenu() {
		
		return "menu/insertMenu"; // "WEB-INF/views/menu/insertMenu.jsp"
	}
	
	// 등록 버튼을 눌렀을 때 요청을 처리해주는 메소드
	@PostMapping("/insert.do")
	public String insertMenu(@ModelAttribute Menu menu) {
		
		sqlSession.insert("menu.insertMenu", menu);
		
		return "redirect:insert.do";
		
	}

	// 메뉴들의 목록 처리 (즉, 모든 메뉴들을 불러서 화면에 보여주겠다.)
	@GetMapping("/list.do")
	public String selectMenuList(Model model) {
		
		List<Menu> list = sqlSession.selectList("menu.selectMenuList"); 
		// 자동으로 다 맞춰서 list에 옮겨줌
		// => 즉, ResultSet으로부터 일일이 옮겨줄 필요가 없음
		
		// 수화물 => Model 객체 이용 (model.addAttribute("키", 밸류);)
		model.addAttribute("list", list);
		
		// 응답뷰 지정
		return "menu/list"; // "WEB-IN/views/menu/list.jsp"
		
	}
	
	
}
