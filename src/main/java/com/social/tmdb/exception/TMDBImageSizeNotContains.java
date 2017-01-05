package com.social.tmdb.exception;

public class TMDBImageSizeNotContains extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TMDBImageSizeNotContains() {
		super();
	}

	public TMDBImageSizeNotContains(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TMDBImageSizeNotContains(String message) {
		super(message);
	}
	
}
