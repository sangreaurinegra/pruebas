package com.bite;

public class PruebaByteSet {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		
//		 byte[] b = hexStringToByteArray("00110011323632323639393036"); 
//		
//		 ISOBinaryField value = (ISOBinaryField) b ;

	}

	
	/* s must be an even-length string. */
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
}
