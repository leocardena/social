package com.social.domain;

import org.springframework.http.HttpHeaders;

public class ResponseAPI<T> {
	
	private HttpHeaders headers;
	private T response;
	
	public ResponseAPI() {}
	
	public ResponseAPI(HttpHeaders headers, T response) {
		super();
		this.headers = headers;
		this.response = response;
	}
	
	public HttpHeaders getHeaders() {
		return headers;
	}
	
	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}
	
	public T getResponse() {
		return response;
	}
	
	public void setResponse(T response) {
		this.response = response;
	}

}
