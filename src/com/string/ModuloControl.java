package com.string;

public class ModuloControl {
	
    public static String metodoControlModulo10(String cadena) {

        int dc = 0; // Inicializo el digito de control

        for (int i = 0; i < cadena.length(); i++) {
            String caracter = String.valueOf(cadena.charAt(i));
            int digito = Integer.parseInt(caracter);

            dc += (i % 2 == 0) ? ((digito < 5) ? digito * 2 : digito * 2 - 9) : digito;
        }
        dc = ((dc % 10) == 0) ? (dc % 10) : 10 - (dc % 10);

        return String.valueOf(dc);
    }
	
    public static void main(String[] args) {

    	//nroTrasaccionATM(6)+fecha(6)+hora(2)+minutos(2)+idCliente(4)+importe(8)+moneda(1);
    	//String cadena = "00766918081615080000000024001"; //ATS007669180816150800000000240016
    	
    	String cadena = "00766718081612460000000017001";//ATS007667180816124600000000170014
    	
    	
    	String dc = metodoControlModulo10(cadena);
    	

    	System.out.println("cadena "+cadena);
    	System.out.println("dc " + dc);
    	
    	
    }

}
