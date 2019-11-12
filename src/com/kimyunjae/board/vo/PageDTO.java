package com.kimyunjae.board.vo;

public class PageDTO {
	private Criteria cri;
	private int startPage;
	private int endPage;
	private int total;
	private boolean prev;
	private boolean next;
	public PageDTO() {}
	public PageDTO(Criteria cri,int total) {
		this.cri = cri;
		this.total = total;
		
		endPage = ((cri.getPage() - 1) / 10 + 1 ) * 10;
		startPage = endPage - 9;
		
		int realEnd = (total -1) / cri.getAmount() + 1;
		endPage = realEnd < endPage ? realEnd : endPage;
		
		prev = startPage > 1;
		next = endPage < realEnd;
		
		endPage = !next ? realEnd : endPage;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "PageDTO [cri=" + cri + ", startPage=" + startPage + ", endPage=" + endPage + ", total=" + total
				+ ", prev=" + prev + ", next=" + next + "]";
	}
	
	
}
