package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.util.DateUtilities;

public class DateUtilitiesTest {

	
	public static void main(String[] args) {
		
		Date now = new Date();
		
		System.out.println(DateUtilities.toString(now, DateUtilities.AAAAMMDD_DATE_FORMAT));
		
		System.out.println(DateUtilities.toString(now,"yyyy-MM-dd"));
		
	
		System.out.println("Simple Date Format");
		System.out.println( new SimpleDateFormat().format(now) );
		System.out.println( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now) );
		
		System.out.println( new SimpleDateFormat("HHmmss").format(now) );
		System.out.println( new SimpleDateFormat("MMdd").format(now));
		
		
		String dateStr="20150915235911";
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		 try {
			System.out.println( formatter.parse(dateStr) );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 System.out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(new Date()).toString());
		 System.out.println((new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")).format(new Date()).toString());
		 
		 
		 
		 System.out.println(DateUtilities.toDate("20/12/2015","dd/MM/yyyy"));
		
		 
		 System.out.println(new SimpleDateFormat("MMdd").format(new Date()));
		 
		
		System.out.println("Fin");
		
	}
	
}
