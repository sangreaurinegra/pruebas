package com.math;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class pruMath {

	
	public static void main(String[] args) {
		
//		int cantSalidas = (25*36)/20;
//		System.out.println(cantSalidas);
//		
//		cantSalidas = (26*36)/20;
//		System.out.println(cantSalidas);
//		
//		double dCantSalidas = ((26*36)/20.0) ;
//		
//		System.out.println(dCantSalidas);
//		System.out.println(Math.round(dCantSalidas));
//		
//		
//		int num = 12;
//		
//		System.out.println("num ->"+num);
//		num -=2;
//		System.out.println("num -=2 -> "+num);
//		
//		
//		int pruDiv = (12*100)/25;
//		System.out.println("(12*100)/25 -> "+pruDiv);
//		pruDiv = (12*100)/24;
//		System.out.println("(12*100)/24 -> "+pruDiv);
//		pruDiv = (12*100)/23;
//		System.out.println("(12*100)/23 -> "+pruDiv);
//		pruDiv = (12*100)/12;
//		System.out.println("(12*100)/12 -> "+pruDiv);
//		
//		
//		int setDouble = 125/100;
//		System.out.println("125/100 -> "+setDouble);
//		setDouble = 151/100;
//		System.out.println("151/100 -> "+setDouble);
//		setDouble = 99/100;
//		System.out.println("99/100 -> "+setDouble);
//		setDouble = 100/100;
//		System.out.println("100/100 -> "+setDouble);
//		
//		
//		Integer a = 1;
//		
//		int b = new Integer(2);
//		
//		System.out.println("a " + a);
//		System.out.println("b " + b);
//		
//		System.out.println("b " + (a-1));
//		
//		HashMap<Long, String> mapa = new HashMap<Long, String>();
//		
//		mapa.put(1L,"algo");
//		
//		long la = 2L;
//		
//		mapa.put(la,"algo 2");
		
		HashMap<Integer, Integer> canales = new HashMap<Integer, Integer>();
		
		int canalRandom = 0;
//		
//		System.out.println(canalRandom);
		
		for(int i = 0 ; i< 100000 ; i++){
			
			//int random = ;
			
			canalRandom = 1+(Math.abs((new Random()).nextInt())%5);
			int cant = canales.get(canalRandom) == null ? 0 : canales.get(canalRandom) ;
			cant++ ;
			canales.put(canalRandom, cant);
		}
		
		
		Set<Integer> setCanales = canales.keySet();
		
		List<Integer> listaCanales = new ArrayList<Integer>();
		
		for (Integer canal : setCanales) {
			listaCanales.add(canal);
		}
		
		Collections.sort(listaCanales);
		
		for (Integer canal : listaCanales) {
			System.out.println(canal+" - "+canales.get(canal));
		}
		
		
	}
}
