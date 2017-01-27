package com.social.trakt.util;

/**
 * Enum que representa a url base da api do Trakt.tv
 * 
 * @author Leonardo Cardena
 *
 */
public enum TraktBaseUrl {

	URL("https://api.trakt.tv");
	
	private String valor;

	TraktBaseUrl ( String valor ) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
