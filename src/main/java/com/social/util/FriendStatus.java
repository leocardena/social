package com.social.util;

/**
 * Enum que representa o tipo de relação entre usuários
 * 
 * @author Leonardo Cardena
 *
 */
public enum FriendStatus {
	
	ACCEPT("Accept"), 
	REFUSED("Refused"),
	WAITING("Waiting");

	private String valor;

	private FriendStatus(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}
	
}
