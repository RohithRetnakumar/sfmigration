package com.reds.service.cassandraloader.dos;

public class ProductKey {

	private String fgCode;

	public String getFgCode() {
		return fgCode;
	}

	public void setFgCode(String fgCode) {
		this.fgCode = fgCode;
	}

	public ProductKey(String fgCode) {
		super();
		this.fgCode = fgCode;
	}

	public ProductKey() {
		super();
	}

}
