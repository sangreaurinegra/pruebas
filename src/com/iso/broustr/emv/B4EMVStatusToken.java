package com.iso.broustr.emv;

import java.util.HashMap;

import org.jpos.tlv.TLVMsg;

public class B4EMVStatusToken extends BXEMVDataToken{

	
	
//	0     [3]     pt^srv^entry^mde.byte[0:2]                     PIC X(3).
//		Point of Service Entry Mode.  Indicates the manner in              
//	  	which the card details were entered at the device, and              
//	  	the PIN entry capability of the terminal. 
 String     ptsrventrymdebyte;
 
 
//	3	[1]     term^entry^cap [1]                                PIC X(1).
//	Terminal Entry Capability..  This field is set by the acquiring process to indicate the capability of the 
// 	terminal, as shown below. 
//
// 	Value  Meaning 
// 	-----  ------- 
//	0	Unknown 
//	1	Reserved for future use 
//	2	Magnetic Stripe Read Capability 
//	3	Reserved for future use 
//	4	Reserved for future use 
//	5	ICC Contact Read Capability 
//  8   Contactless Read Capability but no ICC Contact 
//        Read Capability 
 String     termentrycap;
 
 
//	4	[1]     last^emv^stat    [1]                              PIC X(1).  
// 	Last EMV Status.  This flag indicates whether               
//	the card used to initiate the transaction is               
//	a chip card, and the type of transaction attempted,               
//	as shown below:
//
//	Value  Meaning 
//	-----  ------- 
//	Space  No information available 
//	0	Not a chip card 
//	1	A chip card, contact read attempted 
// 	3    A chip card, contact read attempted 
 String     lastemvstat;
 
 
//	5	[1]     data^suspect       [1]                            PIC X(1).
// 	Data Suspect. This flag is set by the acquiring process               
//	to indicate whether the CAM data is reliable, as shown               
//	below. 
//
// 	Value  Meaning 
// 	-----  ------- 
//	0	CAM data assumed correct 
//	1	CAM data is unreliable
 String     datasuspect;
 
 
//	6	[2]     appl^pan^seq^num.byte[0:1]                     PIC X(2).
// 	Application PAN Sequence Number.  This field identifies               
//	and differentiates cards with the same PAN. 
// 	EMV Tag = 5F34
 String     applpanseqnumbyte;
 
 
 
 
 
 //TODO ver refdefinicion 
//	8     [6]     dev^info.byte[0:5]                             PIC X(6).  
// Device Info. Contains device specific data 
 String     devinfobyte;
 
// //	                               [REDEFINES DEV^INFO]
////	8     [6]     cam^flags.byte[0:5]                            PIC X(6).
//// NCR CAM flags.  These flags are defined by NCR in               
////	their NDC+ CAM2 specification. 
////
////The 2 bytes (16 flags) of CAM data defined in the NCR specification are converted to 4 bytes ASCII hex in the native message for transmission from the ATM.  
////	This is done by splitting each of the 2 bytes into 4 4-bit pieces. 
////	Each 4 bit piece is represented in the low order 4 bits of each of the 4 bytes in the native message.  
////	The 4 bytes in the native message are moved directly into the first 4 bytes of this token field. 
////
////As defined by NCR, the flags identify conditions encountered at the terminal, as shown below. 
////	A bit setting of '1'indicates the meaning specified, a bit setting of '0'indicates the opposite. 
////
////Byte 1 as defined by NCR (moved to bytes 1 & 2 in in the token field) 
//// Bit 
//// Position  Value  Meaning 
//// --------  -----  ------- 
//// 	8       0/1   Reserved for future use 
//// 	7       0/1   Reserved for future use 
////    	6       0/1   Reserved for future use 
////    	5       0/1   Reserved for future use 
////    	4       0    Application retrieval successful 
////             1    Failed 
////    	3       0    Get Processing options successful 
////				1	Failed 
////		2		0    Application selection successful 
////             1    Failed 
////    	1       0/1   Reserved for future use  
////Byte 2 as defined by NCR (moved to bytes 3 & 4 in the token field) 
//// Bit 
//// Position  Value  Meaning 
//// --------  -----  ------- 
////    8        0    PDOL data valid 
////             1    PDOL data invalid 
////    7        0    CDOL1 data valid 
////             1    CDOL1 data invalid 
////    6        0    Generate AC successful 
////             1    Failed 
////    5       0/1   Reserved for future use 
////    4        0    CAM processing not yet successful 
////             1    CAM processing previously successful 
////    3        0    Easy Entry processing initiated 
////				1	Easy Entry processing not initiated 
////	   2		0    CAM processing initiated 
////             1    CAM processing not initiated 
////    1       0/1   Reserved for future use 
////
////As defined in the token: 
////
////Byte 5       Reserved for future use 
////Byte 6       Reserved for future use 
////
////This field is ASCII Hexadecimal.
// String		camflagsbyte;

// //	                               [REDEFINES DEV^INFO]
// //	8     [6]     cvm^rslts.byte[0:5]                            PIC X(6).    
//// Cardholder Verification Method Results.  Indicates the
////	results of the last CVM performed, as shown below.               
////	Where the bit setting is not specified, a bit setting               
////	of '1' indicates the meaning specified, a bit setting               
////	of '0' indicates the opposite. 
////
//// This field is defined as 24 bits (3 bytes) by EMV, but               
////	is converted to 6 ASCII bytes (each containing one              
////			hexadecimal character, representing 4 bits) when               
////	included in the EMV Status Token. 
////
//// This field contains the same data as the CVM-RSLTS               
////	field in the EMV Discretionary Data Token. It is               
////	repeated here simply to allow acquirers to notify               
////	issuers of the result of offline PIN verification               
////	without having to include the EMV Discretionary Data               
////	Token in the BASE24 External Message. 
////
//// Byte 1 (CVM Performed) 
////   EMV Defined 
////   Bit 
////   Position   Meaning 
////   --------   ------- 
////      8       Reserved for future use 
////      7       0 = Fail cardholder verification if this 
////                  CVM is unsuccessful 
////              1 = Apply succeeding CVR if this CVM is unsuccessful 
////     6-1      000000 = Fail CVM processing                            
////			   000001 = Plaintext PIN verification performed by ICC 
////              000010 = Enciphered PIN verified online 
////			   000011 = Plaintext PIN verification performed by ICC and signature 
////                       (paper) 
////              000100 = Enciphered PIN verification performed by ICC 
////              000101 = Enciphered PIN verification performed by ICC and signature 
////                       (paper) 
////              0xxxxx = Values in the range 000110-011101 reserved for future use by this specification                            
////			   011110 = Signature (paper) 
////              011111 = No CVM required 
////              10xxxx = Values in the range 100000-101111 reserved for use by the individual payment systems                            
////			   11xxxx = Values in the range 110000-111110 reserved for use by the issuer 
////              111111 = Not available for use 
////
//// Byte 2 (CVM Condition) 
////   Value  Meaning 
////   -----  ------- 
////		00	Always 
////		01	If cash or cashback 
////		02	If not cash or cashback 
////		03	If terminal supports the CVM 
////		04	Reserved for future use 
////		05	Reserved for future use 
////		06	If transaction is in the application currency and is under X value 
////		07	If transaction is in the application currency and is over X value 
////		08	If transaction is in the application currency and is under Y value 
////		09	If transaction is in the application currency                        and is over Y value                 0A-7F  Reserved for future use 
////   	80-FF  Reserved for future use by individual payment                        systems 
////
//// Byte 3 (CVM Result) 
//// Result of the (last) CVM performed as known by the terminal. 
////	0	= Unknown (for example, for signature) 
////	1	= Failed (for example, for offline PIN) 
////	2	= Successful (for example, for offline PIN) 
////
//// This field is binary. 
// String		cvmrsltsbyte;

 //	                               [REDEFINES DEV^INFO]
 //	8     [6]     ichg^def.byte[0:5]                             PIC X(6).
// Interchange definition.  Used by the VisaNet Interface only. 
//
//8     [2]     ichg^def.apprvd^rc.byte[0:1] PIC X(2).
 String ichgdefapprvdrc;
//
// Approved response code. In some authorization requests received via the VisaNet Interface, 
//this field contains the Authorization Response Code required to be used in ARPC generation. 
//
//10	[1]     ichg^def.atc^vrfy                              PIC X(1). 
// TODO , no esta en el Ejemplo del Brou
// ATC Verification Result.  This field is used to               
//  indicate the result of the ATC verification. 
// Valid values are: 
// G = Unknown (may be overwritten by the issuer) 
// A = ATC outside allowed range 
// E = ATC replay 
// V = ATC valid 
//
//11	[3]     ichg^def.user^fld^aci.byte[0:2]                PIC X(3).

String     ichgdefuserfldaci; 

// //	                      
 
 
 
////	14    [4]     rsn^onl^cde.byte[0:3]                          PIC X(4).  
 String     rsnonlcdebyte;
////	18	[1]     arqc^vrfy            [1]                          PIC X(1).  
 String     arqcvrfy;
////	19	[1]     iso^rc^ind             [1]                        PIC X(1).  
 String     isorcind;
	
	
	
	
//	DETALLE: 
//	 
//	              ###################################################### 
//	              #  EMV Status Token (Binary format)                  # 
//	              ######################################################               Holds data identifying the status of a transaction. 
//	 
//	              This token will be created by device handlers and               interchange interface processes and added to the               PSTM/STM before being forwarded to the RTAU/Auth               module.  The token will be added by EMV extension               modules when the transaction originates from an               EMV-capable terminal, regardless of whether the data               relates to an EMV transaction or a non-EMV               transaction. 
//	 
//	              Token id is B4. 
//	 
//	Offset[Len]   Field Name and Description                     Data Type  
//	0     [20] 
//	 
//	0     [3]     pt^srv^entry^mde.byte[0:2]                     PIC X(3). 
//	 
//	              Point of Service Entry Mode.  Indicates the manner in              
// 				  which the card details were entered at the device, and              
// 				  the PIN entry capability of the terminal. 
//	 
//	3	[1]     term^entry^cap                                 PIC X(1). 
//	 
//	Terminal Entry Capability..  This field is set by the acquiring process to indicate the capability of the 
//	              terminal, as shown below. 
//	 
//	              Value  Meaning 
//	              -----  ------- 
//	0	Unknown 
//	1	Reserved for future use 
//	2	Magnetic Stripe Read Capability 
//	3	Reserved for future use 
//	4	Reserved for future use 
//	5	ICC Contact Read Capability 
//	                8    Contactless Read Capability but no ICC Contact 
//	                     Read Capability 
//	 
//	4	[1]     last^emv^stat                                  PIC X(1). 
//	 
//	              Last EMV Status.  This flag indicates whether               
// 					the card used to initiate the transaction is               
// 					a chip card, and the type of transaction attempted,               
// as shown below:
//	 
//	              Value  Meaning 
//	              -----  ------- 
//	              Space  No information available 
//	0	Not a chip card 
//	1	A chip card, contact read attempted 
//	                3    A chip card, contact read attempted 
//	 
//	5	[1]     data^suspect                                   PIC X(1). 
//	 
//	              Data Suspect. This flag is set by the acquiring process               
// 					to indicate whether the CAM data is reliable, as shown               
// 					below. 
//	 
//	              Value  Meaning 
//	              -----  ------- 
//	0	CAM data assumed correct 
//	1	CAM data is unreliable 
//	 
//	6	[2]     appl^pan^seq^num.byte[0:1]                     PIC X(2). 
//	 
//	              Application PAN Sequence Number.  This field identifies               
// 				and differentiates cards with the same PAN. 
//	              EMV Tag = 5F34. 
//	 
//	8     [6]     dev^info.byte[0:5]                             PIC X(6). 
//	 
//	              Device Info. Contains device specific data 
//	 
//	8     [6]     cam^flags.byte[0:5]                            PIC X(6). 
//	                               [REDEFINES DEV^INFO]  
//	              NCR CAM flags.  These flags are defined by NCR in               
// 					their NDC+ CAM2 specification. 
//	 
//	              The 2 bytes (16 flags) of CAM data defined in the NCR specification are converted to 4 bytes ASCII hex in the native message for transmission from the ATM.  
// 					This is done by splitting each of the 2 bytes into 4 4-bit pieces. 
// 					Each 4 bit piece is represented in the low order 4 bits of each of the 4 bytes in the native message.  
// 					The 4 bytes in the native message are moved directly into the first 4 bytes of this token field. 
//	 
//	              As defined by NCR, the flags identify conditions encountered at the terminal, as shown below. 
// 					A bit setting of '1'indicates the meaning specified, a bit setting of '0'indicates the opposite. 
//	 
//	              Byte 1 as defined by NCR (moved to bytes 1 & 2 in in the token field) 
//	                Bit 
//	                Position  Value  Meaning 
//	                --------  -----  ------- 
//	                	8       0/1   Reserved for future use 
//	                	7       0/1   Reserved for future use 
//	                   	6       0/1   Reserved for future use 
//	                   	5       0/1   Reserved for future use 
//	                   	4       0    Application retrieval successful 
//	                            1    Failed 
//	                   	3       0    Get Processing options successful 
//								1	Failed 
//						2		0    Application selection successful 
//	                            1    Failed 
//	                   	1       0/1   Reserved for future use  
//	              Byte 2 as defined by NCR (moved to bytes 3 & 4 in the token field) 
//	                Bit 
//	                Position  Value  Meaning 
//	                --------  -----  ------- 
//	                   8        0    PDOL data valid 
//	                            1    PDOL data invalid 
//	                   7        0    CDOL1 data valid 
//	                            1    CDOL1 data invalid 
//	                   6        0    Generate AC successful 
//	                            1    Failed 
//	                   5       0/1   Reserved for future use 
//	                   4        0    CAM processing not yet successful 
//	                            1    CAM processing previously successful 
//	                   3        0    Easy Entry processing initiated 
//								1	Easy Entry processing not initiated 
//					   2		0    CAM processing initiated 
//	                            1    CAM processing not initiated 
//	                   1       0/1   Reserved for future use 
//	 
//	              As defined in the token: 
//	 
//	              Byte 5       Reserved for future use 
//	              Byte 6       Reserved for future use 
//	 
//	              This field is ASCII Hexadecimal. 
//	 
//	8     [6]     cvm^rslts.byte[0:5]                            PIC X(6). 
//	                               [REDEFINES DEV^INFO] 
//	 
//	              Cardholder Verification Method Results.  Indicates the
//					results of the last CVM performed, as shown below.               
//					Where the bit setting is not specified, a bit setting               
//					of '1' indicates the meaning specified, a bit setting               
//					of '0' indicates the opposite. 
//	 
//	              This field is defined as 24 bits (3 bytes) by EMV, but               
//					is converted to 6 ASCII bytes (each containing one              
//							hexadecimal character, representing 4 bits) when               
//					included in the EMV Status Token. 
//	 
//	              This field contains the same data as the CVM-RSLTS               
//					field in the EMV Discretionary Data Token. It is               
//					repeated here simply to allow acquirers to notify               
//					issuers of the result of offline PIN verification               
//					without having to include the EMV Discretionary Data               
//					Token in the BASE24 External Message. 
//	 
//	              Byte 1 (CVM Performed) 
//	                EMV Defined 
//	                Bit 
//	                Position   Meaning 
//	                --------   ------- 
//	                   8       Reserved for future use 
//	                   7       0 = Fail cardholder verification if this 
//	                               CVM is unsuccessful 
//	                           1 = Apply succeeding CVR if this CVM is unsuccessful 
//	                  6-1      000000 = Fail CVM processing                            
// 							   000001 = Plaintext PIN verification performed by ICC 
//	                           000010 = Enciphered PIN verified online 
// 							   000011 = Plaintext PIN verification performed by ICC and signature 
//	                                    (paper) 
//	                           000100 = Enciphered PIN verification performed by ICC 
//	                           000101 = Enciphered PIN verification performed by ICC and signature 
//	                                    (paper) 
//	                           0xxxxx = Values in the range 000110-011101 reserved for future use by this specification                            
// 							   011110 = Signature (paper) 
//	                           011111 = No CVM required 
//	                           10xxxx = Values in the range 100000-101111 reserved for use by the individual payment systems                            
// 							   11xxxx = Values in the range 110000-111110 reserved for use by the issuer 
//	                           111111 = Not available for use 
//	 
//	              Byte 2 (CVM Condition) 
//	                Value  Meaning 
//	                -----  ------- 
//						00	Always 
//						01	If cash or cashback 
//						02	If not cash or cashback 
//						03	If terminal supports the CVM 
//						04	Reserved for future use 
//						05	Reserved for future use 
//						06	If transaction is in the application currency and is under X value 
//						07	If transaction is in the application currency and is over X value 
//						08	If transaction is in the application currency and is under Y value 
//						09	If transaction is in the application currency                        and is over Y value                 0A-7F  Reserved for future use 
//	                	80-FF  Reserved for future use by individual payment                        systems 
//	 
//	              Byte 3 (CVM Result) 
//	              Result of the (last) CVM performed as known by the terminal. 
//					0	= Unknown (for example, for signature) 
//					1	= Failed (for example, for offline PIN) 
//					2	= Successful (for example, for offline PIN) 
//	 
//	              This field is binary. 
//	 
//					8     [6]     ichg^def 
//	                               [REDEFINES DEV^INFO] 
//	 
//	              Interchange definition.  Used by the VisaNet Interface only. 
//	 
//	8     [2]     ichg^def.apprvd^rc.byte[0:1] PIC X(2). 
//	 
//	              Approved response code. In some authorization requests received via the VisaNet Interface, 
// 				this field contains the Authorization Response Code required to be used in ARPC generation. 
//	 
//	10	[1]     ichg^def.atc^vrfy                              PIC X(1). 
//	 
//	              ATC Verification Result.  This field is used to               
// 				  indicate the result of the ATC verification. 
//	              Valid values are: 
//	              G = Unknown (may be overwritten by the issuer) 
//	              A = ATC outside allowed range 
//	              E = ATC replay 
//	              V = ATC valid 
//	 
//	11	[3]     ichg^def.user^fld^aci.byte[0:2]                PIC X(3). 
 
 
 
 
 
 
//	 
//	14    [4]     rsn^onl^cde.byte[0:3]                          PIC X(4). 
//	 
//	              Reason On-line Code.  The value of this field               
// 					indicates the reason the transaction is to be authorized on-line or why a transaction has been 
//	              completed locally. Values are defined in the               
// 					ISO 8583 (1993) Standard. 
//	 
//	              In a request message, the valid values are as follows: 
//	 
//	              Value  Description 
//	              -----  ----------- 
//					1500	ICC Application, Common Data File unable to process 
//					1501	ICC Application, Application Data File unable to process 
//					1502	ICC Random Selection 
//					1503	Terminal Random Selection 
//					1504	Terminal not able to process ICC 
//					1505	On Line Forced by ICC (CDF or ADF) 
//					1506	On Line Forced by Card Acceptor 
//					1507	On Line Forced by CAD to be updated 
//					1508	On Line Forced by Terminal 
//					1509	On Line Forced by Issuer 
//					1510	Over Floor Limit 
//					1511	Merchant Suspicious 
//	 
//	              	In an advice message that the terminal has previously               
// 					attempted to send to the acquirer as a request message,               
// 					this field contains the same value as in the original request message. 
//	 
//	              In an advice message that the terminal has not               
// 					previously attempted to send to the acquirer as a               
// 					request message, the valid values are as follows: 
//	 
//	              Value  Description 
//	              -----  ----------- 
//					1004	Terminal Processed 
//					1005	ICC Processed 
//					1006	Under Floor Limit 
//					1007	Stand-in Processing at the Acquirer's Option 
//	 
//	18	[1]     arqc^vrfy                                      PIC X(1).  
//	              ARQC Verification Result.  This field is used to indicate the result of the ARQC verification, as shown below. 
//	 
//	              Value  Meaning 
//	              -----  ------- 
//					0	ARQC not verified 
//					1	ARQC was checked by acquiring system or switch,                      but failed verification 
//					2	ARQC was checked by acquiring system or switch                      and passed verification 
//					3	ARQC was checked by BASE24 or issuer system,                      but failed verification 
//					4	ARQC was checked by BASE24 or issuer system,                      and passed verification               5 - 7  Reserved for future use 
//					8	ARQC not verified, but other EMV processing                      required, e.g. ATC check 
//					9	ARQC not verified - transaction "downgraded"                      to magnetic stripe 
//	 
//	19	[1]     iso^rc^ind                                     PIC X(1). 
//	 
//	              ISO 8583 (1987) Response Code Indicator. This field is               
// used to indicate whether the ISO response code sent to               
// the interchange should be used in the ARPC generation,               
// or whether the ISO response code received from the               
// interchange should be returned to the terminal as the               
// Authorization Response Code (ARC). 
//	 
//	              Value  Meaning               -----  ------- 
//	              space  No information available 
//	0	Do not use interchange response code 
//	 
//	              For EMV transactions where BASE24 is the issuer: 
//	 
//	              Value  Meaning 
//	              -----  ------- 
//	1	Use supplied response code in ARPC                      generation for approved transactions 
//	 
//	              For EMV transactions where BASE24 is the acquirer: 
//	 
//	              Value  Meaning 
//	              -----  ------- 
//	                9    Use interchange response code as ARC sent                      to terminal 
//	 
//	              END   [size    20]  
//

 public B4EMVStatusToken() {
	 super();
	 cargaValoresPorDefecto();
}
 
 
 
 	public void cargaValoresPorDefecto() {
 		
// De mail de Ejemplo Brou 		
 		
// 		 B4)  EMV-Stat                     : 05151000000400    0

//    pt-srv-entry-mde            : 051
//
//    term-entry-cap              : 5
//
//    last-emv-stat               : 1
//
//    data-suspect                : 0
//
//    appl-pan-seq-num            : 00
//
//    dev-info                    : 000400
//
//    ichg-def.apprvd-rc          :  
//
//    ichg-def.user-fld-aci       :   0
//
//    rsn-onl-cde                 :
//
//    arqc-vrfy                   :
//
//    iso-rc-ind                  :
 		
 		this.ptsrventrymdebyte 	= "051";
 		this.termentrycap		= "5";
 		this.lastemvstat 		= "1";
 		this.datasuspect 		= "0";
 		this.applpanseqnumbyte	= "00";
 		this.devinfobyte		= "000400";
 		this.ichgdefapprvdrc	= "";
 		this.ichgdefuserfldaci	= "0";

 		
 		this.rsnonlcdebyte		= "";  
 		this.arqcvrfy			= "";
 		this.isorcind			= "";
 		
 	}
 	

	
	

	@Override
	public String toStrFormat() {
		return  ptsrventrymdebyte  + termentrycap +  lastemvstat  + datasuspect + applpanseqnumbyte + devinfobyte  + ichgdefapprvdrc
				 + ichgdefuserfldaci  + rsnonlcdebyte + arqcvrfy  + isorcind ;
	}


	@Override
	public String toString() {
		return "B4EMVStatusToken [ptsrventrymdebyte=" + ptsrventrymdebyte + ", termentrycap=" + termentrycap
				+ ", lastemvstat=" + lastemvstat + ", datasuspect=" + datasuspect + ", applpanseqnumbyte="
				+ applpanseqnumbyte + ", devinfobyte=" + devinfobyte + ", ichgdefapprvdrc=" + ichgdefapprvdrc
				+ ", ichgdefuserfldaci=" + ichgdefuserfldaci + ", rsnonlcdebyte=" + rsnonlcdebyte + ", arqcvrfy="
				+ arqcvrfy + ", isorcind=" + isorcind + "]";
	}



	@Override
	public void setBertTlvHash(HashMap<String, TLVMsg> hashTlv) {
		// TODO Auto-generated method stub
		
	}

}
