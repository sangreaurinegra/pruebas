package com.statik;

public class Prueba {


	public static void main(String[] args) {
		Statika stkMain = new Statika() ;

		new Thread(){
			public void run(){
				Statika stk = new Statika();
				stk.agregar("Thread 1 ", "1");
			}
		}.start();
		
		stkMain.imprimir();

		new Thread(){
			public void run(){
				Statika stk = new Statika();
				stk.agregar("Thread 2 ", "2");
			}
		}.start();

		stkMain.imprimir();

		new Thread(){
			public void run(){
				Statika stk = new Statika();
				stk.agregar("Thread 3 ", "3");
			}
		}.start();

		
		stkMain.imprimir();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stkMain.imprimir();
		
		stkMain.limpiar();
		
		stkMain.imprimir();
	}

}
