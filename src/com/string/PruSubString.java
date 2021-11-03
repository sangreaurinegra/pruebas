package com.string;

import com.util.StringUtilities;

public class PruSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String str = "000001000274";
		
		System.out.println(str.substring(0, 6));
		
		
		String processCode = "123456";
		int tipoCta = Integer.valueOf(processCode.substring(2,4));
		System.out.println(tipoCta);
		
		int largo  = 8 ;
		System.out.println("Prueba largoFijoPad0Izq");
		System.out.println(largoFijoPad0Izq("1234",largo));
		System.out.println(largoFijoPad0Izq("12345678",largo));
		System.out.println(largoFijoPad0Izq("1",largo));
		System.out.println(largoFijoPad0Izq("",largo));
		System.out.println(largoFijoPad0Izq(null,largo));
		System.out.println(largoFijoPad0Izq("1234567890123456789",largo));
		System.out.println(largoFijoPad0Izq("1234",-1));
		
		
		String nroTransaccionAtm = "123456789012";
		int leng = nroTransaccionAtm.length();
		
		System.out.println(nroTransaccionAtm);
		System.out.println(nroTransaccionAtm.substring(leng-6,leng));
		
		
	}
	
	
	public static String largoFijoPad0Izq(String entrada, int largo){
		String ret = "";
		if (largo > 0){
			if (entrada == null || entrada.length()<largo){
				ret = StringUtilities.padLeft((entrada == null)? "" : entrada , largo, '0');
			}else{
				ret = entrada.substring(0, largo);
			}
		}
		return ret ;
	}

}
