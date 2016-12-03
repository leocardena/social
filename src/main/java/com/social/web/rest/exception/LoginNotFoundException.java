package com.social.web.rest.exception;

/**
 * Custom exception para login não encontrado
 * 
 * @author Leonardo Cardena
 *
 */
public class LoginNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8031913518713783873L;

	public LoginNotFoundException(String message) {
		super(message);
	}
	
	public LoginNotFoundException(String message, Exception e) {
		super(message, e);
	}

}

