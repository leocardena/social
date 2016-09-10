package com.social.trakt.util;

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
