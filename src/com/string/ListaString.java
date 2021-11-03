package com.string;

import java.util.ArrayList;
import java.util.List;

public class ListaString {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> deposPreparados = new ArrayList<String>();
		
		deposPreparados.add("222");
		deposPreparados.add("321");
		deposPreparados.add("123");
		deposPreparados.add("111");
		deposPreparados.add("333");
		deposPreparados.add("111");
		deposPreparados.add("888");
		
		String buscado = "123";
		if(deposPreparados.contains(buscado)){
			System.out.println("Contiene el String "+buscado);
		}else{
			System.out.println("NO contiene el String "+buscado);
		}
		
		buscado = "999";
		if(deposPreparados.contains(buscado)){
			System.out.println("Contiene el String "+buscado);
		}else{
			System.out.println("NO contiene el String "+buscado);
		}
		
		buscado = "111";
		if(deposPreparados.contains(buscado)){
			System.out.println("Contiene el String "+buscado);
		}else{
			System.out.println("NO contiene el String "+buscado);
		}
		
		System.out.println(deposPreparados);
				
		deposPreparados.remove("333");
		
		buscado = "333";
		System.out.println("Remove " + buscado);
		if(deposPreparados.contains(buscado)){
			System.out.println("Contiene el String "+buscado);
		}else{
			System.out.println("NO contiene el String "+buscado);
		}
		
		System.out.println(deposPreparados);
		
		deposPreparados.remove("111");
		
		buscado = "111";
		System.out.println("Remove " + buscado);
		if(deposPreparados.contains(buscado)){
			System.out.println("Contiene el String "+buscado);
		}else{
			System.out.println("NO contiene el String "+buscado);
		}
		
		System.out.println(deposPreparados);
		
	}

}
