package com.kh.spring08.model.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadVO {

	private String uploder;
	// private MultipartFile upfile;  // 파일 최대 1개
	private List<MultipartFile> upfile;  // 파일 여러개
	
	// 파일 유무를 반환하는 메소드
	public boolean isFileExist() {
		
		// 파일이 없는 경우의 수를 나열 => 각각 return false;
		if(upfile == null) {  // upfile이 아예 null 일때
			return false;
		}
		if(upfile.size() < 1){ // upfile 객체가 있지만 size가 0일 경우
			return false;
		}
		if(upfile.get(0).isEmpty()){  //upfile 객체의 0 번째 인덱스의 파일이 비어있는 경우
			return false;
		}
		// 나머지의 경우는 무조건 파일이 있음 !!
		return true;
	}
}
