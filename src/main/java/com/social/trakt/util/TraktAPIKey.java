package com.social.trakt.util;

public enum TraktAPIKey {
	
	KEY("50134a433b58ae1ff4377710c370528c4abdbf2e1c303fc74b21d743238235c6");
	
	private String valor;
	
	TraktAPIKey ( String valor ) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}
	
}
