package com.social.rest.exception;

public class NoListFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoListFound(String message) {
		super(message);
	}
	
	public NoListFound(String message, Exception e) {
		super(message, e);
	}
	
}
