package com.social.web.rest.response;

public class PostResponseAPI<T> {
	
	private String href;
	private T content;
	
	public PostResponseAPI() {}

	public PostResponseAPI(T objectResponse) {
		this.content = objectResponse;
	}
	
	public PostResponseAPI(String href, T objectResponse) {
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
