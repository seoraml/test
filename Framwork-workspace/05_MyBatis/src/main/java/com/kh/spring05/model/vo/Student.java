package com.kh.spring05.model.vo;

public class Student {

	private String name; // NAME VARCHAR2(20), 
	private int age; // AGE NUMBER,
	private int score; // SCORE NUMBER,
	private String enrollDate; // ENROLL_DATE DATE DEFAULT SYSDATE
	
	public Student() {
		super();
	}

	public Student(String name, int age, int score, String enrollDate) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
		this.enrollDate = enrollDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + ", enrollDate=" + enrollDate + "]";
	}
}
