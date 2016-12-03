package com.social.web.rest.exception;

/**
 * Custom exception para key não encontrada
 * 
 * @author Leonardo Cardena
 *
 */
public class KeyNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -4443775826549166336L;

	public KeyNotFoundException(String message) {
		super(message);
	}
	
	public KeyNotFoundException(String message, Exception e) {
		super(message, e);
	}

}
