package com.social.web.rest.exception;

/**
 * Custom exception para login em uso
 * 
 * @author Leonardo Cardena
 *
 */
public class FriendStatusBadGatewayException extends RuntimeException {

	private static final long serialVersionUID = 8031913518713783873L;

	public FriendStatusBadGatewayException(String message) {
		super(message);
	}
	
	public FriendStatusBadGatewayException(String message, Exception e) {
		super(message, e);
	}

}
