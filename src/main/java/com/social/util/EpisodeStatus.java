package com.social.util;

/**
 * Enum que representa os estados de um episódio de uma série
 * 
 * @author Leonardo Cardena
 *
 */
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
