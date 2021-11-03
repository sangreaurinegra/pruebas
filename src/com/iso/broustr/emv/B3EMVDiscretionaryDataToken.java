package com.iso.broustr.emv;

import java.util.HashMap;

import javax.xml.bind.DatatypeConverter;

import org.jpos.tlv.TLVMsg;

import com.util.StringUtilities;
import com.iso.broustr.util.BrouEmvUtil;

public class B3EMVDiscretionaryDataToken extends BXEMVDataToken{


	//	Segun Cesar de Brou los tamanios son los del listado y no el de los detalles .
	//	Offset[Len]   Field Name and Description                     Data Type 
	//	 
	//    All fields are ASCII Hexadecimal. 
	//
	//0     [80] 
	//0     [4]     bit^map.byte[0:3]                              PIC X(4). 
	//4     [8]     term^serl^num.byte[0:7]                        PIC X(8). 
	//12    [8]     emv^term^cap.byte[0:7]                         PIC X(8). 
	//20    [4]     user^fld1.byte[0:3]                            PIC X(4). 
	//24    [8]     user^fld2.byte[0:7]                            PIC X(8). 
	//32    [2]     emv^term^type.byte[0:1]                        PIC X(2). 
	//34    [4]     appl^ver^num.byte[0:3]                         PIC X(4). 
	//38    [6]     cvm^rslts.byte[0:5]                            PIC X(6). 
	//44    [4]     df^name^lgth.byte[0:3]                         PIC X(4). 
	//48    [32]    df^name.byte[0:31]                            PIC X(32). 
	//    END   [size    80]  
	//


	//0     [4]     bit^map.byte[0:3]                              PIC X(4).  
	public static final int     BITMAPBYTE_LEN = 4;
	//4     [8]     term^serl^num.byte[0:7]                        PIC X(8).  
	public static final int     TERMSERLNUMBYTE_LEN = 8;
	//12    [8]     emv^term^cap.byte[0:7]                         PIC X(8).  
	public static final int     EMVTERMCAPBYTE_LEN = 8;
	//20    [4]     user^fld1.byte[0:3]                            PIC X(4).  
	public static final int     USERFLD1BYTE_LEN = 4;
	//24    [8]     user^fld2.byte[0:7]                            PIC X(8).  
	public static final int     USERFLD2BYTE_LEN = 8;
	//32    [2]     emv^term^type.byte[0:1]                        PIC X(2).  
	public static final int     EMVTERMTYPEBYTE_LEN = 2;
	//34    [4]     appl^ver^num.byte[0:3]                         PIC X(4).  
	public static final int     APPLVERNUMBYTE_LEN = 4;
	//38    [6]     cvm^rslts.byte[0:5]                            PIC X(6).  
	public static final int     CVMRSLTSBYTE_LEN = 6;
	//44    [4]     df^name^lgth.byte[0:3]                         PIC X(4).  
	public static final int     DFNAMELGTHBYTE_LEN = 4;
	//48    [32]    df^name.byte[0:31]                            PIC X(32).  
	public static final int    DFNAMEBYTE_LEN = 32;


	//0     [4]     bit^map.byte[0:3]                              PIC X(4).
	//  This field is set by the acquiring process to indicate              
	//	 which EMV data elements are present in the EMV 
	//  Discretionary Data Token. 
	//  The token itself is a fixed format structure, so the               
	//	 absence of a data item, as specified in the BIT-MAP,               
	//	 means that the appropriate field will be present but               
	//	 that its contents are undefined. 
	//  Note that the positions of the bits within the BIT-MAP               
	//	 follow the ISO 8583 convention, i.e. the highest order               
	//	 bit represents the first field in the token (following the BIT-MAP).  
	//	 There are 16 bits in the BIT-MAP, but only 8 fields (excluding the BIT-MAP) in the token;
	//	 therefore the lowest order 8 bits in the BIT-MAP are reserved for future use. 
	//
	//   This field is a binary bit map. 
	int     piBitmap;

	//4     [8]     term^serl^num.byte[0:7]                        PIC X(8).
	//   Interface Device (IFD) Number.  Unique and permanent 
	//	 serial number assigned to the terminal by the manufacturer.
	//	 EMV Tag = 9F1E. 
	String     termserlnumbyte;

	//12    [8]     emv^term^cap.byte[0:7]                         PIC X(8). 
	//   EMV Terminal Capabilities.  Indicates the card data               
	//	 input, CVM, and security capabilities of the terminal,               
	//	 as shown below.  Where the bit setting is not specified,               
	//	 a bit setting of '1' indicates the meaning specified,               
	//	 a bit setting of '0' indicates the opposite.  Additions               
	//	 in the defined bits below should also be added to the               
	//	 EMV-TERM-CAP-COBOL Definition. 
	//
	//   Because of the way TAL handles bit operations on string 
	//	 variables, the TAL code references the EMV bits as               
	//	 defined in the column TAL Reference as Implemented.               
	//	 This field is binary.

	String     emvtermcapbyte;


	//20    [4]     user^fld1.byte[0:3]                            PIC X(4).  
	//   This field is reserved for future use. 
	//   This field is binary. 
	String     userfld1byte;


	//24    [8]     user^fld2.byte[0:7]                            PIC X(8). 
	//   This field is reserved for future use. 
	//
	//   This field is binary.
	String     userfld2byte;


	//32    [2]     emv^term^type.byte[0:1]                        PIC X(2).
	//   EMV Terminal Type.  Indicates the environment of the               terminal, its communications capability, and its               operational control, as shown below. 
	//
	//                    Operational Control Provided By: 
	//                     Financial     Merchant    Cardholder               Environment      Institution 
	//   -----------      -----------    --------    ---------- 
	//   Attended 
	//     Online Only         11           21           --                 Offline with        12           22           --                   online 
	//       capability 
	//     Offline only        13           23           -- 
	//
	//   Unattended 
	//     Online Only         14           24           34                 Offline with        15           25           35                   online                   capability 
	//     Offline only        16           26           36 
	//
	//   This field contains two decimal digits per byte. 
	//   EMV Tag = 9F35. 
	String     emvtermtypebyte;


	//34    [4]     appl^ver^num.byte[0:3]                         PIC X(4).  
	//   Application Version Number.  Version number assigned               by the payment system for the terminal application. 
	//
	//   This field is binary.               
	//	 EMV Tag = 9F09. 
	String     applvernumbyte;


	//38    [6]     cvm^rslts.byte[0:5]                            PIC X(6).
	//   Cardholder Verification Method Results.  Indicates the               results of the last CVM performed, as shown below.               Where the bit setting is not specified, a bit setting               of '1' indicates the meaning specified, a bit setting               of '0' indicates the opposite. 
	//   In EMV specifications, definitions which include bit               positions indicate that bit position 8 is the leftmost               bit.  In the tokens, this position is stored in bit               position 0 (leftmost bit). 
	//
	//   Byte 1 (CVM Performed) 
	//     EMV Defined 
	//     Bit 
	//     Position   Meaning 
	//     --------   ------- 
	//        8       Reserved for future use 
	//        7       0 = Fail cardholder verification if this 
	//                    CVM is unsuccessful 
	//                1 = Apply succeeding CVR if this CVM is                                unsuccessful 
	//       6-1      000000 = Fail CVM processing                            000001 = Plaintext PIN verification                                     performed by ICC 
	//                000010 = Enciphered PIN verified online                            000011 = Plaintext PIN verification                                     performed by ICC and                                     signature (paper)                            000100 = Enciphered PIN verification                                     performed by ICC 
	//                000101 = Enciphered PIN verification                                     performed by ICC and                                     signature (paper) 
	//                0xxxxx = Values in the range 000110-011101                                     reserved for future use by this                                     specification                            011110 = Signature (paper) 
	//                011111 = No CVM required 
	//                10xxxx = Values in the range 100000-101111                                     reserved for use by the                                     individual payment systems                            11xxxx = Values in the range 110000-111110                                     reserved for use by the issuer 
	//                111111 = Not available for use 
	//
	//   Byte 2 (CVM Condition) 
	//     Value  Meaning 
	//     -----  ------- 
	//00	Always 
	//01	If cash or cashback 
	//02	If not cash or cashback 
	//03	If terminal supports the CVM 
	//04	Reserved for future use 
	//05	Reserved for future use 
	//06	If transaction is in the application currency                        and is under X value 
	//07	If transaction is in the application currency                        and is over X value 
	//08	If transaction is in the application currency                        and is under Y value 
	//09	If transaction is in the application currency                        and is over Y value 
	//     0A-7F  Reserved for future use 
	//     80-FF  Reserved for future use by individual payment                        systems 
	//
	//   Byte 3 (CVM Result) 
	//   Result of the (last) CVM performed as known by the               terminal. 
	//0	= Unknown (for example, for signature) 
	//1	= Failed (for example, for offline PIN) 
	//2	= Successful (for example, for offline PIN) 
	//
	//   This field is binary.               
	//	 EMV Tag = 9F34. 
	String     cvmrsltsbyte  ;


	//44    [4]     df^name^lgth.byte[0:3]                         PIC X(4).
	//   Dedicated File Name length or Application Identifier               
	//	 length.  Indicates the length of the binary               
	//	 representation of the data in the following field.              
	//	 The ASCII and binary versions of the token must contain               
	//	 the same value in this field. 
	String     dfnamelgthbyte;


	//48    [32]    df^name.byte[0:31]                            PIC X(32). 
	//   Dedicated File Name or Application Identifier. 
	//   Identifies the name of either the DF (as described in               
	//	 ISO/IEC 7816-4) or the application (as described in               
	//			 ISO/IEC 7816-5). 
	//
	//   This field is binary. 
	//EMV Tag = 84 (DF Name) or 4F (AID) or 
	//9F06 (Terminal AID)  
	String    dfnamebyte;


	//
	//DETALLE: 
	//
	//    ###################################################### 
	//    #  EMV Discretionary Data Token (Binary format)      # 
	//    ###################################################### 
	//    Consists of EMV-related data that is not required for               authorization.  However, each data element is               supported by more than one EMV-compliant interface,               and therefore may be mapped between interfaces by               BASE24. 
	//
	//    Token id is B3. 
	//
	//Offset[Len]   Field Name and Description                     Data Type  
	//0     [44] 
	//
	//0     [2]     bit^map                           TYPE BINARY 16 SIGNED. 
	//
	//   This field is set by the acquiring process to indicate              
	//	 which EMV data elements are present in the EMV 
	//   Discretionary Data Token. 
	//   The token itself is a fixed format structure, so the               
	//	 absence of a data item, as specified in the BIT-MAP,               
	//	 means that the appropriate field will be present but               
	//	 that its contents are undefined. 
	//   Note that the positions of the bits within the BIT-MAP               
	//	 follow the ISO 8583 convention, i.e. the highest order               
	//	 bit represents the first field in the token (following the BIT-MAP).  
	//	 There are 16 bits in the BIT-MAP, but only 8 fields (excluding the BIT-MAP) in the token;
	//	 therefore the lowest order 8 bits in the BIT-MAP are reserved for future use. 
	//
	//    This field is a binary bit map. 
	//
	//2     [8]     term^serl^num.byte[0:7]                        PIC X(8). 
	//
	//    Interface Device (IFD) Number.  Unique and permanent 
	//	 serial number assigned to the terminal by the manufacturer.
	//	 EMV Tag = 9F1E. 
	//
	//10    [4]     emv^term^cap     [EMV-TERM-CAP] 
	//
	//    EMV Terminal Capabilities.  Indicates the card data               
	//	 input, CVM, and security capabilities of the terminal,               
	//	 as shown below.  Where the bit setting is not specified,               
	//	 a bit setting of '1' indicates the meaning specified,               
	//	 a bit setting of '0' indicates the opposite.  Additions               
	//	 in the defined bits below should also be added to the               
	//	 EMV-TERM-CAP-COBOL Definition. 
	//
	//    Because of the way TAL handles bit operations on string 
	//	 variables, the TAL code references the EMV bits as               
	//	 defined in the column TAL Reference as Implemented.               
	//	 This field is binary.

	//
	//10	[1]     emv^term^cap.crd^data^input                    PIC X(1). 
	//
	//    Byte 1 (Card Data Input Capability) 
	//      EMV Bit                                 TAL Reference 
	//      Position   Meaning                      as Implemented 
	//      --------   -----------------------      -------------- 
	//         8       Manual key entry                    8 
	//7	Magnetic stripe                     9 
	//         6       IC with contacts                   10 
	//         5       Reserved for future use            11 
	//         4       Reserved for future use            12 
	//         3       Reserved for future use            13 
	//         2       Reserved for future use            14 
	//         1       Reserved for future use            15 
	//
	//11	[1]     emv^term^cap.cvm                               PIC X(1).  
	//    Byte 2 (CVM Capability) 
	//      EMV Bit                                 TAL Reference 
	//      Position   Meaning                      as Implemented 
	//      --------   --------------------------   --------------                    8       Plaintext PIN for ICC               8                              verification 
	//7	Enciphered PIN for online           9                              verification 
	//         6       Signature (paper)                  10                    5       Enciphered PIN for offline         11                              verification 
	//         4       No CVM required                    12 
	//         3       Reserved for future use            13 
	//         2       Reserved for future use            14 
	//         1       Reserved for future use            15 
	//
	//12	[1]     emv^term^cap.sec                               PIC X(1). 
	//
	//    Byte 3 (Security Capability) 
	//      EMV Bit                                TAL Reference 
	//      Position  Meaning                      as Implemented 
	//      --------  ---------------------------  -------------- 
	//         8      Static data authentication          8 
	//7	Dynamic data authentication         9 
	//         6      Card capture                       10 
	//         5      Reserved for future use            11 
	//         4      Combined data authentication       12 
	//         3      Reserved for future use            13 
	//         2      Reserved for future use            14 
	//         1      Reserved for future use            15 
	//
	//13	[1]     emv^term^cap.user^fld1^emv^term^cap            PIC X(1). 
	//
	//    This field ensures word-alignment. 
	//
	//14	[2]     user^fld1.byte[0:1]                            PIC X(2). 
	//
	//    This field is reserved for future use. 
	//
	//    This field is binary. 
	//
	//16    [4]     user^fld2.byte[0:3]                            PIC X(4). 
	//
	//    This field is reserved for future use. 
	//
	//    This field is binary. 
	//
	//20    [1]     emv^term^type                                  PIC X(1). 
	//
	//    EMV Terminal Type.  Indicates the environment of the               terminal, its communications capability, and its               operational control, as shown below. 
	//
	//                     Operational Control Provided By: 
	//                      Financial     Merchant    Cardholder               Environment      Institution 
	//    -----------      -----------    --------    ---------- 
	//    Attended 
	//      Online Only         11           21           --                 Offline with        12           22           --                   online 
	//        capability 
	//      Offline only        13           23           -- 
	//
	//    Unattended 
	//      Online Only         14           24           34                 Offline with        15           25           35                   online                   capability 
	//      Offline only        16           26           36 
	//
	//    This field contains two decimal digits per byte. 
	//    EMV Tag = 9F35. 
	//
	//21    [2]     appl^ver^num.byte[0:1]                         PIC X(2). 
	//
	//    Application Version Number.  Version number assigned               by the payment system for the terminal application. 
	//
	//    This field is binary.               EMV Tag = 9F09. 
	//
	//23    [3]     cvm^rslts.byte[0:2]                            PIC X(3). 
	//
	//    Cardholder Verification Method Results.  Indicates the               results of the last CVM performed, as shown below.               Where the bit setting is not specified, a bit setting               of '1' indicates the meaning specified, a bit setting               of '0' indicates the opposite. 
	//    In EMV specifications, definitions which include bit               positions indicate that bit position 8 is the leftmost               bit.  In the tokens, this position is stored in bit               position 0 (leftmost bit). 
	//
	//    Byte 1 (CVM Performed) 
	//      EMV Defined 
	//      Bit 
	//      Position   Meaning 
	//      --------   ------- 
	//         8       Reserved for future use 
	//         7       0 = Fail cardholder verification if this 
	//                     CVM is unsuccessful 
	//                 1 = Apply succeeding CVR if this CVM is                                unsuccessful 
	//        6-1      000000 = Fail CVM processing                            000001 = Plaintext PIN verification                                     performed by ICC 
	//                 000010 = Enciphered PIN verified online                            000011 = Plaintext PIN verification                                     performed by ICC and                                     signature (paper)                            000100 = Enciphered PIN verification                                     performed by ICC 
	//                 000101 = Enciphered PIN verification                                     performed by ICC and                                     signature (paper) 
	//                 0xxxxx = Values in the range 000110-011101                                     reserved for future use by this                                     specification                            011110 = Signature (paper) 
	//                 011111 = No CVM required 
	//                 10xxxx = Values in the range 100000-101111                                     reserved for use by the                                     individual payment systems                            11xxxx = Values in the range 110000-111110                                     reserved for use by the issuer 
	//                 111111 = Not available for use 
	//
	//    Byte 2 (CVM Condition) 
	//      Value  Meaning 
	//      -----  ------- 
	//00	Always 
	//01	If cash or cashback 
	//02	If not cash or cashback 
	//03	If terminal supports the CVM 
	//04	Reserved for future use 
	//05	Reserved for future use 
	//06	If transaction is in the application currency                        and is under X value 
	//07	If transaction is in the application currency                        and is over X value 
	//08	If transaction is in the application currency                        and is under Y value 
	//09	If transaction is in the application currency                        and is over Y value 
	//      0A-7F  Reserved for future use 
	//      80-FF  Reserved for future use by individual payment                        systems 
	//
	//    Byte 3 (CVM Result) 
	//    Result of the (last) CVM performed as known by the               terminal. 
	//0	= Unknown (for example, for signature) 
	//1	= Failed (for example, for offline PIN) 
	//2	= Successful (for example, for offline PIN) 
	//
	//    This field is binary.               EMV Tag = 9F34. 
	//
	//26    [2]     df^name^lgth                      TYPE BINARY 16 SIGNED. 
	//
	//    Dedicated File Name length or Application Identifier               
	//	 length.  Indicates the length of the binary               
	//	 representation of the data in the following field.              
	//	 The ASCII and binary versions of the token must contain               
	//	 the same value in this field. 
	//
	//28    [16]    df^name.byte[0:15]                            PIC X(16). 
	//
	//    Dedicated File Name or Application Identifier. 
	//    Identifies the name of either the DF (as described in               
	//	 ISO/IEC 7816-4) or the application (as described in               
	//			 ISO/IEC 7816-5). 
	//
	//    This field is binary. 
	//EMV Tag = 84 (DF Name) or 4F (AID) or 
	//9F06 (Terminal AID)  
	//    END   [size    44]  
	//
	//	
	
	
	public String getTermserlnumbyte() {
		return termserlnumbyte;
	}
	public void setTermserlnumbyte(String termserlnumbyte) {
		BrouEmvUtil.setPosInBitMap(1, termserlnumbyte, piBitmap);
		this.termserlnumbyte = termserlnumbyte;
	}
	public String getEmvtermcapbyte() {
		return emvtermcapbyte;
	}
	public void setEmvtermcapbyte(String emvtermcapbyte) {
		BrouEmvUtil.setPosInBitMap(2, emvtermcapbyte, piBitmap);
		this.emvtermcapbyte = emvtermcapbyte;
	}
	public String getUserfld1byte() {
		return userfld1byte;
	}
	public void setUserfld1byte(String userfld1byte) {
		BrouEmvUtil.setPosInBitMap(3, userfld1byte, piBitmap);
		this.userfld1byte = userfld1byte;
	}
	public String getUserfld2byte() {
		return userfld2byte;
	}
	public void setUserfld2byte(String userfld2byte) {
		BrouEmvUtil.setPosInBitMap(4, userfld2byte, piBitmap);
		this.userfld2byte = userfld2byte;
	}
	public String getEmvtermtypebyte() {
		return emvtermtypebyte;
	}
	public void setEmvtermtypebyte(String emvtermtypebyte) {
		BrouEmvUtil.setPosInBitMap(5, emvtermtypebyte, piBitmap);
		this.emvtermtypebyte = emvtermtypebyte;
	}
	public String getApplvernumbyte() {
		return applvernumbyte;
	}
	public void setApplvernumbyte(String applvernumbyte) {
		BrouEmvUtil.setPosInBitMap(6, applvernumbyte, piBitmap);
		this.applvernumbyte = applvernumbyte;
	}
	public String getCvmrsltsbyte() {
		return cvmrsltsbyte;
	}
	public void setCvmrsltsbyte(String cvmrsltsbyte) {
		BrouEmvUtil.setPosInBitMap(7, cvmrsltsbyte, piBitmap);
		this.cvmrsltsbyte = cvmrsltsbyte;
	}
	public String getDfnamelgthbyte() {
		return dfnamelgthbyte;
	}
	public void setDfnamelgthbyte(String dfnamelgthbyte) {
		BrouEmvUtil.setPosInBitMap(8, dfnamelgthbyte, piBitmap);
		this.dfnamelgthbyte = dfnamelgthbyte;
	}
	public String getDfnamebyte() {
		return dfnamebyte;
	}
	public void setDfnamebyte(String dfnamebyte) {
		this.dfnamebyte = dfnamebyte;
	}


	@Override
	public void setBertTlvHash(HashMap<String, TLVMsg> hashTlv) {
	
		
//		no cubiertos
		//TODO
		
		//		//	 This field is binary.


		//		//24    [8]     user^fld2.byte[0:7]                            PIC X(8). 
		//		//   This field is reserved for future use. 
		//		//
		//		//   This field is binary.
		//		String     userfld2byte;
		
		//44    [4]     df^name^lgth.byte[0:3]                         PIC X(4).
		//   Dedicated File Name length or Application Identifier               
		//	 length.  Indicates the length of the binary               
		//	 representation of the data in the following field.              
		//	 The ASCII and binary versions of the token must contain               
		//	 the same value in this field. 
//		String     dfnamelgthbyte;



		
			//   Interface Device (IFD) Number.  Unique and permanent 
			//	 serial number assigned to the terminal by the manufacturer.
			//	 EMV Tag = 9F1E. 
		String tag = "9F1E";
		if(hashTlv.containsKey(tag)) {
			this.setTermserlnumbyte(StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					TERMSERLNUMBYTE_LEN , '0'));

			}else { // todo por defecto agrego un nro 
				this.termserlnumbyte = StringUtilities.padLeft("0",TERMSERLNUMBYTE_LEN , '0'); // seteo algo sin modificar el bitmap
			}
		
		// 9F33 de ejemplo de B3        emv-term-cap [9F33]         : 604020
		
		tag = "9F33";
		if(hashTlv.containsKey(tag)) {
			this.setEmvtermcapbyte(StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					EMVTERMCAPBYTE_LEN , '0'));

			}else { 
				this.emvtermcapbyte = "604020"; // y no seteo el bitmao , como en el ejemplo
			}

		
			//   This field contains two decimal digits per byte. 
			//   EMV Tag = 9F35.
		tag =  "9F35";
		if(hashTlv.containsKey(tag)) {
			this.setEmvtermtypebyte(StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					EMVTERMTYPEBYTE_LEN , '0'));

			}	

			//   This field is binary.               
			//	 EMV Tag = 9F09.
		tag =  "9F09";
		if(hashTlv.containsKey(tag)) {
			this.setApplvernumbyte(StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					APPLVERNUMBYTE_LEN , '0'));

			}	

			//   This field is binary.               
			//	 EMV Tag = 9F34.
		tag =  "9F34";
		if(hashTlv.containsKey(tag)) {
			this.setCvmrsltsbyte(StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					CVMRSLTSBYTE_LEN , '0'));
			
			}	

			//   This field is binary. 
			//EMV Tag = 84 (DF Name) or 4F (AID) or 
			//9F06 (Terminal AID)
		tag =  "4F";
		if(hashTlv.containsKey(tag)) {
			String valor = DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue());
			
			this.setDfnamelgthbyte(StringUtilities.padRight(""+valor.length(),DFNAMELGTHBYTE_LEN , '0'));
			
			this.setDfnamebyte(StringUtilities.padRight(valor,DFNAMEBYTE_LEN , '0'));

			}	

	}
	
	@Override
	public String toStrFormat() {
		return  BrouEmvUtil.getBitmap(piBitmap, BITMAPBYTE_LEN) + termserlnumbyte + emvtermcapbyte + userfld1byte + userfld2byte + emvtermtypebyte + applvernumbyte
				+ cvmrsltsbyte + dfnamelgthbyte + dfnamebyte ;
	}
	
	@Override
	public String toString() {
		return "B3EMVDiscretionaryDataToken [bitmapbyte=" + BrouEmvUtil.getBitmap(piBitmap, BITMAPBYTE_LEN) + ", termserlnumbyte=" + termserlnumbyte
				+ ", emvtermcapbyte=" + emvtermcapbyte + ", userfld1byte=" + userfld1byte + ", userfld2byte="
				+ userfld2byte + ", emvtermtypebyte=" + emvtermtypebyte + ", applvernumbyte=" + applvernumbyte
				+ ", cvmrsltsbyte=" + cvmrsltsbyte + ", dfnamelgthbyte=" + dfnamelgthbyte + ", dfnamebyte=" + dfnamebyte
				+ "]";
	}
	@Override
	public void cargaValoresPorDefecto() {
		// TODO Auto-generated method stub
		
		//		//24    [8]     user^fld2.byte[0:7]                            PIC X(8). 
		//		//   This field is reserved for future use. 
		//		//
		//		//   This field is binary.
		//		String     userfld2byte;
		
		this.userfld1byte = StringUtilities.padLeft("",USERFLD1BYTE_LEN , ' ');
		this.userfld2byte = StringUtilities.padLeft("",USERFLD2BYTE_LEN , ' ');
		
		//this.dfnamebyte
		
	}

}
