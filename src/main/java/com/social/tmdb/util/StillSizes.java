package com.social.tmdb.util;

public enum StillSizes {
	
    W92("w92"),
    W185("w185"),
    W300("w300"),
    ORIGINAL("original");

	private String valor;

	StillSizes(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
