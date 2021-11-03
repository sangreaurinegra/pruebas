package com.string;

public class StrNull {

	public static void main(String[] args) {

		int ret = -1 ;

		String algo = null ;

		if("".equals(algo)){
			ret = 1;
		}

		System.out.println(ret);
		System.out.println(algo);

		if("".equalsIgnoreCase(algo)){
			ret = 2;
		}

		System.out.println(ret);
		System.out.println(algo);
	}
	
	
	public void metodo1(String lala, String lolo){
		
		String algo = lala+"concateno"+lolo;
		
		metodo2(algo);
		
		metodo3(lolo,lala);

	}


	private void metodo3(String lolo, String lala) {
		// TODO Auto-generated method stub
		
	}


	private void metodo2(String algo) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}







