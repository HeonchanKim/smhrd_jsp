package com.VO;

public class memberVO {
	private String email;
	private String pw;
	private String tel;
	private String address;
	private String date;
	
	
	public memberVO(String email, String pw, String tel, String address, String date) {
		super();
		this.email = email;
		this.pw = pw;
		this.tel = tel;
		this.address = address;
		this.date = date;
	}

	public memberVO(String email, String tel, String address) {
		super();
		this.email = email;
		this.tel = tel;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}