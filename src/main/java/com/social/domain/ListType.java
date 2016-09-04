package com.social.domain;

public enum ListType {

	WHATCHLIST("WhatchList"), 
	WHATCHED("Whatched"),
	CUSTOM("Custom"),
	WHATCHING("Watching");

	private String valor;

	private ListType(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}
	
}
