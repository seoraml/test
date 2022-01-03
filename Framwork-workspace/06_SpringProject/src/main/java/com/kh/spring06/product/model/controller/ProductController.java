package com.kh.spring06.product.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring06.product.model.service.ProductService;
import com.kh.spring06.product.model.vo.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// 메인화면 띄우기 => 상품 관리 메인페이지 (/spring06/product/)
	@GetMapping("/")
	public String productHome() {
		return "product/home"; // "/WEB-INF/views/product/home.jsp"
	}
	
	// 상품 추가 화면 띄우기
	@GetMapping("/add.do")
	public String add() {
		return "product/add";
	}
	
	// 상품 목록 화면 띄우기
	@GetMapping("/list.do")
	public String list(Model model) {
		
		// 조회 => 여러 행 조회 => list
		List<Product> list = productService.selectProductList();
		
		// 조회된 결과를 수화물로 붙여서 => Model (소포상자)
		// addAttribute("키", 밸류)
		model.addAttribute("list", list);
		
		// 응답뷰 지정
		return "product/list";
	}
	
	// 상품 상세 조회 메소드
	// 요청 파라미터 방식
	//@GetMapping("/datail.do")
	//public String detail(
	//		@RequestParam int pno,
	//		Model model) {
		
	// 주소 변수 방식
	@GetMapping("/detail/{pno}")
	public String detail(
			@PathVariable int pno,
			Model model) {
		
		// @PathVariable : 주소 변수를 읽어들이겠다.
		
		
		// 조회 
		Product product = productService.detailProduct(pno);
		
		// 조회 결과를 수화물로 붙이기
		model.addAttribute("product", product);
		//응답뷰 지정
		return "product/datil"; // /WEB-INF/views/product/detail.jsp
	}
	
	// 주소 변수 방식으로 상품 삭제해주는 메소드
	@GetMapping("/delete/{pno}")
	public String delete(
			@PathVariable int pno) {
		
		// Service 단으로 pno 토스
		int result = productService.deleteProduct(pno);
		
		if(result > 0) {  //성공
			//return "redirect:../list.do"; // 상대경로로 한 겹 나와서 요청
			return "redirect:/product/list.do"; // 절대경로로 요청
		}
		else {  //실패
			return "redirect:../list.do?error"; // 상대경로
		}
		/*
		 *  *Path Variable 방식에서 삭제는 잘 되지만 
		 *  redirect 요청 시 나의 요청 위치를 기준으로 경로가 잡혀버림
		 *  => 해결 방법 : 한겹 나와서 요청 또는 절대 경로로 요청
		 *  
		 *  *Path Variable 방식에서의 해당 이슈 원인
		 *  => spring06/product/delete/x 에서 삭제할 경우 x가 지워지면서
		 *     spring06/product/delete/list.do 가 추가가됨
		 *     해당 경로로 redirect 됨
		 */
		
	}
	
}







