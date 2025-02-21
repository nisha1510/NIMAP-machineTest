package com.demo.SpringBootJPA.DTO;

import java.util.List;

import com.demo.SpringBootJPA.Entity.Category;

public class PageResponse<T> {
	private List<T> content;
	private int pageNumber;
	
	public PageResponse() { }
	
	public PageResponse(List<T> content, int pageNumber) {
		this.content = content;
		this.pageNumber = pageNumber;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
}
