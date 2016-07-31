package com.social.retrofit.exception;

public class RetrofitException extends RuntimeException {

	private static final long serialVersionUID = 7889104546185725733L;

	public RetrofitException() {
	}
	
	public RetrofitException(String message) {
		super(message);
	}
	
	public RetrofitException(String message, Exception e) {
		super(message, e);
	}

}
