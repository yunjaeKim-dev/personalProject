package com.kimyunjae.board.vo;

public class BoardVo {
	private int boardno;
	private String title;
	private String content;
	private String writer;
	private String pwd;
	private int pub;
	private String writername;
	private int hitcount;
	private int recm;
	private int notrecm;
	private int parentno;
	private int bdepth;
	private int blevel;
	private String category;
	private String regdate;
	private String moddate;
	private boolean secret;
	
	public BoardVo() {};
	public BoardVo(int boardno, String title, String content, String writer, String pwd, int pub, String writername,
			int hitcount, int recm, int notrecm, int parentno, int bdepth, int blevel, String category, String regdate,
			String moddate, boolean secret) {
		super();
		this.boardno = boardno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.pwd = pwd;
		this.pub = pub;
		this.writername = writername;
		this.hitcount = hitcount;
		this.recm = recm;
		this.notrecm = notrecm;
		this.parentno = parentno;
		this.bdepth = bdepth;
		this.blevel = blevel;
		this.category = category;
		this.regdate = regdate;
		this.moddate = moddate;
		this.secret = secret;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getPub() {
		return pub;
	}
	public void setPub(int pub) {
		this.pub = pub;
	}
	public String getWritername() {
		return writername;
	}
	public void setWritername(String writername) {
		this.writername = writername;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	public int getRecm() {
		return recm;
	}
	public void setRecm(int recm) {
		this.recm = recm;
	}
	public int getNotrecm() {
		return notrecm;
	}
	public void setNotrecm(int notrecm) {
		this.notrecm = notrecm;
	}
	public int getParentno() {
		return parentno;
	}
	public void setParentno(int parentno) {
		this.parentno = parentno;
	}
	public int getBdepth() {
		return bdepth;
	}
	public void setBdepth(int bdepth) {
		this.bdepth = bdepth;
	}
	public int getBlevel() {
		return blevel;
	}
	public void setBlevel(int blevel) {
		this.blevel = blevel;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getModdate() {
		return moddate;
	}
	public void setModdate(String moddate) {
		this.moddate = moddate;
	}
	public boolean isSecret() {
		return secret;
	}
	public void setSecret(boolean secret) {
		this.secret = secret;
	}
	@Override
	public String toString() {
		return "BoardVo [boardno=" + boardno + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", pwd=" + pwd + ", pub=" + pub + ", writername=" + writername + ", hitcount=" + hitcount + ", recm="
				+ recm + ", notrecm=" + notrecm + ", parentno=" + parentno + ", bdepth=" + bdepth + ", blevel=" + blevel
				+ ", category=" + category + ", regdate=" + regdate + ", moddate=" + moddate + ", secret=" + secret
				+ "]";
	}
	
	
	
}
