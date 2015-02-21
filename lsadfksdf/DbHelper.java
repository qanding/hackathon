package com.hackathon.pharmaguide;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{

	

	//DB information here:
	protected static final String DATABASE_NAME = "DBPHARMA9";
	protected static final int DATABASE_VERSION = 1;
		
	//table ILLNESS_TABLE
	protected static final String TABLE_ILLNESS = "ILLN3SS_TABL3";
	protected static final String KEY_ILLNESSID = "ILLNESS_ID";
	protected static final String KEY_ILLNENAME = "ILLNESS_NAM3";
	protected static final String[] KEYS_ILLNESS = new String[] {KEY_ILLNESSID, KEY_ILLNENAME};
	protected static final String CREATE_TABLE_ILLNESS = 
			"CREATE TABLE "+TABLE_ILLNESS
			+" ("+KEY_ILLNESSID +" TEXT PRIMARY KEY NOT NULL, "
			+KEY_ILLNENAME +" TEXT NOT NULL"
			+");";
	protected static final String DROP_TABLE_ILLNESS = "DROP TABLE IF EXIST "+TABLE_ILLNESS;
	
	
	protected static final String TABLE_COMMONILLNAME = "TABLE_COMMONILLNAME";
	protected static final String KEY_CMONILLNESSID = "CMONILLNESSID_ID";
	protected static final String KEY_CMONILLNENAME = "CMONILLNENAME_ID";
	protected static final String[] KEYS_COMMONILLNAME = new String[] {KEY_CMONILLNESSID, KEY_CMONILLNENAME};
	protected static final String CREATE_TABLE_CMONILLNAME = 
			"CREATE TABLE "+TABLE_COMMONILLNAME
			+" ("+KEY_CMONILLNESSID +" TEXT PRIMARY KEY NOT NULL, "
			+KEY_CMONILLNENAME +" TEXT NOT NULL"
			+");"; 
	protected static final String DROP_TABLE_COMMONILLNAME = "DROP TABLE IF EXIST "+TABLE_COMMONILLNAME;
	
	
	protected static final String TABLE_MEDICINE = "TABLE_MEDICINE";
	protected static final String KEY_MEDID = "MED_ID";
	protected static final String KEY_MEDBRANCHNAME = "MED_BRANCHNAME";
	protected static final String KEY_MEDGENERICNAME = "MED_GENERICNAME";
	protected static final String KEY_MEDDESC = "MED_DESC";
	protected static final String[] KEYS_MEDICINE = new String[] {KEY_MEDID, KEY_MEDBRANCHNAME, KEY_MEDGENERICNAME, KEY_MEDDESC};
	protected static final String CREATE_TABLE_MEDICINE = 
			"CREATE TABLE "+TABLE_MEDICINE
			+" ("+KEY_MEDID +" TEXT PRIMARY KEY NOT NULL, "
			+KEY_MEDBRANCHNAME +" TEXT NOT NULL, "
			+KEY_MEDGENERICNAME +" TEXT NOT NULL, "
			+KEY_MEDDESC +" TEXT NOT NULL"
			+");";
	protected static final String DROP_TABLE_MEDICINE = "DROP TABLE IF EXIST "+TABLE_MEDICINE;
	
	
	protected static final String TABLE_MEDREFERENCE = "TABLE_MEDREFERENCE";
	protected static final String KEY_REFILLID = "r3fillid";
	protected static final String KEY_REFMEDID = "r3fm3did";
	protected static final String[] KEYS_MEDREFERENCE = new String[] {KEY_REFILLID, KEY_REFMEDID};
	protected static final String CREATE_TABLE_MEDREFERENCE = 
			"CREATE TABLE "+TABLE_MEDREFERENCE
			+" ("+KEY_REFILLID +" TEXT KEY NOT NULL, "
			+KEY_REFMEDID +" TEXT NOT NULL"
			+");";
	protected static final String DROP_TABLE_MEDREFERENCE = "DROP TABLE IF EXIST "+TABLE_MEDREFERENCE;
	
	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			db.execSQL(CREATE_TABLE_ILLNESS);
			db.execSQL(CREATE_TABLE_CMONILLNAME);
			db.execSQL(CREATE_TABLE_MEDICINE);
			db.execSQL(CREATE_TABLE_MEDREFERENCE);
		}catch(SQLException e){
			
		}
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		try{
			db.execSQL(DROP_TABLE_ILLNESS);
			db.execSQL(DROP_TABLE_COMMONILLNAME);
			db.execSQL(DROP_TABLE_MEDICINE);
			db.execSQL(DROP_TABLE_MEDREFERENCE);
			onCreate(db);
		}catch(SQLException e){
			
		}
	}

}
