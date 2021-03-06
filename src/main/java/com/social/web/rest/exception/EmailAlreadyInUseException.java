package com.social.web.rest.exception;

/**
 * Custom exception para email em uso
 * 
 * @author Leonardo Cardena
 *
 */
public class EmailAlreadyInUseException extends RuntimeException {
	
	private static final long serialVersionUID = -4678073042610920173L;

	public EmailAlreadyInUseException(String message) {
		super(message);
	}
	
	public EmailAlreadyInUseException(String message, Exception e) {
		super(message, e);
	}

}
