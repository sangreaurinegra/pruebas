package com.string;



public class SplitStr {

	public static void main(String[] args) {
		
//		String field35 = "5010730101024016138=2310120193";
//		
//		System.out.println(field35.split("=")[0]);
//
//		
//		String otro = "501073018120072";
//		
//		String otro2 = "5010730181200720";
//		
//		System.out.println(otro.split("=")[0]);
//		
//		int largo = otro.length();
//		try {
//			if (largo>=1) System.out.println(otro.substring(0, 16));
//			else System.out.println("no" + largo);
//		} catch (Exception e) {
//			 System.out.println("entre en catch " + e.getMessage());
//		}
//		
//		
//		largo = otro2.length();
//		if (largo>=16) System.out.println(otro2.substring(0, 16));
//		else System.out.println("no" + largo);
		
		
//		String montoCredito = "3.5";
//		System.out.println(montoCredito +"->"+ fomartoArchivoScotia(montoCredito));
//		montoCredito = "100" ;
//		System.out.println(montoCredito +"->"+ fomartoArchivoScotia(montoCredito));
//		montoCredito = "1.00" ;
//		System.out.println(montoCredito +"->"+ fomartoArchivoScotia(montoCredito));
//		montoCredito = "1.0" ;
//		System.out.println(montoCredito +"->"+ fomartoArchivoScotia(montoCredito));
//		montoCredito = "3.12" ;
//		System.out.println(montoCredito +"->"+ fomartoArchivoScotia(montoCredito));
//		montoCredito = "3.120" ;
//		System.out.println(montoCredito +"->"+ fomartoArchivoScotia(montoCredito));
//		montoCredito = "0.121" ;
//		System.out.println(montoCredito +"->"+ fomartoArchivoScotia(montoCredito));
//		montoCredito = "0.0" ;
//		System.out.println(montoCredito +"->"+ fomartoArchivoScotia(montoCredito));
//		montoCredito = "0" ;
//		System.out.println(montoCredito +"->"+ fomartoArchivoScotia(montoCredito));
//		
		
//		String str = "|A|";
//		String[] splitStr = str.split("\\|");
//		
//		System.out.println(splitStr.length);
//		System.out.println(Arrays.toString(splitStr));
//		
//		
//		str = "1234567890|A||UY-5-123";
//		splitStr = str.split("\\|");
//		
//		System.out.println(splitStr.length);
//		System.out.println(Arrays.toString(splitStr));
		
//		String campo35 = "4213000010062219=2610526658";
//		System.out.println( campo35toNroTarjeta(campo35));
		
		String strBinesNo = "501074";//getProperty("com.atm.brou.depositos.bines.no.aceptados", "");
		System.out.println(strBinesNo);
		
		String track2 = "4213000010062219=2610526658";
		System.out.println(track2 +" "+ esBinAceptado(track2,strBinesNo));
		track2 = "5010740010062219=2610526658";	
		System.out.println(track2 +" "+ esBinAceptado(track2,strBinesNo));
		track2 = "5010752310062219=2610526658";	
		System.out.println(track2 +" "+ esBinAceptado(track2,strBinesNo));
		
		
		
		strBinesNo = "501074,50107523";//getProperty("com.atm.brou.depositos.bines.no.aceptados", "");
		System.out.println(strBinesNo);
		
		track2 = "4213000010062219=2610526658";
		System.out.println(track2 +" "+ esBinAceptado(track2,strBinesNo));
		track2 = "5010740010062219=2610526658";	
		System.out.println(track2 +" "+ esBinAceptado(track2,strBinesNo));
		track2 = "5010752310062219=2610526658";	
		System.out.println(track2 +" "+ esBinAceptado(track2,strBinesNo));
		
		
		strBinesNo = "";//getProperty("com.atm.brou.depositos.bines.no.aceptados", "");
		System.out.println(strBinesNo);
		
		track2 = "4213000010062219=2610526658";
		System.out.println(track2 +" "+ esBinAceptado(track2,strBinesNo));
		track2 = "5010740010062219=2610526658";	
		System.out.println(track2 +" "+ esBinAceptado(track2,strBinesNo));
		track2 = "5010752310062219=2610526658";	
		System.out.println(track2 +" "+ esBinAceptado(track2,strBinesNo));
		
		strBinesNo = null;//getProperty("com.atm.brou.depositos.bines.no.aceptados", "");
		System.out.println(strBinesNo);
		
		track2 = "4213000010062219=2610526658";
		System.out.println(track2 +" "+ esBinAceptado(track2,strBinesNo));
		track2 = "5010740010062219=2610526658";	
		System.out.println(track2 +" "+ esBinAceptado(track2,strBinesNo));
		track2 = "5010752310062219=2610526658";	
		System.out.println(track2 +" "+ esBinAceptado(track2,strBinesNo));
		
		strBinesNo = null;//getProperty("com.atm.brou.depositos.bines.no.aceptados", "");
		System.out.println(strBinesNo);
		track2 = null;
		System.out.println(track2 +" "+ esBinAceptado(track2,strBinesNo));
		
		
		strBinesNo = "501074,50107523";//getProperty("com.atm.brou.depositos.bines.no.aceptados", "");
		System.out.println(strBinesNo);
		track2 = null;
		System.out.println(track2 +" "+ esBinAceptado(track2,strBinesNo));
		
	}


	private static boolean esBinAceptado(String track2,String strBinesNo){

		boolean ret = true ;

		if(strBinesNo != null && !strBinesNo.equals("") && track2 !=null && !track2.equals("")){

			String[] binesNo = strBinesNo.split(",");

			for (String binNo : binesNo) {
				if(binNo.trim().equals(track2.substring(0, binNo.length()))){
					ret = false;
					break;
				}
			}
		}

		return ret;
	}

	

	/**
	 * @param montoCredito
	 * @return
	 */
	private static String fomartoArchivoScotia(String montoCredito) {

		if(montoCredito!=null && montoCredito.contains(".")){
			String[] lala = montoCredito.split("\\.") ;
			
			if(lala[1].length()==1){
				montoCredito = montoCredito.replace(".", "")+"0";
			}else{
				montoCredito = montoCredito.replace(".", "");
			}

		}

		return montoCredito;
	}

	
	private static String campo35toNroTarjeta(String campo35){
		
		//<field id="35" value="4213000010062219=2610526658"/>

		return  campo35.split("=")[0];
	}
	
	
	
	
	
}
