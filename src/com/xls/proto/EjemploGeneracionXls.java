package com.pruebas.xls.proto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

public class EjemploGeneracionXls {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Inicio Proto Generacion Xls");
		
		Collection staff = new ArrayList();
        staff.add(new Employee("Derek", 35, 3000, 0.30));
        staff.add(new Employee("Elsa", 28, 1500, 0.15));
        staff.add(new Employee("Oleg", 32, 2300, 0.25));
        staff.add(new Employee("Neil", 34, 2500, 0.00));
        staff.add(new Employee("Maria", 34, 1700, 0.15));
        staff.add(new Employee("John", 35, 2800, 0.20));
        Map beans = new HashMap();
        beans.put("employee", staff);
        XLSTransformer transformer = new XLSTransformer();
        try {
			transformer.transformXLS("/iobox/in/employees2.xls", beans, "/iobox/out/salidaProto.xls");
		} catch (ParsePropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Fin Proto Generacion Xls");
		
	}

}
