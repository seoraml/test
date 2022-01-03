package com.kh.spring06.member.model.vo;

public class Member {

	private String memberId; // MEMBER_ID VARCHAR2(20) PRIMARY KEY, -- 아이디
	private String memberPwd; // MEMBER_PWD VARCHAR2(16) NOT NULL, -- 비밀번호
	private String memberNick; // MEMBER_NICK VARCHAR2(24) NOT NULL UNIQUE, -- 닉네임
	private String post; // POST CHAR(6), -- 우편번호
	private String baseAddr; // BASE_ADDR VARCHAR2(300), -- 기본주소
	private String extraAddr; // EXTRA_ADDR VARCHAR2(300), -- 상세주소
	private String birth; // BIRTH DATE NOT NULL, -- 생일
	private String phone; // PHONE CHAR(13) NOT NULL, -- 휴대폰
	private String memberIntro; // MEMBER_INTRO VARCHAR2(4000), -- 자기소개
	private String memberAuth; // MEMBER_AUTH VARCHAR2(9) NOT NULL, -- 회원등급
	private String enrollDate; // ENROLL_DATE DATE DEFAULT SYSDATE NOT NULL, -- 가입일
	private String lastLogin; // LAST_LOGIN DATE -- 로그인한 시간	
	
	public Member() {
		super();
	}

	public Member(String memberId, String memberPwd, String memberNick, String post, String baseAddr, String extraAddr,
			String birth, String phone, String memberIntro, String memberAuth, String enrollDate, String lastLogin) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberNick = memberNick;
		this.post = post;
		this.baseAddr = baseAddr;
		this.extraAddr = extraAddr;
		this.birth = birth;
		this.phone = phone;
		this.memberIntro = memberIntro;
		this.memberAuth = memberAuth;
		this.enrollDate = enrollDate;
		this.lastLogin = lastLogin;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getBaseAddr() {
		return baseAddr;
	}

	public void setBaseAddr(String baseAddr) {
		this.baseAddr = baseAddr;
	}

	public String getExtraAddr() {
		return extraAddr;
	}

	public void setExtraAddr(String extraAddr) {
		this.extraAddr = extraAddr;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMemberIntro() {
		return memberIntro;
	}

	public void setMemberIntro(String memberIntro) {
		this.memberIntro = memberIntro;
	}

	public String getMemberAuth() {
		return memberAuth;
	}

	public void setMemberAuth(String memberAuth) {
		this.memberAuth = memberAuth;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberNick=" + memberNick + ", post="
				+ post + ", baseAddr=" + baseAddr + ", extraAddr=" + extraAddr + ", birth=" + birth + ", phone=" + phone
				+ ", memberIntro=" + memberIntro + ", memberAuth=" + memberAuth + ", enrollDate=" + enrollDate
				+ ", lastLogin=" + lastLogin + "]";
	}
}
