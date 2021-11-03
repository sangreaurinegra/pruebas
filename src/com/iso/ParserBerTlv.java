package com.iso;

import java.util.Enumeration;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOUtil;
import org.jpos.tlv.TLVList;
import org.jpos.tlv.TLVMsg;

import com.iso.broustr.vo.Tokens;

public class ParserBerTlv {

	public static void main(String[] args) {
		
		try {
		
			TLVList list = new TLVList();

			//String fieldValue = "9F3303E02080950500000000009F3704A5CC06CF9F100706010A03A0B0009F26080562599501ED00039F3602010C82025C009F3704A5CC06CF9F3704A5CC06CF9F3704A5CC06CF9F02060000000010005F2A0208409F0306000000000000";

			String fieldValue = "9F270180950580809080009F260884BE778FB60EBB5982021C009F360200689C01009F3704DE5621219F100706010A03A098009F3303E040C89F3303E040C89F3501129F0902008C9F34030203014F07A00000000310105F3401009F1A0208589A032009095F2A0208589F02060000001500009F0306000000000000";
			
			list.unpack(ISOUtil.hex2byte(fieldValue));

			
			@SuppressWarnings("unchecked")
			Enumeration<TLVMsg> elemento = list.elements();
			
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
			
			Tokens tokens = new Tokens();
			
			elemento = list.elements();
			while (elemento.hasMoreElements()) {
				TLVMsg tlvMsg = elemento.nextElement();
				tokens.addToken(Integer.toHexString(tlvMsg.getTag()), javax.xml.bind.DatatypeConverter.printHexBinary(tlvMsg.getValue()));
			}
			
			System.out.println(tokens.toString());
			
			
			
		
			
		} catch (ISOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //list.dump(System.out, "");

	}

	

	
}
