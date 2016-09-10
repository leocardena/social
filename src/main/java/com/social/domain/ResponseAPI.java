package com.social.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.http.HttpHeaders;

public class ResponseAPI<T> {
	
	private HttpHeaders headers;
	private T body;
	
	public ResponseAPI() {}
	
	public ResponseAPI(HttpHeaders headers, T response) {
		super();
		this.headers = headers;
		this.body = response;
	}
	
	public HttpHeaders getHeaders() {
		return headers;
	}
	
	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}
	
	public T getBody() {
		return body;
	}
	
	public void setBody(T response) {
		this.body = response;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
