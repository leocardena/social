package com.social.rest.exception;

public class LoginAlreadyInUseException extends RuntimeException {

	private static final long serialVersionUID = 8031913518713783873L;

	public LoginAlreadyInUseException(String message) {
		super(message);
	}
	
	public LoginAlreadyInUseException(String message, Exception e) {
		super(message, e);
	}

}
