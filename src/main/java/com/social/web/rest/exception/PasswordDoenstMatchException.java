package com.social.web.rest.exception;

/**
 * Custom exception passoword diferente do atual
 * 
 * @author Leonardo Cardena
 *
 */
public class PasswordDoenstMatchException extends RuntimeException {

	private static final long serialVersionUID = 8031913518713783873L;

	public PasswordDoenstMatchException(String message) {
		super(message);
	}
	
	public PasswordDoenstMatchException(String message, Exception e) {
		super(message, e);
	}

}
