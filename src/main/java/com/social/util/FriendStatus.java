package com.social.util;

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
