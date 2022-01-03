package com.kh.spring07;

import org.junit.Test;

import com.kh.spring07.model.vo.Student;

public class Test01 {

	// Lombok 을 테스트하기 위한 간단한 테스트 환경 구현
	// => 앞으로 간단한 테스트 환경은 src/test/java 에 구현하면 됨
	
	// JUnit : 자바 프로그래밍 언어용 유닛 테스트 프레임워크
	
	// TDD (Test Driven Development)
	// 테스트 주도 개발
	// 소프트웨어를 개발하는 여러 방법론 중 하나
	// 가장 작은 단위의 기능을 하는 코드들을 개발한 후 
	// 이게 잘 돌아가는지 개별 테스트할 경우 유용한 방법이다.
	
	@Test // JUnit 이라는 도구를 이용해서 테스트가 가능하도록 설정 (main 메소드를 만들필요 X)
	public void test() {
		
		// System.out.println("hello!");
		
		// Lombok 테스트
		
		// Student 클래스에 Lombok @Data 로 자동완성 한 코드가 유효한지 먼저 테스트
		Student s = new Student();
		s.setName("홍길동");
		s.setAge(11);
		s.setScore(100);
		s.setEnrollDate("2021-12-28");
		// => 자동완성 유효함
		
		// @AllArgsConstructor 어노테이션이 잘 구실을 하고있는지
		// 모든 필드에 대해 매개변수로 가지고 있는 생성자가 만들어졌는지 테스트
		Student s2 = new Student("고길동", 20, 80, "2021-12-28");
		// => 자동완성 유효함
		
		// @ToString 어노테이션이 잘 구실을 하는지
		// toString 메소드를 호출
		System.out.println("학생 정보 출력");
		System.out.println(s);
		System.out.println(s2.toString());
		// => 만약에, 이상한 주소값이 나왔으면 오버라이딩이 잘 안된것
		// => 자동완성 유효함
		
		// 객체 생성 : new 구문 이용 (FM)
		// Builder 패턴 형식으로 객체를 생성 : 코드가 직관적
		// @Builder 테스트
		Student s3 = Student.builder()
				.name("이순신")
				.age(18)
				.score(80)
				.enrollDate("2020-10-10").build();
		
		System.out.println("Builder 테스트");
		System.out.println(s3);
	}
	
}









