package com.kimyunjae.reply.vo;

public class Reply {
	private int replyno;
	private int boardno;
	private String writer;
	private String writername;
	private String pwd;
	private String content;
	private String regdate;
	private boolean removal;

	
	public Reply() {};
	public Reply(int replyno, int boardno, String writer, String writername, String pwd, String content, String regdate,
			boolean removal) {
		super();
		this.replyno = replyno;
		this.boardno = boardno;
		this.writer = writer;
		this.writername = writername;
		this.pwd = pwd;
		this.content = content;
		this.regdate = regdate;
		this.removal = removal;
	}
	public int getReplyno() {
		return replyno;
	}
	public void setReplyno(int replyno) {
		this.replyno = replyno;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWritername() {
		return writername;
	}
	public void setWritername(String writername) {
		this.writername = writername;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public boolean isRemoval() {
		return removal;
	}
	public void setRemoval(boolean removal) {
		this.removal = removal;
	}
	@Override
	public String toString() {
		return "Reply [replyno=" + replyno + ", boardno=" + boardno + ", writer=" + writer + ", writername="
				+ writername + ", pwd=" + pwd + ", content=" + content + ", regdate=" + regdate + ", removal=" + removal
				+ "]";
	}
	
	

}
