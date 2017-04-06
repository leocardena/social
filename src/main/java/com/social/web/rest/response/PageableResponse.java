package com.social.web.rest.response;

import java.util.List;
import org.springframework.data.domain.Page;

public class PageableResponse<T> {

	private Integer totalPages;
	private Integer size;
	private Long totalElements;
	private Integer number;
	private List<T> content;

	public PageableResponse(Integer totalPages, Integer size, Long totalElements, Integer number, List<T> content) {
		super();
		this.totalPages = totalPages;
		this.totalElements = totalElements;
		this.number = number;
		this.content = content;
	}

	public PageableResponse() {
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
