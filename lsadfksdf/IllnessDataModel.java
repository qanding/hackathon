package com.hackathon.pharmaguide;

public class IllnessDataModel {
	private String illID;
	private String illName;
	
	public IllnessDataModel() {
		super();
	}

	public IllnessDataModel(String illID, String illN) {
		super();
		this.illID = illID;
		this.illName = illN;
	}

	public String getIllID() {
		return illID;
	}

	public void setIllID(String illID) {
		this.illID = illID;
	}

	public String getIllN() {
		return illName;
	}

	public void setIllN(String illName) {
		this.illName = illName;
	}
	
}
