package com.social.tmdb.exception;

public class TMDBStillImageNotContains extends RuntimeException {

	private static final long serialVersionUID = 2838557274790793163L;

	public TMDBStillImageNotContains() {
		super();
	}

	public TMDBStillImageNotContains(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TMDBStillImageNotContains(String message) {
		super(message);
	}

}
