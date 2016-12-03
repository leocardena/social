package com.social.tmdb.util;

/**
 * Enum que represnta a url base para requisitar os serviços da API do TMDB
 * 
 * @author Leonardo Cardena
 *
 */
public enum TmdbBaseUrl {

	URL("https://api.themoviedb.org/3/");

	private String valor;

	TmdbBaseUrl(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
