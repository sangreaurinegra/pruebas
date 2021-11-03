package com.iso.broustr.emv;

import java.util.HashMap;

import org.jpos.tlv.TLVMsg;

public abstract class BXEMVDataToken {
	
	public abstract void cargaValoresPorDefecto();
	
	public abstract String toStrFormat();
	
	public abstract void setBertTlvHash(HashMap<String, TLVMsg> hashTlv);
	
	

}
