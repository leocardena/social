package com.social.util;

/**
 * Classe utilitária responsável por localizar se o tamanho da imagem requerida encontra-se disponível
 * 
 * @author Leonardo Cardena
 *
 */
public class ContainsEnum {

	public static boolean contains(Class<? extends Enum<?>> clazz, String val) {
		Object[] arr = clazz.getEnumConstants();
		for (Object e : arr) {
			if (((Enum<?>) e).name().equals(val)) {
				return true;
			}
		}
		return false;
	}
}
