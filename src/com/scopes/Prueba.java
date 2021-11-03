package com.scopes;

public class Prueba {

	public int x = 10;
	public int y = 20;

	public void Funcion1() {
		System.out.println(x + y);
	}

	public void Funcion2() {
		int x = 0;
		Funcion1();
		x = x++;
		x--;
	}

	public void Funcion3() {
		int y = 0;
		Funcion2();
		y = y++;
		y--;
	}

	public static void main(String[] args) {
		Prueba pru = new Prueba();
		pru.Funcion1();
		pru.Funcion2();
		pru.Funcion3();
	}

}
