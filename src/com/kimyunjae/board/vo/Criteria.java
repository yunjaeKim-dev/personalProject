package com.kimyunjae.board.vo;

public class Criteria {
	private int page;
	private int amount;
	
	public Criteria() {
		this.page = 1;
		this.amount = 10;
	}

	public Criteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", amount=" + amount + "]";
	}

	
	
}
