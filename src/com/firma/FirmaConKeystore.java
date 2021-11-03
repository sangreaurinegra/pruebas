package com.firma;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;

import com.misc.Base64Utilities;
import com.util.SystemProperties;

import java.util.Base64;

public class FirmaConKeystore {

	
	private static String firmaBanred(List<String> fieldsValues) throws Exception {
		
	    String data = "";
	    for (String fv : fieldsValues) {
			data += fv;
	    }
	    
	    System.out.println("Campos concatenados"); // ();
	    System.out.println(data); //TODO Borrar
	    
//	    String keyPassword = SystemProperties.getInstance().getProperty(KEY_STORE_PASSWORD);
//	    String keysFilename = SystemProperties.getInstance().getProperty(KEY_STORE);
//		String keystoretype = SystemProperties.getInstance().getProperty(KEY_STORE_TYPE);
//		String keystorealias = SystemProperties.getInstance().getProperty(KEY_STORE_ALIAS);
//	    
//	    String keyPassword = "online";
//	    //String keysFilename = "/_DESA/app-server/appdomains/b2b-services/appconfig/cacerts";
//		String keystoretype = "JKS";
//		String keystorealias = "_test";
	    

    String keyPassword = "online";
    String keysFilename = "/_DESA/app-server/appdomains/fb-services-brou/appconfig/cacerts";
	String keystoretype = "JKS";
	String keystorealias = "banredfirmamsjs";

		
		/*
		 	com.financial.banred.keystore=/_DESA/app-server/appdomains/b2b-services/appconfig/cacerts
			com.financial.banred.keystore.password=online
			com.financial.banred.keystore.type=JKS
			com.financial.banred.keystore.alias=_test
		 */
		
		keysFilename = URLDecoder.decode( keysFilename, "UTF-8");
		keysFilename = new File( keysFilename).getPath();
		FileInputStream input = new FileInputStream(keysFilename);
	   
//	    String jks = archivoKey;
//	    URL url = getClass().getResource(jks);
//	    String keysFilename = URLDecoder.decode(url.getPath(), "UTF-8");
	   // File configFile = new File(keysFilename);
//	    keysFilename = new File(keysFilename).getPath();
//	    FileInputStream input = new FileInputStream(keysFilename);
		KeyStore keyStore = KeyStore.getInstance(keystoretype);//KeyStore.getInstance("JKS");
	    keyStore.load(input, keyPassword.toCharArray());
	    input.close();
	    PrivateKey key= (PrivateKey)keyStore.getKey(keystorealias,keyPassword.toCharArray()); // (PrivateKey)keyStore.getKey(channel,keyPassword.toCharArray());
	    Signature dsa =  Signature.getInstance("SHA1withDSA", "SUN");// Signature.getInstance( "SHA256withRSA"); //
	    dsa.initSign(key);
	    dsa.update(data.getBytes("UTF-8"));
	    
	    byte[] digitalSignature = dsa.sign();
	    
	    //String signature = new BASE64Encoder().encode(digitalSignature);
	    
	    ByteArrayInputStream baImpstr = new ByteArrayInputStream(digitalSignature);
		String signature = Base64Utilities.encode(baImpstr);
	    
		System.out.println("Firma");
		System.out.println(signature); 
		
		
		
		signature = Base64.getEncoder().encodeToString(digitalSignature);
		
		
		System.out.println(signature); 
		System.out.println(" ^^^^ Firma codificada con Base64.getEncoder().encodeToString(digitalSignature);");
		
	    return signature;
	    
	}
	
	public static void main(String[] args) {
		
		List<String> fieldsValues = new ArrayList<String>();
		fieldsValues.add("bibiti");
		fieldsValues.add("babiti");
		fieldsValues.add("bum");
		
		try {
			String firma = firmaBanred(fieldsValues);
			System.out.println(firma); 
			System.out.println("Largo "+firma.length());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 
	 
	 	private static String firmaBanred(List<String> fieldsValues) throws Exception { // firmaBanred(fieldsKeys,fieldsValues)

		String strFieldsValues = "";
		for (String fv : fieldsValues) {
			strFieldsValues += fv;
		}

		// Logger logger = LoggerFactory.getLogger(BANREDHelper.class);
		// logger.info("Campos concatenados");
		// logger.info(strFieldsValues);

		// String strFieldsKeys = "";
		// for (String fk : fieldsKeys) {
		// strFieldsKeys += fk+"-";
		// }
		// logger.info("Claves Campos concatenados");
		// logger.info(strFieldsKeys);

		String keyPassword = SystemProperties.getInstance().getProperty(KEY_STORE_PASSWORD);
		String keysFilename = SystemProperties.getInstance().getProperty(KEY_STORE);
		String keystoretype = SystemProperties.getInstance().getProperty(KEY_STORE_TYPE);
		String keystorealias = SystemProperties.getInstance().getProperty(KEY_STORE_ALIAS);

		keysFilename = URLDecoder.decode(keysFilename, "UTF-8");
		keysFilename = new File(keysFilename).getPath();
		FileInputStream input = new FileInputStream(keysFilename);

		KeyStore keyStore = KeyStore.getInstance(keystoretype);
		keyStore.load(input, keyPassword.toCharArray());
		input.close();
		PrivateKey key = (PrivateKey) keyStore.getKey(keystorealias, keyPassword.toCharArray());
		Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");
		dsa.initSign(key);
		dsa.update(strFieldsValues.getBytes("UTF-8"));

		byte[] digitalSignature = dsa.sign();

		ByteArrayInputStream baImpstr = new ByteArrayInputStream(digitalSignature);
		String signature = Base64Utilities.encode(baImpstr);

		// logger.info("Firma");
		// logger.info(signature); //TODO Borrar

		return signature;

	}
	 
	 */
	
}
