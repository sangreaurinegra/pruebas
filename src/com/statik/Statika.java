package com.statik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public class Statika {
	
	private static Map<String, String> mapaStatico;
	
	static{
		
		mapaStatico = new Hashtable<String, String>();
		
	}

	public void agregar(String clave, String valor){
		mapaStatico.put(clave, valor);
	}
	
	public void limpiar(){
		mapaStatico.clear();
	}	
	
	public void imprimir(){
		ArrayList<String> claves = new ArrayList<String>(mapaStatico.keySet());
		Collections.sort(claves);
		System.out.println("[");
		for (String clave : claves) {
			System.out.println(clave+" - "+mapaStatico.get(clave));
		}
		System.out.println("]");
		System.out.flush();
	}
	
}
