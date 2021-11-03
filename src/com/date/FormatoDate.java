package com.pruebas.date;

import java.sql.Time;



public class FormatoDate {

	public static String formadoDHMS(long segundos){
		return segundos/86400 +" "+new Time(segundos*1000).toString();
	}



	public static void main(String[] args) {
		System.out.println(formadoDHMS(86400));
		System.out.println(formadoDHMS(86401));
		System.out.println(formadoDHMS(86399));
		System.out.println(formadoDHMS(186399));
		System.out.println(formadoDHMS(869));
		System.out.println(formadoDHMS(654654564654L));
	}


}
