package com.social.rest.exception;

public class LoginNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8031913518713783873L;

	public LoginNotFoundException(String message) {
		super(message);
	}
	
	public LoginNotFoundException(String message, Exception e) {
		super(message, e);
	}

}

