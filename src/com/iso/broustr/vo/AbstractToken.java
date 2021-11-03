package com.iso.broustr.vo;

public abstract class AbstractToken {
	
	protected String eyeCatcher;
	
	protected int length;
	
	public AbstractToken(String eyeCatcher, int length) {
		super();
		this.eyeCatcher = eyeCatcher;
		this.length = length;
	}

	public String getEyeCatcher() {
		return eyeCatcher;
	}

	protected void setEyeCatcher(String eyeCatcher) {
		this.eyeCatcher = eyeCatcher;
	}
	
	public int getLength() {
		return length;
	}

	protected void setLength(int length) {
		this.length = length;
	}

	public int addLength(int addL){
		this.length += addL ;
		return this.length ;
	}
	
	
	
}
