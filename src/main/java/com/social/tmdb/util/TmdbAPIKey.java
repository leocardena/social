package com.social.tmdb.util;

/**
 * Enum responsável por guardar a chave do desenvolvedor para que sejam
 * realizadas requisições à API do TMDB
 * 
 * @author Cardena
 *
 */
public enum TmdbAPIKey {

	KEY("");

	private String valor;

	TmdbAPIKey(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
