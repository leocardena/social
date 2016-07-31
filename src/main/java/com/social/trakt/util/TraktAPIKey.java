package com.social.trakt.util;

public enum TraktAPIKey {
	
	KEY("XXXXXXX");
	
	String valor;
	
	TraktAPIKey ( String valor ) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}
	
}
