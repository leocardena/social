package com.social.tmdb.exception;

public class TMDBImageNotFound extends RuntimeException {

	private static final long serialVersionUID = 2838557274790793163L;

	public TMDBImageNotFound() {
		super();
	}

	public TMDBImageNotFound(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TMDBImageNotFound(String message) {
		super(message);
	}

}
