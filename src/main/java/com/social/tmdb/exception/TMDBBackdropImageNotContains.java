package com.social.tmdb.exception;

public class TMDBBackdropImageNotContains extends RuntimeException {

	private static final long serialVersionUID = 2905115338000267766L;

	public TMDBBackdropImageNotContains() {
		super();
	}

	public TMDBBackdropImageNotContains(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TMDBBackdropImageNotContains(String message) {
		super(message);
	}

}
