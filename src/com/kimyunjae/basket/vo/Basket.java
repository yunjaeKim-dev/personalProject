package com.kimyunjae.basket.vo;

public class Basket {
	private int basketno;
	private String email;
	private int gno;
	private String regdate;
	public Basket() {}
	public Basket(int basketno, String email, int gno, String regdate) {
		super();
		this.basketno = basketno;
		this.email = email;
		this.gno = gno;
		this.regdate = regdate;
	}
	public int getBasketno() {
		return basketno;
	}
	public void setBasketno(int basketno) {
		this.basketno = basketno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Basket [basketno=" + basketno + ", email=" + email + ", gno=" + gno + ", regdate=" + regdate + "]";
	}
	



}
