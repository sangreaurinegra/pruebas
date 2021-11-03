package com.string;

public class SubCodBarrasItau {
	
	public static void main(String[] args) {
		
//		<field number="54" value=" 00000000000 000000000000000000000000000000000000000AID001012599278000011207210609001000001"/>
		String campo54 = " 00000000000 000000000000000000000000000000000000000AID001012599278000011207210609001000001";
		String codigoBarras = campo54.substring(52); //AID 001012599278000011207210609001000001
		
		String prefijo = codigoBarras.substring(0,3); // largo 3
		String nroTransaccionATM = codigoBarras.substring(3,15);//largo 12
		String idCliente = codigoBarras.substring(15,19);  //largo 4
		String moneda = codigoBarras.substring(19,20);  //largo 1
		String fechaAAMMDD = codigoBarras.substring(20,26);  //largo 6
		String horaHHMM = codigoBarras.substring(26,30);  //largo 4
		String importe = codigoBarras.substring(30,38);  //largo 8
		String digitoVerificador = codigoBarras.substring(38);
		
		System.out.println(codigoBarras);
		System.out.println();
		System.out.println("prefijo           "+prefijo  ); 
		System.out.println("nroTransaccionATM "+nroTransaccionATM  );  
		System.out.println("idCliente         "+idCliente  );  
		System.out.println("moneda            "+moneda  );  
		System.out.println("fechaAAMMDD       "+fechaAAMMDD  );  
		System.out.println("horaHHMM          "+horaHHMM  );  
		System.out.println("importe           "+importe  );  
		System.out.println("digitoVerificador "+ digitoVerificador ); 

		
		
		
	}

}
