package com.restproducts.entities;

import java.util.List;

public class Paper {
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<Author> data;
	private Support support;
	
	public Paper() {}
	
	public Paper(int page, int per_page, int total, int total_pages, List<Author> data, Support support) {
		super();
		this.page = page;
		this.per_page = per_page;
		this.total = total;
		this.total_pages = total_pages;
		this.data = data;
		this.support = support;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public List<Author> getData() {
		return data;
	}

	public void setData(List<Author> data) {
		this.data = data;
	}

	public void addToData(Author inputAuthor) {
		data.add(inputAuthor);
	}
	
	public Support getSupport() {
		return support;
	}

	public void setSupport(Support support) {
		this.support = support;
	}

	@Override
	public String toString() {
		return "Paper [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages=" + total_pages
				+ ", data=" + data + ", support=" + support + "]";
	}
	
}
