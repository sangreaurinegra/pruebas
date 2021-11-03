package com.operadores;

import com.online.bt.interfasesistemasexternos.sistemasfox.services.SistemasFoxServices;
import com.online.bt.transaccionescentral.vo.Partida;

public class xor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String salidaComun;
		String salidaXor;
		
		boolean estorno=true; 
		boolean esDebe=true;
		
		System.out.println("esDebe, estorno -> Algoritmo Comun | Algoritmo Xor");
		salidaComun=comun(esDebe, estorno);
		salidaXor=xor(esDebe, estorno);
		imprimirSalida(salidaComun, salidaXor, estorno, esDebe);
		
		estorno=false; 
		esDebe=true;
		salidaComun=comun(esDebe, estorno);
		salidaXor=xor(esDebe, estorno);
		imprimirSalida(salidaComun, salidaXor, estorno, esDebe);
		
		estorno=false; 
		esDebe=false;
		salidaComun=comun(esDebe, estorno);
		salidaXor=xor(esDebe, estorno);
		imprimirSalida(salidaComun, salidaXor, estorno, esDebe);
		
		
		estorno=true; 
		esDebe=false;
		salidaComun=comun(esDebe, estorno);
		salidaXor=xor(esDebe, estorno);
		imprimirSalida(salidaComun, salidaXor, estorno, esDebe);
		
	}

	private static void imprimirSalida(String salidaComun, String salidaXor,
			boolean estorno, boolean esDebe) {
		System.out.print(esDebe);
		System.out.print(" , ");
		System.out.print(estorno);
		System.out.print(" -> ");
		System.out.print(salidaComun);
		System.out.print(" | ");
		System.out.print(salidaXor);
		System.out.println();
	}

	private static String comun(boolean esDebe, boolean estorno){
		String salida = "";
		if (esDebe) {
			if (estorno)
				salida = "partidaH";
			else
				salida = "partidaD";
		} else {
			if (estorno)
				salida = "partidaD";
			else
				salida = "partidaH";
		}
		return salida;
	}
	
	private static String xor(boolean esDebe, boolean estorno){
		String salida = "";
		
		if (esDebe ^ estorno){
			salida = "partidaD";
		}else{
			salida = "partidaH";
		}
		
		return salida;
	}
	
}
