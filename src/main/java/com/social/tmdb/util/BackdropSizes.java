package com.social.tmdb.util;

/**
 * Enum que representa os tamanhos válidos para o tipo de imagem Backdrop
 * 
 * @author Leonardo Cardena
 *
 */
public enum BackdropSizes {

	W300("w300"), 
	W780("w780"), 
	W1280("w1280"), 
	ORIGINAL("original");

	private String valor;

	BackdropSizes(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
