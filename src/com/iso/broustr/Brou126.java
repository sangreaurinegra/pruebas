package com.iso.broustr;

import java.util.Enumeration;
import java.util.HashMap;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOUtil;
import org.jpos.tlv.TLVList;
import org.jpos.tlv.TLVMsg;

import com.iso.broustr.emv.B2EMVRequestDataToken;
import com.iso.broustr.emv.B3EMVDiscretionaryDataToken;
import com.iso.broustr.emv.B4EMVStatusToken;
import com.iso.broustr.vo.Tokens;

public class Brou126 {

	
	
//	Formato
//
//	Campo	Descripción						Tipo		Largo Máximo 
//	126		Operaciones en Terminales ATM	Variable	999 bytes 
//
//
//
//	Header_token	token	token	...
//
//
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
//
//
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

	// Bert Tlv se carga del campo 63 en un subcampo indicado por Geocom
	@SuppressWarnings("unchecked")
	public static String campo126(String bertTlv){
		String ret = "";

		try {
			TLVList tlvList = new TLVList();

			//String bertTlv = "9F270180950580809080009F260884BE778FB60EBB5982021C009F360200689C01009F3704DE5621219F100706010A03A098009F3303E040C89F3303E040C89F3501129F0902008C9F34030203014F07A00000000310105F3401009F1A0208589A032009095F2A0208589F02060000001500009F0306000000000000";

			tlvList.unpack(ISOUtil.hex2byte(bertTlv));


			Enumeration<TLVMsg> listaTlv = tlvList.elements();

//			imprimirBerTlv(listaTlv); //TODO ver de loguear en debug
			
			HashMap<String, TLVMsg> hashTlv = crearHashTLVMsg(listaTlv);

			Tokens tokens = new Tokens();
			
			System.out.println("Seteando B2");
			//Token B2
			B2EMVRequestDataToken b2 = new B2EMVRequestDataToken();
			b2.setBertTlvHash(hashTlv);
			tokens.addToken("B2", b2.toStrFormat());
			
			System.out.println(b2);
			System.out.println();
			
			
			System.out.println("Seteando B3");
			//Token B3
			B3EMVDiscretionaryDataToken b3 = new B3EMVDiscretionaryDataToken();
			b3.setBertTlvHash(hashTlv);
			tokens.addToken("B3", b3.toStrFormat());
			
			System.out.println(b3);
			System.out.println();
			
			System.out.println("Seteando B4");
			//Token B4
			B4EMVStatusToken b4 = new B4EMVStatusToken();
			b4.setBertTlvHash(hashTlv);
			tokens.addToken("B4", b4.toStrFormat());
			
			System.out.println(b4);
			System.out.println();

//			elemento = tlvList.elements();
//			
//			while (elemento.hasMoreElements()) {
//				TLVMsg tlvMsg = elemento.nextElement();
//				tokens.addToken(Integer.toHexString(tlvMsg.getTag()), javax.xml.bind.DatatypeConverter.printHexBinary(tlvMsg.getValue()));
//			}

			 imprimirTokens(tokens); //TODO ver de loguear en debug
			 
			 ret = tokens.toFormat();

		} catch (ISOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	

//	TODO
//	public static String bertTlv(String campo126) {
//		
//		
//	}
	
	
	private static void imprimirTokens(Tokens tokens) {
		
		System.out.println(tokens.toString());
	}
	
	/**
	 * @param elemento
	 */
	private static void imprimirBerTlv(Enumeration<TLVMsg> elemento) {
		while (elemento.hasMoreElements()) {
			TLVMsg tlvMsg = elemento.nextElement();
			//System.out.println(tlvMsg.getTag() + " " + tlvMsg.getValue());
			
			System.out.println("TLV " + javax.xml.bind.DatatypeConverter.printHexBinary(tlvMsg.getTLV()));
			
			System.out.print(Integer.toHexString(tlvMsg.getTag()));
			System.out.print("  ");
			System.out.print(javax.xml.bind.DatatypeConverter.printHexBinary(tlvMsg.getL()));
			System.out.print("  ");
			System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(tlvMsg.getValue()));
			
			
			System.out.println("T " + Integer.toHexString(tlvMsg.getTag()));
			System.out.print("L " + javax.xml.bind.DatatypeConverter.printHexBinary(tlvMsg.getL()));
			System.out.println("V " + javax.xml.bind.DatatypeConverter.printHexBinary(tlvMsg.getValue()));
			System.out.println();
			
		}
	}
	
	private static HashMap<String, TLVMsg> crearHashTLVMsg(Enumeration<TLVMsg> listaTlv){
		
		HashMap<String, TLVMsg> ret = new HashMap<String, TLVMsg>();
		
		while (listaTlv.hasMoreElements()) {
			TLVMsg tlvMsg = listaTlv.nextElement();
			
			System.out.println("crearHashTLVMsg tlvMsg.getTag() "+tlvMsg.getTag());
			
			String tag = Integer.toHexString(tlvMsg.getTag()).toUpperCase();
			
			System.out.println("crearHashTLVMsg tag "+tag);
			
			ret.put(tag, tlvMsg);
			
		}
		return ret;
	}
	
	public static void main(String[] args) {
		
		String bertTlv = "9F270180950580809080009F260884BE778FB60EBB5982021C009F360200689C01009F3704DE5621219F100706010A03A098009F3303E040C89F3303E040C89F3501129F0902008C9F34030203014F07A00000000310105F3401009F1A0208589A032009095F2A0208589F02060000001500009F0306000000000000";
		
		String campo126 = campo126(bertTlv);
		
		System.out.println("campo126");
		System.out.println(campo126);
		
	}
	
	

}
