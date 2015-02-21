package com.hackathon.pharmaguide;

public class CommonNamesDataModel {
	private String commonId;
	private String commonName;
	
	public CommonNamesDataModel() {
		super();
	}

	public CommonNamesDataModel(String commonId, String commonName) {
		super();
		this.commonId = commonId;
		this.commonName = commonName;
	}

	public String getCommonId() {
		return commonId;
	}

	public void setCommonId(String commonId) {
		this.commonId = commonId;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	
}
