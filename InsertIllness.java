package com.hackathon.pharmaguide;

import android.content.Context;

public class InsertIllness {
	DbIllness dbIllness;
	
	public InsertIllness(Context context){
		dbIllness = new DbIllness(context);
		insertMethod();
	}
	
	public void insertMethod(){
		dbIllness.insertRow_Table_Category("id here", "name here");
	}
}
