package com.kimyunjae.game.vo;

public class Game {
	private int gno;
	private String gname;
	private int price;
	private double discount;
	private String imgpath;
	private String category;
	
	private String goutline;
	private String gexplain;
	private double gusercom;
	private String regdate;
	
	private int dlc;
	private int ori;
	private int basketno;
	public Game() {}
	public Game(int gno, String gname, int price, double discount, String imgpath, String category, String goutline,
			String gexplain, double gusercom, String regdate, int dlc, int ori, int basketno) {
		super();
		this.gno = gno;
		this.gname = gname;
		this.price = price;
		this.discount = discount;
		this.imgpath = imgpath;
		this.category = category;
		this.goutline = goutline;
		this.gexplain = gexplain;
		this.gusercom = gusercom;
		this.regdate = regdate;
		this.dlc = dlc;
		this.ori = ori;
		this.basketno = basketno;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGoutline() {
		return goutline;
	}
	public void setGoutline(String goutline) {
		this.goutline = goutline;
	}
	public String getGexplain() {
		return gexplain;
	}
	public void setGexplain(String gexplain) {
		this.gexplain = gexplain;
	}
	public double getGusercom() {
		return gusercom;
	}
	public void setGusercom(double gusercom) {
		this.gusercom = gusercom;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getDlc() {
		return dlc;
	}
	public void setDlc(int dlc) {
		this.dlc = dlc;
	}
	public int getOri() {
		return ori;
	}
	public void setOri(int ori) {
		this.ori = ori;
	}
	public int getBasketno() {
		return basketno;
	}
	public void setBasketno(int basketno) {
		this.basketno = basketno;
	}
	@Override
	public String toString() {
		return "Game [gno=" + gno + ", gname=" + gname + ", price=" + price + ", discount=" + discount + ", imgpath="
				+ imgpath + ", category=" + category + ", goutline=" + goutline + ", gexplain=" + gexplain
				+ ", gusercom=" + gusercom + ", regdate=" + regdate + ", dlc=" + dlc + ", ori=" + ori + ", basketno="
				+ basketno + "]";
	}
}
