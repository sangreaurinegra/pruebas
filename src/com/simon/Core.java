package com.simon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Core {
	public static Integer ERROR =-1;
	public static Integer ERROR_INTERNO =-2;
	private static Core instance;
	private static  int n = 4; //cantidad de botones
	private static ArrayList<Integer> secuencia = new ArrayList<Integer>();
	private static ArrayList<Integer> retorno = new ArrayList<Integer>();
	private int index = 0;
	
	private Core() {
	}

	public static Core getInstance() {
		if (null == instance) {
			instance = new Core();
		}
		return instance;
	}
	
	public int Ini(){
		if(secuencia.size()>0){
			secuencia = new ArrayList<Integer>();
		}
		int ret = nuevoNumero();
		secuencia.add(ret);
		index=0;
		return ret;
	}
	
	public ArrayList<Integer> jugar( int i ){
		
		if(index < secuencia.size()){
			if(secuencia.get(index) == i ){
				
				return null;
			}

			return null;
		}else{
			retorno.clear();
			
			retorno.add(ERROR_INTERNO);
			
			return retorno;
		}
	}
	
	public void setN(int n) {
		this.n = n;
	}
	
	public int getN() {
		return n;
	}
	
	private int nuevoNumero(){
		return (int) (Math.random()*100 % n); //TODO cambiar clase para ME
	}
	
	
	
	public static void main(String[] args) {
		
		
		Core core = getInstance();
		
		core.Ini();
		
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader (isr);
		String lineaTeclado = "";
	
		boolean salir = false;
		
		while(!salir){
			
			try {
				lineaTeclado = bf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (lineaTeclado.equalsIgnoreCase("Exit")){
			 salir = true;	
			}else{
				
			}
			
		}
		
	}
	
}
