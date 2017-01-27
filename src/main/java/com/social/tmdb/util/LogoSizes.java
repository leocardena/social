package com.social.tmdb.util;

/**
 * Enum que representa os tamanhos válidos para o tipo de imagem Logo
 * 
 * @author Leonardo Cardena
 *
 */
public enum LogoSizes {
	
	W45("w45"),
    W92("w92"),
    W154("w154"),
    W185("w185"),
    W300("w300"),
    W500("w500"),
    ORIGINAL("original");

	private String valor;

	LogoSizes(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
