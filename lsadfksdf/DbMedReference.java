package com.hackathon.pharmaguide;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbMedReference {
	private DbHelper dbHelper;
	
	public DbMedReference(Context context){
		dbHelper = new DbHelper(context);
	}
	
	public void insertRow_Table_MedRef(String illRefId, String medRefId){
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues insertValues = new ContentValues();
		insertValues.put(DbHelper.KEY_REFILLID, illRefId);
		insertValues.put(DbHelper.KEY_REFMEDID, medRefId);
		db.close();
	}
	
	public ArrayList<MedReferenceDataModel> getIllness(String med){
		ArrayList<MedReferenceDataModel> refModel = new ArrayList<MedReferenceDataModel>();
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String where = DbHelper.KEY_REFMEDID+ " = '" + med+"'";
		Cursor cursor = db.query(true, DbHelper.TABLE_MEDREFERENCE, DbHelper.KEYS_MEDREFERENCE, 
				where, null, null, null, null, null);
		if(cursor.getCount() != 0){
			while(cursor.moveToNext()){
				String illid = cursor.getString(0);
				String medid = cursor.getString(1);
				refModel.add(new MedReferenceDataModel(illid, medid));
			}
		}else{
			refModel = null;
		}
		return refModel;
	}
	
	public ArrayList<MedReferenceDataModel> getMed(String ill){
		ArrayList<MedReferenceDataModel> refModel = new ArrayList<MedReferenceDataModel>();
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String where = DbHelper.KEY_REFILLID+ " = '" + ill+"'";
		Cursor cursor = db.query(true, DbHelper.TABLE_MEDREFERENCE, DbHelper.KEYS_MEDREFERENCE, 
				where, null, null, null, null, null);
		if(cursor.getCount() != 0){
			while(cursor.moveToNext()){
				String illid = cursor.getString(0);
				String medid = cursor.getString(1);
				refModel.add(new MedReferenceDataModel(illid, medid));
			}
		}else{
			refModel = null;
		}
		return refModel;
	}
}
