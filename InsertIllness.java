package com.hackathon.pharmaguide;

import android.content.Context;

public class InsertIllness {
	DbIllness dbIllness;
	
	public InsertIllness(Context context){
		dbIllness = new DbIllness(context);
		insertMethod();
	}
	
	public void insertMethod(){
		dbIllness.insertRow_Table_Category("I01", "headache");
		dbIllness.insertRow_Table_Category("I02", "migraine");
		dbIllness.insertRow_Table_Category("I03", "nerve pain");
		dbIllness.insertRow_Table_Category("I04", "toothache");
		dbIllness.insertRow_Table_Category("I05", "sore throat");
		dbIllness.insertRow_Table_Category("I06", "earache");
		dbIllness.insertRow_Table_Category("I07", "period pain");
		dbIllness.insertRow_Table_Category("I08", "cold");
		dbIllness.insertRow_Table_Category("I09", "fever");
		dbIllness.insertRow_Table_Category("I10", "flu");
		dbIllness.insertRow_Table_Category("I11", "muscular pain");
		dbIllness.insertRow_Table_Category("I12", "backache");
		dbIllness.insertRow_Table_Category("I13", "sprain");
		dbIllness.insertRow_Table_Category("I14", "strain");
		dbIllness.insertRow_Table_Category("I15", "rheumatic pain");
		dbIllness.insertRow_Table_Category("I16", "dysmenorrhea");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
