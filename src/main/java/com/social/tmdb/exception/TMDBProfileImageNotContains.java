package com.social.tmdb.exception;

public class TMDBProfileImageNotContains extends RuntimeException {

	private static final long serialVersionUID = 2838557274790793163L;

	public TMDBProfileImageNotContains() {
		super();
	}

	public TMDBProfileImageNotContains(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TMDBProfileImageNotContains(String message) {
		super(message);
	}

}
