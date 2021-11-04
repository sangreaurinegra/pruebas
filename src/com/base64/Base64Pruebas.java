package com.base64;

import java.util.Base64;

public class Base64Pruebas {

	public static void main(String[] args) {

		String enBase64 = "RnTv+tbqLWTr/VWUmOOH5w==";
		
		String enClaro = new String(Base64.getDecoder().decode(enBase64)); // TODO Verificar
		
		
		
		System.out.println(enClaro);
		
	}

}
