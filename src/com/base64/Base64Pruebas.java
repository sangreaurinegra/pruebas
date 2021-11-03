package com.base64;


public class Base64Pruebas {

	public static void main(String[] args) {

		String enBase64 = "RnTv+tbqLWTr/VWUmOOH5w==";
		
		String enClaro = new String(com.crypto.Base64.decode(enBase64));
		
		
		
		System.out.println(enClaro);
		
	}

}
