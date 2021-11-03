package com.operadores;

public class mod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub0000004215
		String strTipocambio = "0000004215";
		
		double dblTipocambio = 0.0 ;
		
		double piCmp75 = Double.valueOf(strTipocambio);
		
		// int piCmp75 = Integer.valueOf(strTipocambio);
		
		
		System.out.println(piCmp75);
		
		dblTipocambio = piCmp75/100;
		
		//dblTipocambio =+ (piCmp75%100);
		
		System.out.println("Tipocambio " + dblTipocambio);
		
		
		
	}

}
