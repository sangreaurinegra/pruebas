package com.string;

import com.util.NumberUtilities;

public class DoubleStr {

	public static void main(String[] args) {
		
//		double pdMonto = Double.parseDouble("000000005555") / 100 ;
//		String monto = pdMonto+"";
		
		double pDMonto = 10000.00; 
		String monto = NumberUtilities.format(pDMonto, 2);
		
		System.out.println("double pDMonto = 10000.00; "+pDMonto);
		System.out.println("NumberUtilities.format(pDMonto, 2);"+ monto);
		
		String monto2 = NumberUtilities.format(pDMonto, 2).replace(".", "");
		System.out.println("NumberUtilities.format(pDMonto, 2).replace(\".\", \"\"); "+monto2);
		
		
		System.out.println("---------------------------");
		
		double pdouble = 1111111.0092; 
		double pdoubleRound = (double)Math.round(pdouble * 100d) / 100d ;
		String pdoubleFormat = String.format("%.2f", pdouble);
		
		System.out.println("pdouble " + pdouble);
		System.out.println("pdoubleFormat " + pdoubleFormat);
		System.out.println("pdoubleRound " + pdoubleRound);
		
		System.out.println("remplace Format " + pdoubleFormat.replace(".", "").replace(",", ""));
		
		System.out.println("remplace Round y format " + (NumberUtilities.format(pdoubleRound, 2)).replace(".", "").replace(",", ""));
		
	}
	
}

