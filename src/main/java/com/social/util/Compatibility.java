package com.social.util;

public class Compatibility {

	public static String getCompatibility(int value){	
		
		String compatibility;
		
		switch (value) {
		case 0:
			compatibility = "Nenhuma";
			break;
		case 1: case 2: case 3:
			compatibility = "Baixa";
			break;
		case 4: case 5: case 6:
			compatibility = "Boa";
			break;
		case 7: case 8: case 9:
			compatibility = "Ótima";
			break;
		case 10: case 11: case 12:
			compatibility = "Super";
			break;
		default:
			compatibility = "Heróica";
			break;
		}
		
		return compatibility;
		
	}
	
}
