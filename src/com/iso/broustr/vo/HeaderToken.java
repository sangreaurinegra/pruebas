package com.iso.broustr.vo;

import com.util.StringUtilities;

public class HeaderToken extends AbstractToken {
	
//	Header_token
//	Contiene información general sobre todos los tokens informados en el campo. 
//
//	Campo			Largo	Descripción 
//	Eye Catcher		2		Es el literal “& ” que indica el inicio del área de tokens 
//	Count 			5		Indica la cantidad de tokens informados en el campo 
//	Length			5		Indica el largo total de los datos informados en el campo e incluye el largo de este header 
//
//
//	Ejemplo
//
//	Eye_Catcher	Count	Length
//		"& "	  02	  30	
	
	private static final int LARGO_HEADER = 12 ;

	int count;
	
	public HeaderToken(String eyeCatcher) {
		super(eyeCatcher,LARGO_HEADER);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int addLength(int addC){
		this.count += addC ;
		return this.count ;
	}

	@Override
	public String toString() {

		return eyeCatcher + StringUtilities.padLeft(this.count, 5, '0')
				+ StringUtilities.padLeft("" + this.length, 5, '0');

	}
	
	
}
