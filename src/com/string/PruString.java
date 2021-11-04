package com.string;

import java.util.StringTokenizer;



public class PruString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		String pru = "2,3,4,226,";
//		System.out.println(pru);
//		System.out.println(pru.substring(0, pru.length()-1));
//		System.out.println(pru.substring(0, pru.length()));
		
//		String uno = "este no tiene 64";
//		String dos = "este si tiene mas de ****************************************************************************************************************************************************************tiene 64";
//		String tres = "este si tiene mas de ******************************************0";
//		
//		if(uno.length()>=64)
//			System.out.println("uno "+uno.substring(0, 64));
//		else
//			System.out.println(uno.length());
//		
//		System.out.println("dos "+dos.substring(0, 64));
//		
//		System.out.println("tres "+tres.substring(0, 64));
		
//	
//		String nombreArchivo1="/home/algo//in/kit_nombre.csv";
//		String nombreArchivo2="/home/otro//lala/malo_nombre.csv";
//		String nombreArchivo3="\\home\\otro\\\\lala\\noPrefNombre.csv";
//		String nombreArchivo4="\\home\\otro\\\\lala\\KiT_PrefNombre.csv";
//		
//		List<String> nombresArchivos=new ArrayList<String>();
//		nombresArchivos.add(nombreArchivo1);
//		nombresArchivos.add(nombreArchivo2);
//		nombresArchivos.add(nombreArchivo3);
//		nombresArchivos.add(nombreArchivo4);
//		
//		for (String nombreArchivo : nombresArchivos) {
//			System.out.println(nombreArchivo+" "+procesarPrefijo(nombreArchivo));
//		}		
//		 
		 
		
		
//		String terminal = "ATM08800";
//		
//		System.out.println(terminal.substring(4, 7));
		
		
//		String cmp54 = "CCCCCCCCCCCCDDDDDDDDDDDDOOOOOOOOOOOOOOTTTTTTTTTTTTTTBBBBBBBBBBBBBBBVVVVVVVVVVVVVVVV";
//		
//		String psC = cmp54.substring(0, 12);
//		String psD = cmp54.substring(12, 24);
//		String psO = cmp54.substring(24, 38);
//		String psT = cmp54.substring(38, 52);
//		String psB = cmp54.substring(52, 67);
//		String psV = cmp54.substring(67, 83);
//		
//		System.out.println("CCCCCCCCCCCC");
//		System.out.println(psC);
//		System.out.println("DDDDDDDDDDDD");
//		System.out.println(psD);
//		System.out.println("OOOOOOOOOOOOOO");
//		System.out.println(psO);
//		System.out.println("TTTTTTTTTTTTTT");
//		System.out.println(psT);
//		System.out.println("BBBBBBBBBBBBBBB");
//		System.out.println(psB);
//		System.out.println("VVVVVVVVVVVVVVVV");
//		System.out.println(psV);
		
		
//		String entrada = "000121213100987022";
//		System.out.println(pasarABin(entrada));
		
		
//		String campo44  = "3000016606967000016606677         0500000230050000092";
//		String campo44X = "3000016606967000016606677XXXXXXXXX0500000230050000092";
//		procesarCampo44(campo44);
//		
//		procesarCampo44(campo44X);
		
		
//		String nroTrasaccionATM = "1234567";
//		nroTrasaccionATM = nroTrasaccionATM.substring(nroTrasaccionATM.length()-6);
//		System.out.println(nroTrasaccionATM);
		
		
//		String formato = "yyyy-MM-dd'T'HH:mm:ss.SSS";
//		
//		String fecha = (new SimpleDateFormat(formato).format(new Date()).toString());
//		
//		String anio = fecha.substring(2, 4);
//		String mes = fecha.substring(5, 7);
//		String dia = fecha.substring(8, 10);
//		
//		String hora = fecha.substring(11, 13);
//		String minutos =  fecha.substring(14, 16);
//		
//		
//		System.out.println(fecha);
//		System.out.println("dia "+dia);
//		System.out.println("mes "+mes);
//		System.out.println("anio "+anio);
//		System.out.println("hora "+hora);
//		System.out.println("minutos "+minutos);
		
		
//		String dos = new String(new char[2]).replace("\0", "0")+"01" ;
//		
//		
//		String algo =  new String(new char[18]).replace("\0", "0");
//		
//		System.out.println(dos);
//
//		System.out.println(algo);
		
//		double importe = 100.01;
//		String amount = String.valueOf(importe);
//		System.out.println(amount);
		
		
//		//String sucursalCre = "123";
//		double importeDouble = 322;
//		String amount = NumberUtilities.format(importeDouble, 2).replace(".", "").replace(",", "");
//		
//		String formatted = (new String(new char[9]).replace("\0", "0") +amount).substring(amount.length());//String.format("%012d", transaccionATM.getNroSucursalCre());
//		System.out.println(formatted);
		
//		System.out.println(erroresScotiaToTrasaccionAtm(null));
//		System.out.println(erroresScotiaToTrasaccionAtm(""));
//		System.out.println(erroresScotiaToTrasaccionAtm("1"));
//		System.out.println(erroresScotiaToTrasaccionAtm("01"));
//		System.out.println(erroresScotiaToTrasaccionAtm("-1"));
//		System.out.println(erroresScotiaToTrasaccionAtm("-01"));
//		System.out.println(erroresScotiaToTrasaccionAtm("-10001"));
//		System.out.println(erroresScotiaToTrasaccionAtm("-10000001"));
//		
		String getIdTx1 = "321";
		String getIdTx2 = "1234567890";
		
		System.out.println((new String(new char[7]).replace("\0", "0") + getIdTx1).substring(getIdTx1.length()));
		
		System.out.println((new String(new char[7]).replace("\0", "0") + getIdTx2).substring(getIdTx2.length()));
		
	}
	
	
	
	public static String erroresScotiaToTrasaccionAtm(String errorScotia){
		
		String ret = errorScotia ;  
		
		if(errorScotia != null && errorScotia.length() > 2) {
			ret = errorScotia.substring(errorScotia.length()-2);
		}
		
		return ret;
	}
	
	private static void procesarCampo44(String campo44){
		
		 System.out.println("campo44 "+campo44);
		
		 String saldoContable = "000000000000";
		  String saldoDisponible = "000000000000";
		  String nroDeCuenta = "0000000000000000000000000000";
		  					// "XXXXXXXXX0500000230050000092";
		  // C12 D12 O14 T14 B15 V16 
		  int indicadorUso = Integer.parseInt(campo44.substring(0, 1));
          
         switch (indicadorUso) {
           case 0:
            // seteados en creacion
             break;
           case 1:
           	saldoContable = campo44.substring(1, 13); 	// Saldo contable 
             break;
           case 2:
           	saldoDisponible = campo44.substring(13,25); 	// Saldo disponible
             break;
           case 3:
           	saldoContable = campo44.substring(1, 13); 	// Saldo contable 
            saldoDisponible = campo44.substring(13,25); 	// Saldo disponible
             break;
           case 4:
           	saldoContable = campo44.substring(1, 13); 	// Saldo contable 
            saldoDisponible = campo44.substring(13,25); 	// Saldo disponible
           
             break;
             
           default:  
             System.out.println("Error en el indicador de uso del saldo del mensaje 0210");
             throw new RuntimeException();
         }
         
         nroDeCuenta =   campo44.substring(25).trim();
         
         System.out.println("saldoContable "+saldoContable);
         System.out.println("saldoDisponible "+saldoDisponible);
         System.out.println("nroDeCuenta "+nroDeCuenta);
	}
	
	private static int procesarPrefijo(String nombreArchivo){
		int ret=0;
		String separador="";
		if(nombreArchivo.matches(".*/.*")){
			separador = "/";
		}else{
			if(nombreArchivo.matches(".*\\.*")){
				separador = "\\";
			}
		}
		StringTokenizer stoken = new StringTokenizer(nombreArchivo, separador);
		String nombreArchivoSinRuta="";
		while(stoken.hasMoreTokens()){
			nombreArchivoSinRuta=stoken.nextToken();
		}
		nombreArchivoSinRuta = nombreArchivoSinRuta.toUpperCase();
		
		if(nombreArchivoSinRuta.matches("KIT_.*")){
			ret=1;
		}
		return ret;
	}
	
	 public static String pasarABin(String in){
  	   
//  	   for (int i = 0; i < in.length(); i++){
//  		   in.
//  		   
//  	   }
		 
		
		 
  	   
  	   String ret = "";
  	   
  	 ret = in.replaceAll("[1-9]", "1");
  	   
  	   
  	   return ret;
     }
	
	
	

}
