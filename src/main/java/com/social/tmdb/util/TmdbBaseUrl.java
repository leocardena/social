package com.social.tmdb.util;

public enum TmdbBaseUrl {

	URL("https://api.themoviedb.org/3/");

	private String valor;

	TmdbBaseUrl ( String valor ) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
