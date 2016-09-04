package com.social.domain;

public enum EpisodeStatus {
	
	UNWATCHED("Unwatched"), 
	WHATCHED("Whatched");

	private String valor;

	private EpisodeStatus(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
