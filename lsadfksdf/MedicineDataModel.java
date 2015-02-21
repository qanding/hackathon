package com.hackathon.pharmaguide;

public class MedicineDataModel {
	private String MedId;
	private String MedBranchName;
	private String MedGenericName;
	private String MedDesc;
	
	public MedicineDataModel() {
		super();
	}

	public MedicineDataModel(String medId, String medBranchName,
			String medGenericName, String medDesc) {
		super();
		MedId = medId;
		MedBranchName = medBranchName;
		MedGenericName = medGenericName;
		MedDesc = medDesc;
	}

	public String getMedId() {
		return MedId;
	}

	public void setMedId(String medId) {
		MedId = medId;
	}

	public String getMedBranchName() {
		return MedBranchName;
	}

	public void setMedBranchName(String medBranchName) {
		MedBranchName = medBranchName;
	}

	public String getMedGenericName() {
		return MedGenericName;
	}

	public void setMedGenericName(String medGenericName) {
		MedGenericName = medGenericName;
	}

	public String getMedDesc() {
		return MedDesc;
	}

	public void setMedDesc(String medDesc) {
		MedDesc = medDesc;
	}

	
}
