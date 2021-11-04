package com.string;

public class PruString2 {
	
	

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		String[] fieldsValues = new String[3];
//		fieldsValues[0] = "uno";
//		fieldsValues[1] = "dos";
//		fieldsValues[2] = "tres";
//			
//		    String data = "";
//		    for (String fv : fieldsValues) {
//				data += fv;
//		    }
//
//		    System.out.println(data);
		
//		String campo3 = "123456";
//		if(campo3.length()==6){
//			String tipocuentaOrigenString = campo3.substring(2, 4);
//			String tipocuentadestino = campo3.substring(4);
//			
//			System.out.println(tipocuentaOrigenString+" "+tipocuentadestino);
//		}
		
//		String codigoproceso = "221000";
//		System.out.println(codigoproceso);
//		if(codigoproceso.startsWith("22")) {//TODO arreglo momentaneo caso de depo cta de terceros version MX 27
//			codigoproceso = "21"+codigoproceso.substring(2);
//		}
//		
//		System.out.println(codigoproceso);		
//		
//		
//		String psAuthCode = "123456789"; 
//		if (psAuthCode != null){
//			psAuthCode.trim();
//			if (psAuthCode.length() > 5)
//				psAuthCode = psAuthCode.substring(psAuthCode.length() - 6);
//			else psAuthCode = StringUtilities.padLeft(psAuthCode, 6, '0');
//		}
//		else{
//			psAuthCode = "0";
//		} 
//		
//		
//		System.out.println(psAuthCode);	
		
		
//		String amount = "123";
//		String formatted = (new String(new char[134]).replace("\0", " ") + "123").substring(amount.length());
//		System.out.println(formatted);
		
		
//		List<Long> partidasInvolucradas = new ArrayList<Long>();
//		
//		partidasInvolucradas.add(1L);
//		partidasInvolucradas.add(2L);
//		partidasInvolucradas.add(3L);
//		partidasInvolucradas.add(4L);
//		partidasInvolucradas.add(5L);
//			
//			String ret = "";
//			
//			if (partidasInvolucradas != null){
//				for (Long partida : partidasInvolucradas) {
//					ret += partida + ",";
//				}
//				ret = ret.substring(0,ret.length()-1);
//			}
//			
//			
//			System.out.println(ret);
		
		String ret = "";
		ret += "1" ;
		ret += "2" ;
		ret += "3" ;
		System.out.println(ret);
		
		
		String nroCta = "0000000000000000009876543210";
		nroCta = nroCta.substring(nroCta.length()-9, nroCta.length());
		
		System.out.println(nroCta);
		
	}
	
	
	

}
