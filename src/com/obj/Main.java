package com.obj;

public class Main {

	private static void tratoDeNulearlo(Clase objeto){
		objeto = null;
	}
	
	private static void cambioValores(Clase objeto){
		objeto.setiAtribuo1(123);
		objeto.setsAtributo2("Cambio");
	}
	
	
	public static void main(String[] args) {
		
		
		Clase objeto = new Clase();
		objeto.setiAtribuo1(1);
		objeto.setsAtributo2("Uno");
		
		System.out.println(objeto.toString());
		
		tratoDeNulearlo(objeto);
		
		System.out.println(objeto);
		
		cambioValores(objeto);
		
		System.out.println(objeto);
		
		objeto = null;
		
		System.out.println(objeto);
		
	}
	
}
