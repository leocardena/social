package com.social.util;

public enum Access {

	PRIVATE("Private"), PUBLIC("Public");

	private String valor;

	private Access(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
