package com.iso;

import javax.xml.bind.DatatypeConverter;

public class PruHexa {


	//<field id="52" value="A286795254767AD6" type="binary"/>

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String str16 = "A286795254767AD6";
//		
//		byte[] bite = DatatypeConverter.parseHexBinary(str16);
//		
//		System.out.println("");
//		
//		System.out.println(bite);
		
		
		byte bytes[] = {(byte)0, (byte)0, (byte)134, (byte)0, (byte)61};
		System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(bytes));
		
		
		// 002000214147454E4349413A20393939202F20393939000900236C696E65612033000900226C696E65612032000900246C696E65612034001600263230313530373133313230313335
		int bitmap = 256 | 1 ;
		System.out.println(bitmap);
		
		System.out.println(Integer.toHexString(bitmap));
		
		bitmap = 15 ;
		System.out.println(Integer.toHexString(bitmap));
	}

	
	
	
}
