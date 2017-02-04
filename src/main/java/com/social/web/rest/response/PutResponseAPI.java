package com.social.web.rest.response;

public class PutResponseAPI<T> {
	private T content;
	
	public PutResponseAPI() {}

	public PutResponseAPI(T objectResponse) {
		this.content = objectResponse;
	}
	
	public PutResponseAPI(String href, T objectResponse) {
		super();
		this.content = objectResponse;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

}
