package com.hackathon.pharmaguide;

import android.content.Context;

public class insertMedicine {
	DbMedicine dbMed;
	
	public insertMedicine(Context context){
		dbMed = new DbMedicine(context);
	}
	
	public void insertMethod(){
		dbMed.insertRow_Table_Medicine("M01", "Anadin", "Paracetamol", "Relieve mild to moderatederate pain. Lower high temperature fever.");
		dbMed.insertRow_Table_Medicine("M02", "Nuromol", "Ibuprofen Paracetamol", "Short-term treatment relief of mild to moderate pain.");
		dbMed.insertRow_Table_Medicine("M03", "Nurofen", "Ibuprofen", "Relieve mild to moderate pain.");
		dbMed.insertRow_Table_Medicine("M04", "Calpol", "Paracetamol", "Relieve mild to moderate pain.Lower high temperature fever. Used for children");
		dbMed.insertRow_Table_Medicine("M05", "Nurofen for Children", "Ibuprofen", "Relieve mild to moderate pain.Lower high temperature fever. Used for children 3 months to 12 years");
		dbMed.insertRow_Table_Medicine("M06", "Medinol", "Paracetamol", "Relieve mild to moderate pain.Lower high temperature fever. Used for children");
		dbMed.insertRow_Table_Medicine("M07", "Aeknil", "Paracetamol", "Fast effecting treatment relief of mild to moderate pain.");
		dbMed.insertRow_Table_Medicine("M08", "Biogesic", "Paracetamol", "Relieve mild to moderate pain.Lower high temperature fever. Used for children");
		dbMed.insertRow_Table_Medicine("M09", "Saridon", "Caffeine, Paracetamol, Propyphenazone", "For the relief of mild to severe pain, fever associated with colds and flu");
		dbMed.insertRow_Table_Medicine("M10", "Medicol", "Ibuprofen", "Relieve mild to moderatederate pain. Lower high temperature fever.");
		dbMed.insertRow_Table_Medicine("M11", "Tempra", "Paracetamol", "For the relief of headaches, minor aches and pains, and reduction of fever.");
	}
}
