package com.kimyunjae.member.vo;

public class Member {
	private String email;
	private String pwd;
	private String name;
	private String nickname;
	private String birthdate;
	private String phone;
	private boolean admin;
	private MemberFile file;
	public Member() {};
	public Member(String email, String pwd, String name, String nickname, String birthdate, String phone, boolean admin,
			MemberFile file) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
		this.birthdate = birthdate;
		this.phone = phone;
		this.admin = admin;
		this.file = file;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public MemberFile getFile() {
		return file;
	}
	public void setFile(MemberFile file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "Member [email=" + email + ", pwd=" + pwd + ", name=" + name + ", nickname=" + nickname + ", birthdate="
				+ birthdate + ", phone=" + phone + ", admin=" + admin + ", file=" + file + "]";
	}

	
		
}
