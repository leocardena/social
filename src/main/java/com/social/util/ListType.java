package com.social.util;

/**
 * Enum que representa os tipos lista
 * 
 * @author Leonardo Cardena
 *
 */
public enum ListType {

	WHATCHLIST("whatchList"), 
	WHATCHED("whatched"),
	CUSTOM("custom"),
	WHATCHING("watching");

	private String valor;

	private ListType(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}
	
}
