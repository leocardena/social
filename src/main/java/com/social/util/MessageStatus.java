package com.social.util;

/**
 * Enum que representa o estado de uma mensagem
 * 
 * @author Leonardo Cardena
 *
 */
public enum MessageStatus {
	
	UNREAD("Unread"), 
	READ("Read"),
	DELETED("Deleted");

	private String valor;

	private MessageStatus(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
