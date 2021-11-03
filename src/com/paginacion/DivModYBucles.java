package com.paginacion;

import java.util.Arrays;
import java.util.List;

public class DivModYBucles {



	/**
	 * @param args
	 */
	public static void main(String[] args) {


		//		int intLargo = 92641 ;
		//		
		//		int tamanioIter = 30000 ;
		//		
		//		int cantIter =  intLargo / tamanioIter ;
		//		
		//		for (int i = 0; i <= cantIter; i++) {
		//			
		//			int a = (tamanioIter*i);
		//			int b = a + tamanioIter - 1;
		//			if(b > intLargo){
		//				b = (intLargo % a)-1 ;
		//			}
		//			
		//			System.out.println("Iteracion "+i+"["+a+".."+b+"]");
		//			
		//		}
		
		Long[] spam = new Long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L };


		List<Long> partidasInvolucradas = Arrays.asList(spam);


		int intLargo = partidasInvolucradas.size();

		int tamanioIter = 3 ; //30000 ;

		int cantIter =  intLargo / tamanioIter ;

		for (int i = 0; i <= cantIter; i++) {

			int a = (tamanioIter * i);
			int b = a + tamanioIter;  //TODO corregir
			if(b > intLargo){
				b = intLargo  ; //(intLargo % a) - 1 ;  //TODO corregir
			}

			List<Long> partidasInvolucradasIter = partidasInvolucradas.subList(a, b);


			System.out.println("partidasInvolucradasIter "+ partidasInvolucradasIter);

			String parametrosPartidasInvolucradosIter = "";

			for (int j = 0; j < partidasInvolucradasIter.size(); j++) {
				parametrosPartidasInvolucradosIter += "?," ;
			}

			System.out.println("parametrosPartidasInvolucradosIter "+parametrosPartidasInvolucradosIter);

			parametrosPartidasInvolucradosIter = parametrosPartidasInvolucradosIter.substring(0, parametrosPartidasInvolucradosIter.length()-1); // quito la ultima coma

			System.out.println("parametrosPartidasInvolucradosIter "+parametrosPartidasInvolucradosIter);

			String  SQL_PARTIDAS_INVALIDAS = "select pl.IDPARTIDALOCAL from ONLINE.PARTIDALOCAL pl where pl.IDPARTIDALOCAL in ("+parametrosPartidasInvolucradosIter+") and pl.ESTADOVALIDEZ <> 1";

			System.out.println(SQL_PARTIDAS_INVALIDAS);


			//seteo los parametros
			int pos = 1 ;
			for (Long partidaInvolucrada : partidasInvolucradasIter) {
				System.out.println( (pos++) + ","+ partidaInvolucrada);
			}



		}  


	}
}

