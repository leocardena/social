package com.social.web.rest.exception;

/**
 * Custom exception para login em uso
 * 
 * @author Leonardo Cardena
 *
 */
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8031913518713783873L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(String message, Exception e) {
		super(message, e);
	}

}
