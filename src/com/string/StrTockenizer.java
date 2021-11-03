package com.string;

import java.util.StringTokenizer;

import com.util.StringUtilities;

public class StrTockenizer {
	
	
	public static void main(String[] args) {
		// esta deprecada el stringtockenizer , pero par alo desarrollado lo pruebo
		
		//"01|000001|200201 |Datos^Adicionales^123" antes -> <field id="59" value="01|010101|tipoSeleccion^titulo "/>
		//String strAntes = "01|010101|tipoSeleccion^titulo ";
		String strAntes = "01|200201 |Datos^Adicionales^123 ";
		String strNueva = "01|000001|200201 |Datos^Adicionales^123 ";
		procesar(strAntes);
		procesar(strNueva);
		
		procesarSplit(strAntes);
		procesarSplit(strNueva);
		
		
		
		
		

		
		String campo59 = "01|";
		
		String campo124 = "";
		
		String[] stTok124= campo124.split("\\|");
			
			String tipoSeleccion =   stTok124[0]; // 83 , 40 etc
			String titulo = stTok124[1];  //FECH NACIMIENTO ... ETC 
			campo59 += titulo+"|"; //titulo
			campo59 += stTok124[2]+"|"; //opciones
			campo59 += tipoSeleccion+"^"+titulo; // envío valores de retorno para no mantener estado en opcion sleccionada con separador ^
		
		
			System.out.println("Campo -->"+campo59);
		
	}

	/**
	 * @param strEntrada
	 */
	private static void procesar(String strEntrada) {
		String campo124 = null;
		StringTokenizer stTok59= new StringTokenizer(strEntrada, "|");
		int cantTokens = stTok59.countTokens();
		
		stTok59.nextToken(); // lo descarto  el command del mx (01)
		
		if(cantTokens==4){
			System.out.println("123 -->"+StringUtilities.padLeft(stTok59.nextToken(), 12, '0'));
		}
		
		String opcion = stTok59.nextToken();

		StringTokenizer stTokEstado= new StringTokenizer(stTok59.nextToken(), "^");//tipoSeleccion^titulo

		campo124 = stTokEstado.nextToken() +"|"; // tipo seleccion
		campo124 += stTokEstado.nextToken() +"|";//titulo
		campo124 += opcion + "|"; //opcion
		campo124 += "idTerminalMiniATM";//codigo de corresponsal AG,Sub
		
		System.out.println("124 -->"+campo124);
	}
	

	/**
	 * @param strEntrada
	 */
	private static void procesarSplit(String strEntrada) {
		String campo124 = null;
		
		// StringTokenizer stTok59 = new StringTokenizer(strEntrada, "|");
		
		String[] stTok59 = strEntrada.split("\\|");
		
		int cantTokens = stTok59.length;
		
		//stTok59.nextToken(); // lo descarto  el command del mx (01)
		
		String[] stTokEstado = null;
		String opcion = null;
		
		if(cantTokens==4){
			System.out.println("123 -->"+StringUtilities.padLeft(stTok59[1], 12, '0'));
			opcion = stTok59[2];
			stTokEstado = stTok59[3].split("\\^");
		}else{
			opcion = stTok59[1];
			stTokEstado = stTok59[2].split("\\^");
		}
		
		campo124 = stTokEstado[0] +"|"; // tipo seleccion
		campo124 += stTokEstado[1] +"|";//titulo
		campo124 += opcion + "|"; //opcion
		campo124 += "idTerminalMiniATM";//codigo de corresponsal AG,Sub
		
		System.out.println("124 -->"+campo124);
		
	}
	
}
