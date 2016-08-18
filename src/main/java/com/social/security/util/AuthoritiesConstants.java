package com.social.security.util;

public enum AuthoritiesConstants {

	ADMIN("ROLE_ADMIN"), 
	USER("ROLE_USER"),
	ANONYMOUS("ROLE_ANONYMOUS");

	private String valor;

	private AuthoritiesConstants(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
