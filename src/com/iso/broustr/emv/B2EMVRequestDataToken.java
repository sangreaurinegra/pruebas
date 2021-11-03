package com.iso.broustr.emv;

import java.util.HashMap;

import javax.xml.bind.DatatypeConverter;

import org.jpos.tlv.TLVMsg;

import com.util.StringUtilities;
import com.iso.broustr.util.BrouEmvUtil;

public class B2EMVRequestDataToken extends BXEMVDataToken {

//	(//(.*)\](.*)\[(.*))
//	\1 \n String\3  ;

//	String(.*)\^(.*)\.(.*)
//	String\1\2\3

//	String(.*)\.(.*)
//	String\1\2

//	String(.*)\^(.*)
//	String\1\2	

//	String(.*)\^(.*)\^(.*)\.(.*)
//	String\1\2\3\4

//	String(.*)\^(.*)
//	String\1\2

//	String(.*)\.(.*)
//	String\1\2

//	Segun Cesar de Brou los tamanios son los del listado y no el de los detalles .
	public static final int BITMAPBYTE_LEN = 4; // 0 [4] bit^map.byte[0:3] PIC X(4).
	public static final int USERFLD1BYTE_LEN = 4; // 4 [4] user^fld1.byte[0:3] PIC X(4).
	public static final int CRYPTOINFODATABYTE_LEN = 2; // 8 [2] crypto^info^data.byte[0:1] PIC X(2).
	public static final int TVRBYTE_LEN = 10; // 10 [10] tvr.byte[0:9] PIC X(10).
	public static final int ARQCBYTE_LEN = 16; // 20 [16] arqc.byte[0:15] PIC X(16).
	public static final int AMTAUTHBYTE_LEN = 12; // 36 [12] amt^auth.byte[0:11] PIC X(12).
	public static final int AMTOTHERBYTE_LEN = 12; // 48 [12] amt^other.byte[0:11] PIC X(12).
	public static final int AIPBYTE_LEN = 4; // 60 [4] aip.byte[0:3] PIC X(4).
	public static final int ATCBYTE_LEN = 4; // 64 [4] atc.byte[0:3] PIC X(4).
	public static final int TERMCNTRYCDEBYTE_LEN = 3; // 68 [3] term^cntry^cde.byte[0:2] PIC X(3).
	public static final int TRANCRNCYCDEBYTE_LEN = 3; // 71 [3] tran^crncy^cde.byte[0:2] PIC X(3).
	public static final int TRANDATBYTE_LEN = 6; // 74 [6] tran^dat.byte[0:5] PIC X(6).
	public static final int TRANTYPEBYTE_LEN = 2; // 80 [2] tran^type.byte[0:1] PIC X(2).
	public static final int UNPREDICTNUM_LEN = 8; // 82 [8] unpredict^num.byte[0:7] PIC X(8).
	public static final int ISSAPPLDATALGTHBYTE_LEN = 4; // 90 [4] iss^appl^data^lgth.byte[0:3] PIC X(4).
	public static final int ISSAPPLDATABYTE_LEN = 64; // 94 [64] iss^appl^data.byte[0:63] PIC X(64).

// All fields are ASCII Hexadecimal

//	###################################################### 
//	#  EMV Request Data Token (Binary format)			# 
//	######################################################			   
//Holds the thirteen minimum request data elements, as
//	defined by EMV. 
//
//		This token will be created by device handlers and
//	interchange interface processes and added to the			   
//	PSTM/STM before being forwarded to the Authorization module. 
//	
//	Token id is B2

//	Offset[Len]   Field Name and Description                     Data Type 
//	 
//	0     [80] 
//	 

//	0     [2]     bit^map	TYPE BINARY 16 SIGNED. 
//	 
//	This field is set by the acquiring process to indicate              
//	which EMV data elements are present in the EMV Request Token. 
//		The first field in the token(BIT-MAP) indicates whether              
//	data in each of the remaining fields in the token is
//	present or absent. 
//		The token itself is a fixed format structure, so the               
//	absence of a data item, as specified in the BIT-MAP,              
//	means that the appropriate field will be present but               
//	that its contents are undefined. 
//	              Note that the positions of the bits within the BIT-MAP              
//	follow the ISO 8583 convention, i.e. the highest order              
//	bit represents the first field in the token (following the BIT-MAP). 
//	 
//	              This field is a binary bit map. 
//	 
	private int piBitmap = 0;

//	2     [2]     user^fld1.byte[0:1]                            PIC X(2).    
//	              This field is reserved for future use. 
//	              This field is binary. 
	String userfld1byte; // Pos1 // , uso futuro llenar con 0000... consultar a Brou , de ejemplo de Brou
							// aparece vacio

//	4     [1]     crypto^info^data                               PIC X(1).
//	 
//	            Cryptogram Information Data.  Indicates the type of
//				cryptogram and the actions to be performed by the
//				terminal, as follows: 
//	 
//	            In EMV specifications, definitions which include bit
// 				positions indicate that bit position 8 is the leftmost
//				bit.  In the tokens, this position is stored in bit
//				position 0 (leftmost bit). 
//	 
//	              EMV Defined 
//	              Bit 
//	              Position   Meaning 
//	              --------   ------- 
//	 
//	              8-7        Type of cryptogram: 
//												00	= AAC 
//												01	= TC 
//												10	= ARQC 
//												11	= AAR 
//	 
//	              6          Reserved for future use 
//	 
//	              5          Reserved for future use 
//	 
//	4	Advice required 
//	 
//	              3-1        Reason/advice/referral code: 
//	                         000 = No information given 
//	                         001 = Service not allowed 
//	                         010 = PIN Try Limit exceeded 
//	                         011 = Issuer authentication failed 
//	                         1xx = Reserved for future use 
//	 
//	              This field is binary.               EMV Tag = 9F27. 
	String cryptoinfodata; // Pos 2

//	5	[5]     tvr.byte[0:4]                                  PIC X(5).   
//	 
//	              Terminal Verification Results.  Status of the               different functions as seen from the terminal as               shown below.  Where the bit setting is not specified,               a bit setting of '1' indicates the meaning specified,               a bit setting of '0' indicates the opposite.  
//	              In EMV specifications, definitions which include bit               positions indicate that bit position 8 is the leftmost               bit.  In the tokens, this position is stored in bit               position 0 (leftmost bit). 
//	 
//	              Byte 1 
//	                EMV Defined 
//	                Bit 
//	                Position   Meaning 
//	                --------   ------- 
//	                   8       Offline data authentication was not                            performed 
//	                   7       Offline static data authentication failed 
//	                   6       ICC data missing 
//	                   5       Card appears on terminal exception file 
//	                   4       Offline dynamic data authentication failed 
//	                   3       Reserved for future use 
//	                   2       Reserved for future use 
//	                   1       Reserved for future use 
//	 
//	              Byte 2 
//	                EMV Defined 
//	                Bit 
//	                Position   Meaning 
//	                --------   ------- 
//	                   8       ICC and terminal have different                            application versions                    7       Expired application 
//	                   6       Application not yet effective                    5       Requested service not allowed for card                            product                    4       New card 
//	                   3       Reserved for future use 
//	                   2       Reserved for future use 
//	                   1       Reserved for future use 
//	 
//	              Byte 3 
//	                EMV Defined 
//	                Bit 
//	                Position   Meaning 
//	                --------   ------- 
//	                   8       Cardholder verification was not successful 
//	                   7       Unrecognised CVM 
//	                   6       PIN Try Limit exceeded 
//	                   5       PIN entry required and PIN pad not present                            or not working 
//	                   4       PIN entry required, PIN pad present, but 
//	                           PIN was not entered 
//	                   3       Online PIN entered 
//	                   2       Reserved for future use 
//	                   1       Reserved for future use 
//	 
//	              Byte 4 
//	                EMV Defined 
//	                Bit 
//	                Position   Meaning 
//	                --------   ------- 
//	                   8       Transaction exceeds floor limit 
//	                   7       Lower consecutive offline limit exceeded 
//	                   6       Upper consecutive offline limit exceeded                    5       Transaction selected randomly for online                            processing 
//	                   4       Merchant forced transaction online 
//	                   3       Reserved for future use 
//	                   2       Reserved for future use 
//	                   1       Reserved for future use 
//	 
//	              Byte 5 
//	                EMV Defined 
//	                Bit 
//	                Position   Meaning 
//	                --------   ------- 
//	                   8       Default TDOL used 
//	 
//	                   7       Issuer authentication was unsuccessful 
//	                   6       Script processing failed before final 
//	                           GENERATE AC 
//	                   5       Script processing failed after final 
//	                           GENERATE AC 
//	                   4       Reserved for future use 
//	                   3       Reserved for future use 
//	                   2       Reserved for future use 
//	                   1       Reserved for future use 
//	 
//	              This field is binary.               EMV Tag = 95. 
	String tvrbyte; // Pos 3

//	10    [8]     arqc.byte[0:7]                                 PIC X(8).  
//	 
//	              Application Request Cryptogram.  Cryptogram returned by               the ICC in response to the GENERATE AC command. 
//	 
//	              This field is binary.               EMV Tag = 9F26.
	String arqcbyte; // Pos 4

//	18    [6]     amt^auth.byte[0:5]                             PIC X(6).  
//	 
//	              The authorized amount of the transaction (excluding adjustments). 
//	 
//	              This field contains two decimal digits per byte. 
//	              EMV Tag = 9F02. 
	String amtauthbyte; // Pos 5

//	24    [6]     amt^other.byte[0:5]                            PIC X(6).  
//	 
//	              Secondary amount associated with the transaction               representing a cashback amount. 
//	 
//	              This field contains two decimal digits per byte. 
//	              EMV Tag = 9F03. 
	String amtotherbyte; // Pos 6

//	30    [2]     aip.byte[0:1]                                  PIC X(2).  
//	 
//	              Application Interchange Profile.  Indicates the               capabilities of the card to support specific functions               in the application, as shown below.  Where the bit               value is not specified, a bit setting of '1'               indicates the meaning specified, a bit setting of '0'               indicates the opposite. 
//	 
//	              In EMV specifications, definitions which include bit               positions indicate that bit position 8 is the leftmost               bit.  In the tokens, this position is stored in bit               position 0 (leftmost bit). 
//	 
//	              Byte 1 
//	                EMV Defined 
//	                Bit 
//	                Position   Meaning 
//	                --------   ------- 
//	                   8       Initiate 
//	                   7       Offline static data authentication is                            supported 
//	                   6       Offline dynamic data authentication is                            supported 
//	                   5       Cardholder verification is supported 
//	                   4       Terminal risk management is to be                            performed 
//	                   3       Issuer authentication is supported 
//	                   2       Reserved for future use 
//	                   1       Reserved for future use 
//	 
//	              Byte 2 
//	                EMV Defined 
//	                Bit 
//	                Position   Meaning 
//	                --------   ------- 
//	                   8       Reserved for future use 
//	                   7       Reserved for future use 
//	                   6       Reserved for future use 
//	                   5       Reserved for future use 
//	                   4       Reserved for future use 
//	                   3       Reserved for future use 
//	                   2       Reserved for future use 
//	                   1       Reserved for future use 
//	 
//	              This field is binary.               EMV Tag = 82. 
	String aipbyte; // Pos 7

//	32    [2]     atc.byte[0:1]                                  PIC X(2).  
//	 
//	              Application Transaction Counter.  Counter maintained by               the application in the ICC (incrementing the ATC is               managed by the ICC). 
//	 
//	              This field is binary.               EMV Tag = 9F36.
	String atcbyte; // Pos 8

//	34    [2]     term^cntry^cde.byte[0:1]                       PIC X(2).  
//	 
//	              Terminal Country Code.  Indicates the country of the               terminal, represented according to ISO 3166. 
//	 
//	              This field contains two decimal digits per byte. 
//	              EMV Tag = 9F1A. 
	String termcntrycdebyte; // Pos 9

//	36    [2]     tran^crncy^cde.byte[0:1]                       PIC X(2).  
//	 
//	              Transaction Currency Code.  Indicates the currency code               of the transaction according to ISO 4217, as received               from the device or interchange. 
//	 
//	              This field contains two decimal digits per byte. 
//	              EMV Tag = 5F2A. 
	String trancrncycdebyte; // Pos 10

//	38    [3]     tran^dat.byte[0:2]                             PIC X(3).  
//	 
//	              Transaction Date (YYMMDD).  Local date that the               transaction was authorized. 
//	 
//	              This field contains two decimal digits per byte. 
//	              EMV Tag = 9A. 
	String trandatbyte; // Pos 11

//	41	[1]     tran^type                                      PIC X(1). 
//	 
//	              Transaction Type.  Indicates the type of financial               transaction, represented by the first two digits of               ISO 8583 (1987) Processing Code. 
//	 
//	              This field contains two decimal digits per byte. 
//	              EMV Tag = 9C.
	String trantype; // Pos 12

//	42	[4]     unpredict^num.byte[0:3]                        PIC X(4).  
//	 
//	              Unpredictable Number.  A value used to provide               variability and uniqueness to the generation of a               cryptogram. 
//	 
//	              This field is binary.               EMV Tag = 9F37.
	String unpredictnumbyte; // Pos 13

//	46    [2]     iss^appl^data^lgth                TYPE BINARY 16 SIGNED. 
//	 
//	              Issuer Application Data length.  Indicates the length  of binary representation of the data in the following field. 
//	The ASCII and binary versions of the token must contain the same value in this field. 
//	 
	String issappldatalgth; // Pos 14 //TODO calcular con el largo del siguiente campo

//	48    [32]    iss^appl^data.byte[0:31]                      PIC X(32).   
//	 
//	              Issuer Application Data.  Contains proprietary application data for transmission to the issuer in an on-line transaction. 
//	 
//	              This field is binary.               EMV Tag = 9F10.
	String issappldatabyte; // Pos 15

	public B2EMVRequestDataToken() {
		cargaValoresPorDefecto();
	}

	public String getUserfld1byte() {
		return userfld1byte;
	}

	public void setUserfld1byte(String userfld1byte) {
		BrouEmvUtil.setPosInBitMap(1, userfld1byte, piBitmap);
		this.userfld1byte = userfld1byte;

	}

	public String getTvrbyte() {
		return tvrbyte;
	}

	public void setTvrbyte(String tvrbyte) {
		BrouEmvUtil.setPosInBitMap(2, tvrbyte, piBitmap);
		this.tvrbyte = tvrbyte;
	}

	public String getArqcbyte() {
		return arqcbyte;
	}

	public void setArqcbyte(String arqcbyte) {
		BrouEmvUtil.setPosInBitMap(3, arqcbyte, piBitmap);
		this.arqcbyte = arqcbyte;
	}

	public String getAmtauthbyte() {
		return amtauthbyte;
	}

	public void setAmtauthbyte(String amtauthbyte) {
		BrouEmvUtil.setPosInBitMap(4, amtauthbyte, piBitmap);
		this.amtauthbyte = amtauthbyte;
	}

	public String getAmtotherbyte() {
		return amtotherbyte;
	}

	public void setAmtotherbyte(String amtotherbyte) {
		BrouEmvUtil.setPosInBitMap(5, amtotherbyte, piBitmap);
		this.amtotherbyte = amtotherbyte;
	}

	public String getAipbyte() {
		return aipbyte;
	}

	public void setAipbyte(String aipbyte) {
		BrouEmvUtil.setPosInBitMap(6, aipbyte, piBitmap);
		this.aipbyte = aipbyte;
	}

	public String getAtcbyte() {
		return atcbyte;
	}

	public void setAtcbyte(String atcbyte) {
		BrouEmvUtil.setPosInBitMap(7, atcbyte, piBitmap);
		this.atcbyte = atcbyte;
	}

	public String getTermcntrycdebyte() {
		return termcntrycdebyte;
	}

	public void setTermcntrycdebyte(String termcntrycdebyte) {
		BrouEmvUtil.setPosInBitMap(8, termcntrycdebyte, piBitmap);
		this.termcntrycdebyte = termcntrycdebyte;
	}

	public String getTrancrncycdebyte() {
		return trancrncycdebyte;
	}

	public void setTrancrncycdebyte(String trancrncycdebyte) {
		BrouEmvUtil.setPosInBitMap(9, trancrncycdebyte, piBitmap);
		this.trancrncycdebyte = trancrncycdebyte;
	}

	public String getTrandatbyte() {
		return trandatbyte;
	}

	public void setTrandatbyte(String trandatbyte) {
		BrouEmvUtil.setPosInBitMap(10, trandatbyte, piBitmap);
		this.trandatbyte = trandatbyte;
	}

	public String getUnpredictnumbyte() {
		return unpredictnumbyte;
	}

	public void setUnpredictnumbyte(String unpredictnumbyte) {
		BrouEmvUtil.setPosInBitMap(11, unpredictnumbyte, piBitmap);
		this.unpredictnumbyte = unpredictnumbyte;
	}

	public String getIssappldatabyte() {
		return issappldatabyte;
	}

	public void setIssappldatabyte(String issappldatabyte) {
		this.issappldatabyte = issappldatabyte;
	}



	public String getCryptoinfodata() {
		return cryptoinfodata;
	}

	public void setCryptoinfodata(String cryptoinfodata) {
		this.cryptoinfodata = cryptoinfodata;
	}

	public String getTrantype() {
		return trantype;
	}

	public void setTrantype(String trantype) {
		this.trantype = trantype;
	}

	public String getIssappldatalgth() {
		return issappldatalgth;
	}

	public void setIssappldatalgth(String issappldatalgth) {
		this.issappldatalgth = issappldatalgth;
	}

	@Override
	public String toString() {
		return "B2EMVRequestDataToken [bitmap=" + BrouEmvUtil.getBitmap(piBitmap, BITMAPBYTE_LEN)  + ", userfld1byte=" + userfld1byte + ", cryptoinfodata="
				+ cryptoinfodata + ", tvrbyte=" + tvrbyte + ", arqcbyte=" + arqcbyte + ", amtauthbyte=" + amtauthbyte
				+ ", amtotherbyte=" + amtotherbyte + ", aipbyte=" + aipbyte + ", atcbyte=" + atcbyte
				+ ", termcntrycdebyte=" + termcntrycdebyte + ", trancrncycdebyte=" + trancrncycdebyte + ", trandatbyte="
				+ trandatbyte + ", trantype=" + trantype + ", unpredictnumbyte=" + unpredictnumbyte
				+ ", issappldatalgth=" + issappldatalgth + ", issappldatabyte=" + issappldatabyte + "]";
	}

	public String toStrFormat() {
		return BrouEmvUtil.getBitmap(piBitmap, BITMAPBYTE_LEN) + userfld1byte + cryptoinfodata + tvrbyte + arqcbyte + amtauthbyte + amtotherbyte + aipbyte
				+ atcbyte + termcntrycdebyte + trancrncycdebyte + trandatbyte + trantype + unpredictnumbyte
				+ issappldatalgth + issappldatabyte;
	}

	/**
	 * 
	 * @param tlvMsg
	 */
	public void setBertTlvHash(HashMap<String, TLVMsg> hashTlv) { // TODO

		// String tag = Integer.toHexString(tlvMsg.getTag()).trim();

		// TODO resolver BitMaps String bitmap

		// This field is binary. EMV Tag = 9F27.
		// String cryptoinfodata; //Pos 2
		String tag = "9F27";
		if (hashTlv.containsKey(tag)) {

			String valor = StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					CRYPTOINFODATABYTE_LEN, ' ');

			System.out.println(tag + " " + valor);

			this.setCryptoinfodata(valor);

		}

		// This field is binary. EMV Tag = 95.
		// String tvrbyte; //Pos 3
		tag = "95";
		if (hashTlv.containsKey(tag)) {

			String valor = StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					TVRBYTE_LEN, ' ');

			System.out.println(tag + " " + valor);

			this.setTvrbyte(valor);
		}

		// This field is binary. EMV Tag = 9F26.
		// String arqcbyte ; // Pos 4
		tag = "9F26";
		if (hashTlv.containsKey(tag)) {

			String valor = StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					ARQCBYTE_LEN, ' ');

			System.out.println(tag + " " + valor);

			this.setArqcbyte(valor);
		}

		// This field contains two decimal digits per byte.
		// EMV Tag = 9F02.
		// String amtauthbyte; // Pos 5
		tag = "9F02";
		if (hashTlv.containsKey(tag)) {

			String valor = StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					AMTAUTHBYTE_LEN, ' ');

			System.out.println(tag + " " + valor);

			this.setAmtauthbyte(valor);

		}

		// This field contains two decimal digits per byte.
		// EMV Tag = 9F03.
		// String amtotherbyte; // Pos 6
		tag = "9F03";
		if (hashTlv.containsKey(tag)) {

			String valor = StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					AMTOTHERBYTE_LEN, ' ');

			System.out.println(tag + " " + valor);

			this.setAmtotherbyte(valor);

		}

		// This field is binary. EMV Tag = 82.
		// String aipbyte; // Pos 7
		tag = "82";
		if (hashTlv.containsKey(tag)) {

			String valor = StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					AIPBYTE_LEN, ' ');

			System.out.println(tag + " " + valor);

			this.setAipbyte(valor);

		}

		// This field is binary. EMV Tag = 9F36.
		// String atcbyte; // Pos 8
		tag = "9F36";
		if (hashTlv.containsKey(tag)) {

			String valor = StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					ATCBYTE_LEN, ' ');

			System.out.println(tag + " " + valor);

			this.setAtcbyte(valor);

		}

		// This field contains two decimal digits per byte.
		// EMV Tag = 9F1A.
		// String termcntrycdebyte; // Pos 9
		tag = "9F1A";
		if (hashTlv.containsKey(tag)) {

			String valor = StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					TERMCNTRYCDEBYTE_LEN, '0');

			System.out.println(tag + " " + valor);

			this.setTermcntrycdebyte(valor);

		}

		// This field contains two decimal digits per byte.
		// EMV Tag = 5F2A.
		// String trancrncycdebyte; // Pos 10
		tag = "5F2A";
		if (hashTlv.containsKey(tag)) {

			String valor = StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					TRANCRNCYCDEBYTE_LEN, ' ');

			System.out.println(tag + " " + valor);

			this.setTrancrncycdebyte(valor);

		}

		// This field contains two decimal digits per byte.
		// EMV Tag = 9A.
		// String trandatbyte; // Pos 11
		tag = "9A";
		if (hashTlv.containsKey(tag)) {

			String valor = StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					TRANDATBYTE_LEN, ' ');

			System.out.println(tag + " " + valor);

			this.setTrandatbyte(valor);

		}

		// EMV Tag = 9C.
		// String trantype; // Pos 12
		tag = "9C";
		if (hashTlv.containsKey(tag)) {

			String valor = StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					TRANTYPEBYTE_LEN, ' ');

			System.out.println(tag + " " + valor);

			this.setTrantype(valor);

		}
		tag = "9F37";
		// This field is binary. EMV Tag = 9F37.
		// String unpredictnumbyte; // Pos 13
		if (hashTlv.containsKey(tag)) {

			String valor = StringUtilities.padLeft(DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue()),
					UNPREDICTNUM_LEN, ' ');

			System.out.println(tag + " " + valor);

			this.setUnpredictnumbyte(valor);

		}

		// 46 [2] iss^appl^data^lgth TYPE BINARY 16 SIGNED.
		//
		// Issuer Application Data length. Indicates the length of binary representation
		// of the data in the following field.
		// The ASCII and binary versions of the token must contain the same value in
		// this field.
		//
		// String issappldatalgth; // Pos 14 //TODO calcular con el largo del siguiente
		// campo

		// This field is binary. EMV Tag = 9F10.
		// String issappldatabyte ; // Pos 15
		tag = "9F10";
		if (hashTlv.containsKey(tag)) {
			String valor = DatatypeConverter.printHexBinary(hashTlv.get(tag).getValue());

			String largo = StringUtilities.padLeft("" + valor.length(), ISSAPPLDATALGTHBYTE_LEN, ' ');

			System.out.println(tag + " Largo de " + valor + " " + largo);

			this.setIssappldatalgth(largo);

			System.out.println(tag + " " + valor);

			// TODO control de tamanio
			this.setIssappldatabyte(valor);

		}

	}

	@Override
	public void cargaValoresPorDefecto() {

//    B2)  EMV-Rqst                     :
//
//          bit-map                     : 7ff9   //TODO resolver bitMaps
//
//          user-fld1                   :

		this.setUserfld1byte(StringUtilities.padLeft("", ISSAPPLDATALGTHBYTE_LEN, ' '));

//
//          crypto-info-data            : 80  ////////// String tag = "9F27"

//          tvr                         : 8080048000  //  95)   Terminal Verification Results: 8080048000

//   1.8)    Offline data authentication was not performed: //TODO que es ?
//
//   2.8)    ICC and terminal have different application versions: //TODO que es ?
//
//   3.3)    Online PIN entered         : //TODO que es ?
//
//   4.8)    Transaction exceeds floor limit: //TODO que es ?
//
//          arqc                        : 99481dd2d031efe9	//	9F26)   Application Cryptogram      : 99481dd2d031efe9
//
//          amt-auth                    : 000000150000		//	9F02)   Amount, Authorised (Numeric): 000000150000
//
//          amt-other                   : 000000000000		//	9F03)   Amount, Other (Numeric)     : 000000000000
//
//          aip                         : 1c00				//	82)   Application Interchange Profile : 1c00
//
//   1.5)    Cardholder verification supported: //TODO que es ?
//
//   1.4)    Terminal risk management will be performed: //TODO que es ?
//
//   1.3)    Issuer authentication is supported: //TODO que es ?
//
//          atc                         : 04ab				//	9F36)   ATC                         : 04ab
//
//          term-cntry-cde              : 858				//	9F1A)   Terminal Country Code       : 0858			
//
//          tran-crncy-cde              : 858				//	5F2A)   Transaction Currency Code   : 0858		OJO quita el 0
//
//          tran-dat                    : 200820			//	9A)   Transaction Date            : 200820
//
//          tran-type                   : 01				//	9C)   Transaction Type            : 01
//
//          unpredict-num               : 106a295b			//	9F37)   Unpredictable Number        : 106a295b
//
//          iss-appl-data-lgth          : 7
//
//          iss-appl-data               : 06010a03a0800000000000000000000000000000000000000000000000000000

	}

	public static void main(String[] args) {
//	 System.out.println(StringUtilities.padLeft("12345", 3, '0'));
	}

}
