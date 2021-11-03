package com.pruebas.mail;

import com.online.bt.general.services.GeneralServicesProvider;
import com.online.bt.general.vo.Mail;


public class EnvioMailAsincronico {

	public static void main(String[] args) {


		System.out.println("EnvioMailAsincronico Ini");
		
		
		try {
			GeneralServicesProvider provider = new GeneralServicesProvider();
			
			
			
			Mail mail = new Mail();
		   
		    mail.setAsunto("Asunto Mail prueba Desestimar");
		    mail.setTipoContenido("text/plain; charset=utf-8");
		    mail.setTipoCaracteresAsunto("utf-8");
		   
		    mail.setContenido("Cuerpo Mail prueba Desestimar");
		    
		    //mail.setGrupoCasillaPara();
//		    List<String> destinatariosPara = new ArrayList<String>();
//		    
//		    destinatariosPara.add("gabriel.centurion@com.uy");
		    
//		    mail.setDestinatariosPara(destinatariosPara);
		    
		    mail.setGrupoCasillaPara("LISTA_EMAIL_CAMBIO_ESTADO_SERVICIOS");
		    
//		    mail.setGrupoCasillaPara("DESARROLLO");
		    
			provider.enviarMailAsincronico(mail);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("EnvioMailAsincronico Fin");
	}

}
