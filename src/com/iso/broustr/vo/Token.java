package com.iso.broustr.vo;

import com.util.StringUtilities;

public class Token extends AbstractToken {
	
//	Token 
//	Cada token es identificado dentro del mensaje por medio de un identificador o nombre, su largo (debe ser siempre par) y la estructura de datos o diseño de registro asociado al mismo. 
//
//	Campo			Largo	Descripción 
//	Tkn-Header    
//		Eye Catcher 	2 		Es el literal “! ” que Indica el inicio de la información de la estructura 
//	 
//		Tkn-Id 			2 		Nombre o identificador único de la estructura de datos 
//	 
//		Tkn-Lgth 		5 		Indica el largo de la estructura en particular sin incluir el TknHeader 
//		User-fld 		1 		Blanco 
//	Tkn-Data  1..n Diseño de registro asignado a la estructura 
//
//	Ejemplo
//	Eye Catcher		Tkn-Id		Tkn-Lgth		User-fld		Tkn-Data
//	"! "			13			30				" "				3123134651123...
//	
	
	private static final String TOKEN_FLD = " ";
	
	private static final String TOKEN_EYE_CATCHER = "! ";

	String id;
	
	String data ;

	public Token(String id, String data) {
		super(TOKEN_EYE_CATCHER,data.length());
		this.id = id;
		this.data = data;
		this.length = data.length(); // lasrgo del token sin incluir el header del token en cuestion 
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.length = data.length(); // lasrgo del token sin incluir el header del token en cuestion 
		this.data = data;
	}

	@Override
	public String toString() {
		return TOKEN_EYE_CATCHER + StringUtilities.padLeft(id, 2, '0')
				+ StringUtilities.padLeft("" + this.length, 5, '0') + TOKEN_FLD + data;
	}
	
	public int getTotalTokenLength(){
		return TOKEN_EYE_CATCHER.length()+2+5+TOKEN_FLD.length()+this.length;
	}
	
}
