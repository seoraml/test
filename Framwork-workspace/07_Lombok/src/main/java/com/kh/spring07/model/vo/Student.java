package com.kh.spring07.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString(exclude = "enrollDate")
@AllArgsConstructor
@Builder
@Data
public class Student {

	// 필드는 스스로 내가 만들어야 함
	// @Setter @Getter
	private String name;
	
	// @Setter @Getter
	private int age;
	
	// @Setter @Getter
	private int score;
	
	// @Setter @Getter
	private String enrollDate;
	
}

/*
 * * Lombok : 코드 자동화 라이브러리
 * => 쉽게 말해서 어노테이션으로 코드가 완성되었다고 이클립스를 속이는 원리이다.
 * 
 * * Lombok 어노테이션 정리
 * - @Setter : 각 필드마다 작성, 해당 필드의 Setter 메소드를 생성
 * - @Getter : 각 필드마다 작성, 해당 필드의 Getter 메소드를 생성
 * => 필드마다 붙일경우 필드마다 한개씩 해당 메소드가 생성되고,
 * 	    클래스 선언부 위에 붙일경우 모든 필드에 대해서 생성된다.
 * - @ToString : toString() 메소드를 오버라이딩
 * => exclude 속성을 부여하면 해당 필드만 빼고 모든 필드를 문자열로 연이어서 반환
 * - @NoArgsConstructor : 매개변수가 없는 기본생성자를 생성
 * - @AllArgsConstructor : 모든 필드에 대해서 매개변수로 가지고 있는 생성자를 생성
 * - @Builder : Builder 패턴으로 객체를 생성하고자 할 때 사용
 * 				단, @AllArgsConstructor 와 같이 사용해야한다.
 * - @Data : 위의 모든 어노테이션의 역할을 해줌
 * 			  즉, 우리가 기존에 했던 기본생성자,
 * 			 getter, setter, toString 을 모두 자동완성시켜주는 어노테이션
 */













