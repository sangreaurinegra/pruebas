package com.bite;

import javax.xml.bind.DatatypeConverter;



public class Byte {

	public static String toHexString(byte[] array) {
	    return DatatypeConverter.printHexBinary(array);
	}

	public static byte[] toByteArray(String s) {
	    return DatatypeConverter.parseHexBinary(s);
	}
	
//	/* s must be an even-length string. */
//	public static byte[] hexStringToByteArray(String s) {
//	    int len = s.length();
//	    byte[] data = new byte[len / 2];
//	    for (int i = 0; i < len; i += 2) {
//	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
//	                             + Character.digit(s.charAt(i+1), 16));
//	    }
//	    return data;
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str8byteEn16Hex = "E131C8DB9D2C76E6"; 
		System.out.println(str8byteEn16Hex);
		
		byte[] arrByte8 = toByteArray(str8byteEn16Hex);
		
		System.out.println(arrByte8);
		
		System.out.println(toHexString(arrByte8));
		
		
		String str2Hex = "63";
		
		short num = 99 ;
		
		String hex = Integer.toHexString(num & 0xffff);
		String hex2 = Integer.toHexString(num);
		
		System.out.println(hex);
		System.out.println(hex2);
		
		
		
		byte elByte = toByteArray(str2Hex)[0];
		System.out.println(elByte);
		
		byte[] arByte = {elByte}; 
		
		System.out.println(toHexString(arByte));
	}

}
