package com.string;


public class PaddingStr {
	
	protected static String padLeftChar(String entrada, Integer largo, char fill) {
		String ret = "";
		if (largo != null && largo > 0){
			if (entrada == null) entrada = "";
			if (entrada.length() < largo){
//				ret = StringUtilities.padLeft(entrada , largo, fill);
			}else{
				ret = entrada.substring(0, largo);
			}
		}
		return ret ;
	}

	protected static String padRightChar(String entrada, Integer largo, char fill) {
		String ret = "";
		if (largo != null && largo > 0){
			if (entrada == null) entrada = "";
			if (entrada.length() < largo){
//				ret = StringUtilities.padRight(entrada , largo, fill);
			}else{
				ret = entrada.substring(0, largo);
			}
		}
		return ret ;
	}
	
	public static void main(String[] args) {
		
		System.out.print("|");
		System.out.print(padRightChar("123", 14, ' '));
		System.out.println("|");
	}
}
