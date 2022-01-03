package com.kh.spring08.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring08.model.vo.UploadVO;

@Controller
@RequestMapping("/file")
public class FileUploadController {
	
	// 파일 업로드 용 화면을 띄우는 메소드
	// 파일 업로드 방식 1 : @RequestParam을 이용해서 파일 1개를 수신하는 경우 (MultipartFile 타입)
	@GetMapping("/upload.do")
	public String upload() {
		return "upload";  // /WEB-INF/views/upload.jsp
	}
	
	// 파일 업로드 처리르 해주는 메소드
	/*
	@PostMapping("/upload.do")
	public String upload(
			@RequestParam String uploader,
			@RequestParam MultipartFile upfile ) {
		
		// MutipartFile : 요청 값이 파일 타입일 경우 받아주는 자료형
		/*
		System.out.println(uploader);
		System.out.println(upfile);
		// 파일이 있어도, 없어도 null 값이 나오지는 않음
		
		// 파일 업로드 유무 : MutipartFile 객체의 isEmpty() 메소드를 활용
		System.out.println("파일이 없나요 ? : " + upfile.isEmpty());
		// => 파일이 있다면 false, 파일이 없다면 true (비어있니 라고 물어보기 때문)
		
		return "redirect:upload.do";
	}
	*/
	// 체크박스일 경우 (하나의 키 값으로 여러 밸류) @RequestParam String[] or @RequestParam List<String>	
	// 파일 업로드 방식 2 : @RequestParam을 이요해서 파일 여러개를 수신 (MutipartFile[] 또는 List<MultipartFile>로 받으면됨)
	/*
	@PostMapping("/upload.do")
	public String upload(
			@RequestParam String uploader,
			//@RequestParam MultipartFile[] upfile ) {
			@RequestParam List<MultipartFile> upfile) {
		
		System.out.println(uploader);
		System.out.println("파일 갯수 : " + upfile.size());
		// 파이리 1개일 경우도, 파일이 0개일 경우에도 size== 1로 나옴
		
		System.out.println("파일이 없나요 ? : " + upfile.isEmpty());
		// List 에서 제공하는 isEmpty() 메소드를 활용
		// 파일이 0개인 경우에도 isEmpty()의 결과는 false가 나옴
		// => List 에서 제공하는 메소드들로 현재 파일이 있는지 없는 지 페크하는 것이 불가
		
		// => 그렇다면 MultipartFile 에서 제공하는 메소드를 써서 체크하자요 !!
		// List의 0번째 방에 들어있는 MultipartFile 타입의 객체한테 isEmpty() 메소드를 쓴다면 ?
		System.out.println("파일이 없나요 ? : " + upfile.get(0).isEmpty());
		// 여러개의 파일을 받을 경우에는
		// 현재 List의 0번째 인덱스에 들은 파일 (즉, 첫번째 파일) 기준으로 isEmpty()메소드를 적용하면
		// 파일이 있는지 없는지 확인 가능하다.
		
		return "redirect:upload.do";
	}
	*/
		
	// 파일 업로드 방식 3 : @ModelAtribute 를 이용해서 파일 수신
	// => 주의사항 : 해당 키값에 해당하는 필드명을 가진 VO 클래스를 미리 만드는 선행조건이 따름
	// @ModelAttribute를 사용하려면 필요한 선행 조건 : 내가 포장받을 형태의 VO클래스가 존재해야만함
	@PostMapping("/upload.do")
	public String upload(@ModelAttribute UploadVO uploadVO) {
		
		System.out.println(uploadVO.getUploader());
		System.out.println("파일 갯수 : " + uploadVO.getUpfile().size());
		System.out.println("파일이 없나요? : " + uploadVO.getUpfile().get(0).isEmpty());
		System.out.println("------------------");
		
		// 전달된 파일을 저장 => 서버 컴퓨터에다가 수정명으로 다운로드 받아둬야함 (파일명 중복 방지) ****
		// 			   => ATTACHMENT 테이블에 파일정보도 INSERT ****
		
		
		// 우선적으로 파일이 있는지 없는지 파악
		// => 조건이 너무 기므로 UploadVO 클래스에 
		//if(uploadVO.getUpfile().size() > 0 && !uploadVO.getUpfile().get(0).isEmpty()) {  
		if(uploadVO.isFileExist()) {
			// 정보 추출해서 서버에 저장
			
			// 파일 위치 뽑기 => 배포되는 물리적 경로
			// 배포되는 폴더로부터 upfiles 라는 폴더까지 절대경로로 제시
			// webapp ~ upfiles => /resources/upfiles/
			String savePath = session.getServletContext().getRealPath("/resources/upfiles/");
			//System.out.println(savePath);
			
			// 파일이 여러개일 가능성이 높다. => list 니깐 반복문 활용
			for(MultipartFile file : uploadVO.getUpFile()){
				// MutipartFile에서 제공하는 파일 정보 추출용 메소드들
				System.out.println("원본파일명 : " + file.getOriginalFilename());
				System.out.println("파일 사이즈(Byte) : " + file.getSize());
				System.out.println("파일유형 : " + file.getContentType());
				System.out.println("---------------------------");	
			
				// 추출한 정보를 기반으로 서버에 파일을 저장
				// File 객체 => new 구문으로 객체 생성 시 매개변수로 파일명 입력하면 해당 파일이 내 위치에 생기도록
				File target = new File(savePath,file.getOriginalFilename());
				// 파일 위치 => 배포폴더의 resources /upfiles 라는 물리적 경로에 담을 것 (실제 배포된 곳의 경로)
			
				// 파일 저장
				// MultipartFile 객체에서 제공하는 transferTo(파일객체) 메소드를 활용
				try {
					file.transferTo(target); // 해당 파일 정보(MultipartFile)를 파일(file)로써 저장시키겠다.
				} catch(IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}			
			
		}
		return "redirect:upload.do";
	}
	

