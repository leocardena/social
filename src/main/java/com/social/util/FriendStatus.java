package com.social.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Enum que representa o tipo de relação entre usuários
 * 
 * @author Leonardo Cardena
 *
 */
@JsonDeserialize(using = FriendStatusDeserializer.class)
public enum FriendStatus {

	ACCEPT("Accept"), REFUSED("Refused"), WAITING("Waiting"), NONE("None");

	private String valor;

	private FriendStatus(String valor) {
		this.valor = valor;
	}

	@JsonCreator
	public static FriendStatus create(String value) {
		for (FriendStatus r : FriendStatus.values()) {
			if (r.getText().equalsIgnoreCase(value)) {
				return r;
			}
		}
		throw new IllegalArgumentException();
	}

	@Override
	public String toString() {
		return valor;
	}

	public String getText() {
		return this.valor;
	}

}
