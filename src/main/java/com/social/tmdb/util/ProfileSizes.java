package com.social.tmdb.util;

public enum ProfileSizes {
	
	W45("w45"),
    W185("w185"),
    H632("h632"),
    ORIGINAL("original");

	private String valor;

	ProfileSizes(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
