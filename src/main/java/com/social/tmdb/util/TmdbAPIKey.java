package com.social.tmdb.util;

public enum TmdbAPIKey {
	
	KEY("");
	
	private String valor;
	
	TmdbAPIKey ( String valor ) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}
	
}
