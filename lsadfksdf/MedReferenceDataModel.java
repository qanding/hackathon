package com.hackathon.pharmaguide;

public class MedReferenceDataModel {
	private String illRefId;
	private String MedRefId;
	
	public MedReferenceDataModel() {
		super();
	}
	
	public MedReferenceDataModel(String illRefId, String medRefId) {
		super();
		this.illRefId = illRefId;
		MedRefId = medRefId;
	}
	
	public String getIllRefId() {
		return illRefId;
	}
	
	public void setIllRefId(String illRefId) {
		this.illRefId = illRefId;
	}
	
	public String getMedRefId() {
		return MedRefId;
	}
	
	public void setMedRefId(String medRefId) {
		MedRefId = medRefId;
	}
	
	
}
