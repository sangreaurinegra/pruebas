package com.string;

public class Matcheo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "32132adas3a1d3as1das3ads13d2213";
		String str2 = "32132 adas3a1d3as 1das3ads13 d2213";
		
		String str3 = "32132adas3a1dñ3as1das3ads13d2213";
		String str4 = "32132a das3a1d3a_s1das 3ads13d2213";
		
		
		String str5 = "a";
		
		//[\b] 	Matches a backspace.
		// \d Matches a digit character. Same as [0-9] or [0123456789].
		// \w 	Matches any alphanumeric character incuding underscore. Equivalent to [A-Za-z0-9_].
		
		String regex = "[a-zA-Z0-9\\s]+";
		
		String str = str1 ;
		
		if(str.matches(regex)){
			System.out.println(str +" con "+regex+ " ando");
		}else{
			System.out.println(str +" con "+regex+ "No ando");
		}
		
		str = str2 ;
		
		if(str.matches(regex)){
			System.out.println(str +" con "+regex+ " ando");
		}else{
			System.out.println(str +" con "+regex+ "No ando");
		}
		
		str = str3 ;
		
		if(str.matches(regex)){
			System.out.println(str +" con "+regex+ " ando");
		}else{
			System.out.println(str +" con "+regex+ "No ando");
		}
		
		str = str4 ;
		
		if(str.matches(regex)){
			System.out.println(str +" con "+regex+ " ando");
		}else{
			System.out.println(str +" con "+regex+ "No ando");
		}
		
		str = str5 ;
		
		if(str.matches(regex)){
			System.out.println(str +" con "+regex+ " ando");
		}else{
			System.out.println(str +" con "+regex+ "No ando");
		}

		
	}

}
