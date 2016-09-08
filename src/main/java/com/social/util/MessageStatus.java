package com.social.util;

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
