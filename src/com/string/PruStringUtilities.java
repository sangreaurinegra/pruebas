package com.string;


public class PruStringUtilities {

	public static void main(String[] args) {
		
		System.out.println(ofusca9(null));
		System.out.println(ofusca9(""));
		System.out.println(ofusca9("menos"));
		System.out.println(ofusca9("nueve1234"));
		System.out.println(ofusca9("diez123456"));
		System.out.println(ofusca9("muchosmasquenueve"));
		System.out.println(ofusca9("muchosmasquenueve3213212332132132132121332121332132121321132321322121332121332132121"));
		
	}

	/**
	 * @param fieldValue
	 * @return
	 */
	private static String ofusca9(String fieldValue) {
		String nroTarjetaOfuscado = "";
		if(fieldValue!=null){
			int length = fieldValue.length();
			if (length < 9) length = 9;
//			String firstSix = StringUtilities.getMostLeft(fieldValue, 6);
//			String lastThree = StringUtilities.getMostRight(fieldValue, 3);
//			nroTarjetaOfuscado = firstSix+StringUtilities.padLeft("", (length - 9), '*')+lastThree;
		}
		return nroTarjetaOfuscado;
	}
	
}
