package com.pruebas.xls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.online.bt.comisiones.vo.LiquidacionComisionLocal;
import com.online.bt.comisiones.vo.repo.ChequeImport;
import com.online.bt.entidades.vo.FamiliaEntidad;
//import com.util.DateUtilities;
import com.online.bt.locales.vo.Local;
import com.online.bt.general.vo.Moneda;

import net.sf.jxls.transformer.XLSTransformer;



public class GeneroXls {

	public static void cargarDatosEnListaLiquidacionesConCheque(List<LiquidacionComisionLocal> liquidacionesConCheque){
		LiquidacionComisionLocal liquidacionComisionLocal = new LiquidacionComisionLocal();
		
		Local local = new Local();
		local.setNroAgencia(97);
		local.setNroSubAgencia(0);
		//liquidacionComisionLocal.setSaldoMN(1234);
		liquidacionComisionLocal.setFechaHora(new Date());
		liquidacionComisionLocal.setLocal(local);
		Moneda mon = new Moneda();
		mon.setSimbolo("$");
		liquidacionComisionLocal.setMonedaOrigen(mon);
		liquidacionComisionLocal.setTipoTransaccion(2); 
		liquidacionesConCheque.add(liquidacionComisionLocal);
		
		liquidacionComisionLocal = new LiquidacionComisionLocal();
		local = new Local();
		local.setNroAgencia(999);
		local.setNroSubAgencia(999);
		liquidacionComisionLocal.setSaldoMN(4321.12);
		liquidacionComisionLocal.setFechaHora(new Date());
		liquidacionComisionLocal.setLocal(local);
		liquidacionComisionLocal.setMonedaOrigen(mon);
		liquidacionComisionLocal.setTipoTransaccion(2); 
		liquidacionesConCheque.add(liquidacionComisionLocal);
		
		liquidacionComisionLocal = new LiquidacionComisionLocal();
		local = new Local();
		local.setNroAgencia(30);
		local.setNroSubAgencia(2);
		liquidacionComisionLocal.setSaldoMN(999.9);
		liquidacionComisionLocal.setFechaHora(new Date());
		liquidacionComisionLocal.setLocal(local);
		liquidacionComisionLocal.setMonedaOrigen(mon);
		liquidacionComisionLocal.setTipoTransaccion(2); 
		liquidacionesConCheque.add(liquidacionComisionLocal);
		
	}
	
	public static String pagoComisionConChequeXlsMail(
			List<LiquidacionComisionLocal> liquidacionesConCheque, Date fechaAsiento) throws IOException {
	
	//String mes = DateUtilities.obtenerMesLiteral(fechaAsiento);
	//String anio = DateUtilities.getYearAsString(fechaAsiento);
	final String NOMBRE_ARCHIVO_SALIDA = "salida.xls";//"Cheques para importar en SCO " + mes + " " + anio + ".xls";
	final String archivoSalidaAbsolutePath = "/iobox/out"+"/"+ NOMBRE_ARCHIVO_SALIDA;
	String templateReporte = "chequesComisionesAgenciaParaImportacion.xls";

	final String rootTemplate = "/iobox/in";
	
	templateReporte=rootTemplate+"/"+templateReporte;

	Collection plChequeImport = new HashSet();
	ChequeImport chequeImportAux;
	for (LiquidacionComisionLocal liquidacionComisionLocal : liquidacionesConCheque) {
		chequeImportAux = new ChequeImport();

		chequeImportAux.setNroAgencia(liquidacionComisionLocal.getLocal()
				.getNroAgencia());
		chequeImportAux.setNroSubAgencia(liquidacionComisionLocal.getLocal()
				.getNroSubAgencia());
		chequeImportAux.setSimboloMoneda(liquidacionComisionLocal
				.getMonedaOrigen().getSimbolo());
		chequeImportAux.setImporte(liquidacionComisionLocal.getSaldoMN());
		chequeImportAux.setFecha(liquidacionComisionLocal.getFechaHora());

		chequeImportAux.setFamiliaEntidad((int) FamiliaEntidad.ID_FAMILIA_ENTIDAD_LOCALES); 

		plChequeImport.add(chequeImportAux);
	}

	Map beans = new HashMap();

	beans.put("cheque", plChequeImport);

	XLSTransformer transformer = new XLSTransformer();
	transformer.transformXLS(templateReporte, beans, archivoSalidaAbsolutePath);
	//transformer.transformXLS("/iobox/in/chequesComisionesAgenciaParaImportacion.xls", beans, "/iobox/out/salida.xls");

	System.out.println("Generado xls " + NOMBRE_ARCHIVO_SALIDA);
	System.out.println("Template en " + templateReporte);

	System.out.println("Archivo generado " + archivoSalidaAbsolutePath);
	
	return "Finalizó Generacion Xls";
}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Inicio Generacion Xls");
		
		List<LiquidacionComisionLocal> liquidacionesConCheque = new ArrayList<LiquidacionComisionLocal>();
		cargarDatosEnListaLiquidacionesConCheque(liquidacionesConCheque);
		
		String msg="";
		try {
			msg = pagoComisionConChequeXlsMail(liquidacionesConCheque, new Date());

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Salida Final"+msg);
	}

}
