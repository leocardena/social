package com.social.tmdb.exception;

public class TMDBPosterImageNotContains extends RuntimeException {

	private static final long serialVersionUID = 2838557274790793163L;

	public TMDBPosterImageNotContains() {
		super();
	}

	public TMDBPosterImageNotContains(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TMDBPosterImageNotContains(String message) {
		super(message);
	}

}
