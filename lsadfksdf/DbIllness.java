package com.hackathon.pharmaguide;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbIllness {
	private DbHelper dbHelper;
	
	public DbIllness(Context context){
		dbHelper = new DbHelper(context);
	}
	
	public void insertRow_Table_Category(String illId, String illName){
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues insertValues = new ContentValues();
		
		insertValues.put(DbHelper.KEY_ILLNESSID, illId);
		insertValues.put(DbHelper.KEY_ILLNENAME, illName);
		db.insert(DbHelper.TABLE_ILLNESS, null, insertValues);
		db.close();
	}
	
	public ArrayList<IllnessDataModel> getAllRow_Table_Illness(){
		ArrayList<IllnessDataModel> illModel = new ArrayList<IllnessDataModel>();
		
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String where = null;
		Cursor cursor = db.query(true, DbHelper.TABLE_ILLNESS, DbHelper.KEYS_ILLNESS, where, null, null, null, null, null);
		if(cursor.getCount() != 0){
			while(cursor.moveToNext()){
				String illid = cursor.getString(0);
				String illname = cursor.getString(1);
				illModel.add(new IllnessDataModel(illid, illname));
			}
		}else{
			illModel = null;
		}
		db.close();
		
		return illModel;
	}
	
	public IllnessDataModel getRow_Table_Illness(String strInput){
		IllnessDataModel illModel = new IllnessDataModel();
		
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String where = DbHelper.KEY_ILLNENAME+ " = '" + strInput+"'";
		Cursor cursor = db.query(true, DbHelper.TABLE_ILLNESS, DbHelper.KEYS_ILLNESS, 
				where, null, null, null, null, null);
		if (cursor.getCount() != 0) {
			cursor.moveToFirst();
			String illid = cursor.getString(0);
			String illname = cursor.getString(1);
			illModel.setIllID(illid);
			illModel.setIllN(illname);
		}else{
			illModel = null;
		}
		db.close();
		
		return illModel;
	}
	
	public IllnessDataModel getAllID_Table_Illness(String ill){
		IllnessDataModel illModel = new IllnessDataModel();
		
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String where = DbHelper.KEY_ILLNESSID+ " = '" + ill+"'";
		Cursor cursor = db.query(true, DbHelper.TABLE_ILLNESS, DbHelper.KEYS_ILLNESS, 
				where, null, null, null, null, null);
		if (cursor.getCount() != 0) {
			cursor.moveToFirst();
			String illid = cursor.getString(0);
			String illname = cursor.getString(1);
			illModel.setIllID(illid);
			illModel.setIllN(illname);
		}else{
			illModel = null;
		}
		db.close();
		
		return illModel;
	}
}
