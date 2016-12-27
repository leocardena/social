package com.social.trakt.util;

/**
 * Enum que representa a key para requisitar os serviços da API do Trakt.tv
 * 
 * @author Leonardo Cardena
 *
 */
public enum TraktAPIKey {
	
	KEY("");
	
	private String valor;
	
	TraktAPIKey ( String valor ) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}
	
}
