package com.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EnteroToFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		
		escribirFile(a);
		
		int b = leerFile(); 
		System.out.println(b);
		
		b++;
		
		escribirFile(b);
		
		int c = leerFile(); 
		
		System.out.println(c);
		
	}

	private static int leerFile() {
		try {
			FileInputStream fileIn;

			fileIn = new FileInputStream("idx");

			ObjectInputStream entrada=new ObjectInputStream(fileIn);
			int ret = (Integer)entrada.readObject();
			
			entrada.close();
			
			return ret;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0 ;
	}

	private static void escribirFile(int a) {
		try {
		
		FileOutputStream fileOut;
		
		fileOut = new FileOutputStream("idx");
	
		ObjectOutputStream salida=new ObjectOutputStream(fileOut);
		
		salida.writeObject(a);
		salida.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
