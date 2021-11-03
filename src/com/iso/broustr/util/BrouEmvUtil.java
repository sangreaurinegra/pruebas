package com.iso.broustr.util;

import com.util.StringUtilities;

public class BrouEmvUtil {
	
	// Las versiones mas rapidas que encontre por internet y sin dependencias de libs 
	
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars);
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
	
	//primero en pos 1 , lugar mas significativo del mapa de bits de 16 bits
	public static int setPosInBitMap(int pos, String valor, int bitmap) {
		
		if (valor == null || valor.trim().equals("")) {
			// no seteo el mapa de bits
		} else {
			// identifico potencia correpondiente
			int pot = 17 - pos;
			bitmap = bitmap | 2 ^ pot; // realizo un or bit a bit con el bitmap para asignarle la posicion
		}
		return bitmap;
		
	}
	
	
	public static String getBitmap(int bitmap, int largo) {
		return StringUtilities.padLeft(Integer.toHexString(bitmap), largo, '0');
	}
	
	
	public static void main(String[] args) {
		
		String dosByte = "FFFF";

		byte[] elArrayDeByte = hexStringToByteArray(dosByte);
		
		String elString = bytesToHex(elArrayDeByte);
		
		System.out.println(dosByte);
		
		System.out.println(elString);
		

	}
	
}
