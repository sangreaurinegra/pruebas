package com.iso;

import org.jpos.tlv.TLVList;

import com.iso.broustr.emv.B2EMVRequestDataToken;

public class PaserCampo126 {

	public static void main(String[] args) {
		String campo126 ="! B200158 "
				+ "7FF90000808080048000B998F81C3ADD320B00000001000000000000000058000014858858140210030D673DA90008010103A000000000000000000000000000000000000000000000000000000000"
				+"! B300080 "
				+"4F00        604020200000000000001400020200000007A0000000041010000000000000000000"
				+"! B400020 "
				+"05151000000400    0 " 
				+"! B500038 "
				+"0010FD18773DA37240913030000000000000NN"
				+"?";

		String[] split126 = campo126.split("!");
		for (String tag : split126) {
			if(!"".equals(tag)) {
				System.out.println(tag);
				System.out.println(tag.substring(9,tag.length()));
			}

		};
	}
	
//	private TLVList procesarB2(String b2Value){
//		TLVList ret = new TLVList();
//		public static final int BITMAPBYTE_LEN = 4; // 0 [4] bit^map.byte[0:3] PIC X(4).
//		public static final int USERFLD1BYTE_LEN = 4; // 4 [4] user^fld1.byte[0:3] PIC X(4).
//		public static final int CRYPTOINFODATABYTE_LEN = 2; // 8 [2] crypto^info^data.byte[0:1] PIC X(2).
//		public static final int TVRBYTE_LEN = 10; // 10 [10] tvr.byte[0:9] PIC X(10).
//		public static final int ARQCBYTE_LEN = 16; // 20 [16] arqc.byte[0:15] PIC X(16).
//		public static final int AMTAUTHBYTE_LEN = 12; // 36 [12] amt^auth.byte[0:11] PIC X(12).
//		public static final int AMTOTHERBYTE_LEN = 12; // 48 [12] amt^other.byte[0:11] PIC X(12).
//		public static final int AIPBYTE_LEN = 4; // 60 [4] aip.byte[0:3] PIC X(4).
//		public static final int ATCBYTE_LEN = 4; // 64 [4] atc.byte[0:3] PIC X(4).
//		public static final int TERMCNTRYCDEBYTE_LEN = 3; // 68 [3] term^cntry^cde.byte[0:2] PIC X(3).
//		public static final int TRANCRNCYCDEBYTE_LEN = 3; // 71 [3] tran^crncy^cde.byte[0:2] PIC X(3).
//		public static final int TRANDATBYTE_LEN = 6; // 74 [6] tran^dat.byte[0:5] PIC X(6).
//		public static final int TRANTYPEBYTE_LEN = 2; // 80 [2] tran^type.byte[0:1] PIC X(2).
//		public static final int UNPREDICTNUM_LEN = 8; // 82 [8] unpredict^num.byte[0:7] PIC X(8).
//		public static final int ISSAPPLDATALGTHBYTE_LEN = 4; // 90 [4] iss^appl^data^lgth.byte[0:3] PIC X(4).
//		public static final int ISSAPPLDATABYTE_LEN = 64; // 94 [64] iss^appl^data.byte[0:63] PIC X(64).
		
//		B2EMVRequestDataToken. TODO
//
//		
//		return ret;
//	}

}
