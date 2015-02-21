package com.hackathon.pharmaguide;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbMedicine {
	private DbHelper dbHelper;
	
	public DbMedicine(Context context){
		dbHelper = new DbHelper(context);
	}
	
	public void insertRow_Table_Medicine(String medID, String medBrand, String medGeneric, String medDesc){
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues insertValues = new ContentValues();
		insertValues.put(DbHelper.KEY_MEDID, medID);
		insertValues.put(DbHelper.KEY_MEDBRANCHNAME, medBrand);
		insertValues.put(DbHelper.KEY_MEDGENERICNAME, medGeneric);
		insertValues.put(DbHelper.KEY_MEDDESC, medDesc);
		db.insert(DbHelper.TABLE_MEDICINE, null, insertValues);
		db.close();
	}
	
	public void getAllRow_Table_Medicine(){
		ArrayList<MedicineDataModel> medModel = new ArrayList<MedicineDataModel>();
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String where = null;
		Cursor cursor = db.query(true, DbHelper.TABLE_MEDICINE, DbHelper.KEYS_MEDICINE, where, null, null, null, null, null);
		if(cursor.getCount() != 0){
			while(cursor.moveToNext()){
				String  medID= cursor.getString(0);
				String medBrand = cursor.getString(1);
				String medGeneric = cursor.getString(2);
				String medDesc = cursor.getString(3);
				medModel.add(new MedicineDataModel(medID, medBrand, medGeneric, medDesc));
			}
		}else{
			medModel = null;
		}
		db.close();
	}
	
	public void getAllRow_Table_Medicine(String med){
		ArrayList<MedicineDataModel> medModel = new ArrayList<MedicineDataModel>();
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String where = DbHelper.KEY_MEDID+ " = '" + med+"'";
		Cursor cursor = db.query(true, DbHelper.TABLE_MEDICINE, DbHelper.KEYS_MEDICINE, where, null, null, null, null, null);
		if(cursor.getCount() != 0){
			while(cursor.moveToNext()){
				String  medID= cursor.getString(0);
				String medBrand = cursor.getString(1);
				String medGeneric = cursor.getString(2);
				String medDesc = cursor.getString(3);
				medModel.add(new MedicineDataModel(medID, medBrand, medGeneric, medDesc));
			}
		}else{
			medModel = null;
		}
		db.close();
	}
	
	public MedicineDataModel getRow_Table_Medicine(String strInput){
		MedicineDataModel medModel = null;
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String where = DbHelper.KEY_MEDBRANCHNAME+ " LIKE %" + strInput+"%";
		Cursor cursor = db.query(true, DbHelper.KEY_MEDBRANCHNAME, DbHelper.KEYS_ILLNESS, 
				where, null, null, null, null, null);
		if (cursor.getCount() != 0) {
			cursor.moveToFirst();
			String  medID = cursor.getString(0);
			String medBrand = cursor.getString(1);
			String medGeneric = cursor.getString(2);
			String medDesc = cursor.getString(3);
			medModel = new MedicineDataModel(medID, medBrand, medGeneric, medDesc);
		}
		db.close();
		return medModel;
	}
	
	public MedicineDataModel getRowById_Table_Medicine(String strInput){
		MedicineDataModel medModel = null;
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String where = DbHelper.KEY_MEDID+ " = '" + strInput+"'";;
		Cursor cursor = db.query(true, DbHelper.KEY_MEDBRANCHNAME, DbHelper.KEYS_ILLNESS, 
				where, null, null, null, null, null);
		if (cursor.getCount() != 0) {
			cursor.moveToFirst();
			String  medID = cursor.getString(0);
			String medBrand = cursor.getString(1);
			String medGeneric = cursor.getString(2);
			String medDesc = cursor.getString(3);
			medModel = new MedicineDataModel(medID, medBrand, medGeneric, medDesc);
		}
		db.close();
		return medModel;
	}
}
