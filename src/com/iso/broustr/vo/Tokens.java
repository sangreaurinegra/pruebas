package com.iso.broustr.vo;

import java.util.ArrayList;
import java.util.List;

public class Tokens {
	
	
	
//	Formato
//
//	Campo	Descripci�n						Tipo		Largo M�ximo 
//	126		Operaciones en Terminales ATM	Variable	999 bytes 
//
//
//
//	Header_token	token	token	...
//
//
//	Header_token
//	Contiene informaci�n general sobre todos los tokens informados en el campo. 
//
//	Campo			Largo	Descripci�n 
//	Eye Catcher		2		Es el literal �& � que indica el inicio del �rea de tokens 
//	Count 			5		Indica la cantidad de tokens informados en el campo 
//	Length			5		Indica el largo total de los datos informados en el campo e incluye el largo de este header 
//
//
//	Ejemplo
//
//	Eye_Catcher	Count	Length
//		"& "	  02	  30		
//
//
//	Token 
//	Cada token es identificado dentro del mensaje por medio de un identificador o nombre, su largo (debe ser siempre par) y la estructura de datos o dise�o de registro asociado al mismo. 
//
//	Campo			Largo	Descripci�n 
//	Tkn-Header    
//		Eye Catcher 	2 		Es el literal �! � que Indica el inicio de la informaci�n de la estructura 
//	 
//		Tkn-Id 			2 		Nombre o identificador �nico de la estructura de datos 
//	 
//		Tkn-Lgth 		5 		Indica el largo de la estructura en particular sin incluir el TknHeader 
//		User-fld 		1 		Blanco 
//	Tkn-Data  1..n Dise�o de registro asignado a la estructura 
//
//	Ejemplo
//	Eye Catcher		Tkn-Id		Tkn-Lgth		User-fld		Tkn-Data
//	"! "			13			30				" "				3123134651123...

	private static final String HEADER_EYE_CATCHER = "& ";
	
	private static final String HEADER_FLD = " ";
	
	HeaderToken header ;
	
	List<Token> tokens ;
	
	String fld ;

	public Tokens() {
		super();
		this.header = new HeaderToken(HEADER_EYE_CATCHER);
		this.tokens = new ArrayList<Token>();
		this.fld = HEADER_FLD;
	}

	public void addToken(String id, String data){
		Token token = new Token(id, data);
		header.addLength(token.getTotalTokenLength());
		tokens.add(token);
	}

	
	
	@Override
	public String toString() {
		String ret = "Tokens [header=" + header + ", tokens=" + tokens + ", fld=" + fld + "]";
		return ret ;
		
	}

	public String toFormat() {
		
		String ret = "";
		
		ret += header.toString();
		
		for (Token token : tokens) {
			ret += token.toString();
		}
		
		return ret;
		
	}

	
}
