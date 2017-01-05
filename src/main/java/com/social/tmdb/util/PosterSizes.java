package com.social.tmdb.util;

/**
 * Enum que representa os tamanhos válidos para o tipo de imagem Poster
 * 
 * @author Leonardo Cardena
 *
 */
public enum PosterSizes {
	
    W92("w92"),
    W154("w154"),
    W185("w185"),
    W300("w300"),
    W342("w342"),
    W500("w500"),
    W780("w780"),
    ORIGINAL("original");

	private String valor;

	PosterSizes(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
