package com.social.web.rest.dto;

public class PostResponseDTO<T> {
	
	private String href;
	private T content;
	
	public PostResponseDTO() {}

	public PostResponseDTO(T objectResponse) {
		this.content = objectResponse;
	}
	
	public PostResponseDTO(String href, T objectResponse) {
		super();
		this.href = href;
		this.content = objectResponse;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

}
