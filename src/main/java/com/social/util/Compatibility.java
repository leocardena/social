package com.social.util;

import org.apache.commons.lang3.StringUtils;

public enum Compatibility {
		
	NENHUMA(0),BAIXA(3),BOA(6),OTIMA(9),SUPER(12),HEROICA(13);
		
	private int value;
	
	private Compatibility(int value) {
		this.value = value;
	}

	public static String getCompatibility(int note){
		Compatibility encontrada = NENHUMA;
		for(Compatibility c : values()){
			if(c.value <= note){
				encontrada = c;
			}
		}
		return StringUtils.capitalize(encontrada.name().toLowerCase());
	}
	
}
