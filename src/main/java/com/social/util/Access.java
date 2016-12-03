package com.social.util;

/**
 * Enum que representa os tipos de acesso de uma lista
 * 
 * @author Leonardo Cardena
 *
 */
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
