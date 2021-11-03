package com.map;

import java.util.HashMap;
import java.util.Map;

public class PruMapSerialize {
	
	
	public static void main(String[] args) {
		
		
		
		/*
		              <Rubro>140102001</Rubro>
                     <Moneda>0</Moneda>
                     <Papel>0</Papel>
                     <Cuenta>301414</Cuenta>
                     <Operacion>0</Operacion>
                     <Sub_Operacion>3</Sub_Operacion>
                     <Tipo_Operacion>1</Tipo_Operacion>
                     <Modulo>20</Modulo>
		 */
		
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("Sucursal", "1");
		map.put("Rubro", "140102001");
		map.put("Moneda", "0");
		map.put("Papel", "0");
		map.put("Cuenta", "301414");
		map.put("Operacion", "0");
		map.put("Sub_Operacion", "3");
		map.put("Tipo_Operacion", "1");
		map.put("Modulo", "20");
		
	
		
		System.out.println();
		
	}


}
