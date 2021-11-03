package com.string;

import com.util.StringUtilities;

public class LengthTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] array = {12,1,4};
//		String string = "Hoo";
//		System.out.println(array.length);
//		System.out.println(string.length());
		
		
		
//        String importeTx = "12345678";
//        importeTx = StringUtilities.padLeft(importeTx, 8, '0');
//        String importe = importeTx.substring(importeTx.length() - 8);
//        System.out.println(importe);
//        System.out.println(importe.length());
//        System.out.println(importeTx);
//        System.out.println(importeTx.length());
		
		String nom = "GEOCOM030017";
		String strNro = nom.substring(12);
		System.out.println(nom);
		System.out.println(strNro);
		int nro = Integer.valueOf(strNro);
		System.out.println(nro);
       

	}
}