package com.kh.spring03.model.vo;

public class Member {

	private String userId;
	private String userPwd;
	private String nickName;
	
	public Member() {
		super();
	}

	public Member(String userId, String userPwd, String nickName) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.nickName = nickName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", nickName=" + nickName + "]";
	}
}
