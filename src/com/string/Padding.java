package com.string;

import com.util.StringUtilities;

public class Padding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String idTx="1234567890";
		System.out.println(StringUtilities.padLeft(idTx, 6, '0'));
		
		idTx="123";
		System.out.println(StringUtilities.padLeft(idTx, 6, '0'));
		
	}

}
