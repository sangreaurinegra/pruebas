package com.iso;
import org.jpos.iso.ISOUtil;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jpos.iso.ISOException;
import org.jpos.tlv.TLVList;
import org.jpos.tlv.TLVMsg;

import com.util.DateUtilities;
import com.iso.broustr.util.BrouEmvUtil;

public class ProcesadorSubCampo {
	
		public static String ERROR_NROSERIE = "89";

		public static String convertStringToHex(String str) {
			char[] chars = str.toCharArray();

			StringBuffer hex = new StringBuffer();
			for (int i = 0; i < chars.length; ++i) {
				hex.append(Integer.toHexString(chars[i]));
			}

			return hex.toString();
		}

		public static String convertHexToString(String hex) {
			StringBuilder sb = new StringBuilder();
			StringBuilder temp = new StringBuilder();

			for (int i = 0; i < hex.length() - 1; i += 2) {
				String output = hex.substring(i, i + 2);

				int decimal = Integer.parseInt(output, 16);

				sb.append((char) decimal);
				temp.append(decimal);
			}
			return sb.toString();
		}

//		public static Map<Integer, String> interpretarSubCampos(String strSub) {
//			Map<Integer, String> ret = new HashMap<Integer, String>();
//			int largo = strSub.length();
//
//			String str2BytesBCD = "";
//			String strSubResto = "";
//			Integer intLargoSub = Integer.valueOf(0);
//			Integer intCampoSub = Integer.valueOf(0);
//			String info = "";
//
//			while (largo > 0) {
//				largo -= 4;
//				strSubResto = strSub.substring(4);
//				str2BytesBCD = strSub.substring(0, 4);
//				intLargoSub = Integer.valueOf((Integer.valueOf(str2BytesBCD)
//						.intValue() - 2) * 2);
//
//				strSub = strSubResto;
//
//				largo -= 4;
//				strSubResto = strSub.substring(4);
//				str2BytesBCD = strSub.substring(0, 4);
//				intCampoSub = Integer.valueOf(str2BytesBCD);
//				strSub = strSubResto;
//
//				largo -= intLargoSub.intValue();
//				strSubResto = strSub.substring(intLargoSub.intValue());
//				
//				
//				info = strSub.substring(0, intLargoSub.intValue());
//				if(intCampoSub != 12) { // el campo 12 es binario y como el bcd no tiene tipado asociado a los sub campos no queda mas remedio que hacer este if
//					info = convertHexToString(info);
//				}
//				
//				strSub = strSubResto;
//
//				ret.put(intCampoSub, info);
//			}
//
//			return ret;
//		}
		
		
		public static Map<Integer, String> interpretarSubCampos(String strSub) {
			Map<Integer, String> ret = new HashMap<Integer, String>();
			int largo = strSub.length();

			String str2BytesBCD = "";
			String strSubResto = "";
			Integer intLargoSub = 0;
			Integer intCampoSub = 0;
			String info = "";

			while (largo > 0) {
				// largo
				largo -= 4;
				strSubResto = strSub.substring(4);
				str2BytesBCD = strSub.substring(0, 4);
				intLargoSub = (Integer.valueOf(str2BytesBCD) - 2) * 2; // quito e
																		// largo del
																		// campo
				strSub = strSubResto;

				// campo
				largo -= 4;
				strSubResto = strSub.substring(4);
				str2BytesBCD = strSub.substring(0, 4);
				intCampoSub = Integer.valueOf(str2BytesBCD);
				strSub = strSubResto;

				largo -= intLargoSub;
				strSubResto = strSub.substring(intLargoSub);
				
				if(intCampoSub != 12) { // el campo 12 es binario y como el bcd no tiene tipado asociado a los sub campos no queda mas remedio que hacer este if
					info = convertHexToString(strSub.substring(0, intLargoSub));
				}else {
					info = strSub.substring(0, intLargoSub);
				}
				
				strSub = strSubResto;

				ret.put(intCampoSub, info);

			}
			return ret;
		}
		
		private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
		public static String bytesToHex(byte[] bytes) {
		    char[] hexChars = new char[bytes.length * 2];
		    for (int j = 0; j < bytes.length; j++) {
		        int v = bytes[j] & 0xFF;
		        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
		        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
		    }
		    return new String(hexChars);
		}

		public static String armarSubCampos(Map<Integer, String> map) {
			String ret = "";

			Set<Integer> campos = map.keySet();
			String info = "";

			for (Integer campo : campos) {
				info = (String) map.get(campo);
				info = convertStringToHex(info);
				ret = ret
						+ String.format("%04d", new Object[] { Integer.valueOf(info
								.length() / 2 + 2) });
				ret = ret + String.format("%04d", new Object[] { campo });
				ret = ret + info;
			}

			return ret;
		}

		public static String getFechaHoraActual() {
			return DateUtilities.toString(DateUtilities.getCurrentDateTime(), 19);
		}

		public static void main(String[] args) {
			//			String st1 = "00110011323833313135373337";
			//
			//			Map hashMapSubcampos = interpretarSubCampos(st1);
			//			System.out.println(hashMapSubcampos);
			//
			//			System.out.println(armarSubCampos(hashMapSubcampos));
			//			System.out.println(st1);
			//
			//			String st2 = "001100113238333131353733370003003131000300323100030033330003003431000400353832";
			//
			//			hashMapSubcampos = interpretarSubCampos(st2);
			//			System.out.println(hashMapSubcampos);
			//
			//			System.out.println(armarSubCampos(hashMapSubcampos));
			//			System.out.println(st2);
			//
			//			System.out.println("Stress");

			//			hashMapSubcampos = new HashMap();
			//			hashMapSubcampos
			//					.put(Integer.valueOf(9898),
			//							"campo9898con un tamaño muy largo y letras como la ñ que complican");
			//			String st3 = armarSubCampos(hashMapSubcampos);
			//			System.out.println(st3);
			//			hashMapSubcampos = interpretarSubCampos(st3);
			//			System.out.println(hashMapSubcampos);



			// String interpretar = "00110011323833313132353537";//"0007005031313131310007005131313131310003004130001600263230313531303237313931393238";

			//String interpretar = "005100255465726d696e616c203120636f6e206e756d65726f2064652073657269652032383532323736363520696e76616c696461";
			//String interpretar = "00060051313131310013005031313131303131313131310013005331313030303030303130300013005230303131303030303030300003004130001600263230313730343139313330363435";//"001000503131313131313131000800513031313131310010005230303131303031300003004130001600263230313630383132313635383137";
			// "0010005031313131303131310010005130303030303030300010005230303131303031300013005330303030303030303030300003004130001600263230313730353139313831343335";
			//String interpretar = "0007005031313131310007005131313131310003004130001600263230313630373231313131333539";

			//String interpretar =  "001700513131313130303030313131313130300017005031313131303131313131313131313100100055303030303030303000170054313131313031313131313031313130001700533131313130303030313131313130300017005231313131303030303131313131303000170057313131313030313131313131313030001700563131303030303030313030313030300003004130001600263230313930333038313734333330";

			//String interpretar = "0011001132383535383439353101260012";

			//		String interpretar = "00110011323835323237363635013100129F270180950500809080009F2608A6ACA85F6A24612882023C009F3602001D9C01009F37040EEFEC329F100706010A03A0A8039F3303E040C89F3501129F0902008C9F34030203014F07A00000000310105F3401009F1A0208589A032011185F2A0208589F02060000000500009F03060000000000009F1E083835323237363635";

			//			por MX
			//			Nov 18 08:50:07 Trident local1.debug EmvCtClient: (:0) 0 00170050313131313131313131313130
			//			Nov 18 08:50:07 Trident local1.debug EmvCtClient: (:0) 16 30303000130051313131313030303030
			//			Nov 18 08:50:07 Trident local1.debug EmvCtClient: (:0) 32 30310013005231313131303030303030
			//			Nov 18 08:50:07 Trident local1.debug EmvCtClient: (:0) 48 31001300533131313130303031303031
			//			Nov 18 08:50:07 Trident local1.debug EmvCtClient: (:0) 64 00130054313131313030303030303100
			//			Nov 18 08:50:07 Trident local1.debug EmvCtClient: (:0) 80 13005531313131303030303030310017
			//			Nov 18 08:50:07 Trident local1.debug EmvCtClient: (:0) 96 00563130303030303031303030303030
			//			Nov 18 08:50:07 Trident local1.debug EmvCtClient: (:0) 112 30001700573131313131313131313131
			//			Nov 18 08:50:07 Trident local1.debug EmvCtClient: (:0) 128 31313131001000583030303030303030
			//			Nov 18 08:50:07 Trident local1.debug EmvCtClient: (:0) 144 00030041300016002632303230313131
			//			Nov 18 08:50:07 Trident local1.debug EmvCtClient: (:0) 160 38303835303038

			String interpretar = "00170050313131313131313131313130303030002100513031303130313031303030303030303130303000140052313131313030303030303130001400533131313130303031303031300015005431313131303030303030313030001300553131313130303030303031001700563030303030303030303030303030300017005730303030303030303030303030303000180058313131313131313131313131313131310003004130001600263230323031313230313532363333";


			System.out.println(interpretar);
			Map<Integer, String> hashMapinterpretarSubcampos = interpretarSubCampos(interpretar);//interpretarSubCamposdel63MxBrou(interpretar);
			System.out.println(hashMapinterpretarSubcampos);


			if (hashMapinterpretarSubcampos.containsKey(12)) {
				TLVList tlvList = new TLVList();

				System.out.println("1- " + hashMapinterpretarSubcampos.get(12));
				System.out.println("2- " + BrouEmvUtil.bytesToHex(hashMapinterpretarSubcampos.get(12).getBytes()));

				//BrouEmvUtil.bytesToHex(bytes)
				String strBertTlv = hashMapinterpretarSubcampos.get(12);
				System.out.println(strBertTlv);


				try {
					tlvList.unpack(BrouEmvUtil.hexStringToByteArray(hashMapinterpretarSubcampos.get(12)));
				} catch (ISOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

				Enumeration<TLVMsg> listaTlv = tlvList.elements();

				while (listaTlv.hasMoreElements()) {
					TLVMsg tlvMsg = listaTlv.nextElement();

					//System.out.println("crearHashTLVMsg tlvMsg.getTag() "+tlvMsg.getTag());

					String tag = Integer.toHexString(tlvMsg.getTag()).toUpperCase();

					System.out.println("crearHashTLVMsg tag "+tag);

					System.out.println("crearHashTLVMsg l " + BrouEmvUtil.bytesToHex(tlvMsg.getL()));

					System.out.println("crearHashTLVMsg v " + tlvMsg.getValue());

				}
			}

		}
		
		public static Map<Integer, String> interpretarSubCamposdel63MxBrou(String strSub) {
			Map<Integer, String> ret = new HashMap<Integer, String>();
			int largo = strSub.length();

			String str2BytesBCD = "";
			String strSubResto = "";
			Integer intLargoSub = 0;
			Integer intCampoSub = 0;
			String info = "";

			while (largo > 0) {
				// largo
				largo -= 4;
				strSubResto = strSub.substring(4);
				str2BytesBCD = strSub.substring(0, 4);
				intLargoSub = (Integer.valueOf(str2BytesBCD) - 2) * 2; // quito e
																		// largo del
																		// campo
				strSub = strSubResto;

				// campo
				largo -= 4;
				strSubResto = strSub.substring(4);
				str2BytesBCD = strSub.substring(0, 4);
				intCampoSub = Integer.valueOf(str2BytesBCD);
				strSub = strSubResto;

				info = strSub.substring(0, intLargoSub.intValue());
				if(intCampoSub != 12) { // el campo 12 es binario y como el bcd no tiene tipado asociado a los sub campos no queda mas remedio que hacer este if
					info = convertHexToString(info);
				}
				strSub = strSubResto;

				ret.put(intCampoSub, info);

			}
			return ret;
		}
		
		
	}
	
