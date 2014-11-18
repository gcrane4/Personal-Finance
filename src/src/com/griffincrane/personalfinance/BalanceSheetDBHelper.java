package com.griffincrane.personalfinance;

import com.griffincrane.personalfinance.BalanceSheetContract.BalanceEntry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BalanceSheetDBHelper extends SQLiteOpenHelper {

	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "BalanceSheet.db";
	
	private static final String TEXT_TYPE = " TEXT";
	private static final String MONEY_TYPE = " FLOAT(2)";
	private static final String COMMA_SEP = ",";
	private static final String SQL_CREATE_ENTRIES =
		"CREATE TABLE " + BalanceEntry.TABLE_NAME + " (" +
		BalanceEntry._ID + " INTEGER PRIMARY KEY," +
		BalanceEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
		BalanceEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
		BalanceEntry.COLUMN_NAME_AMOUNT + MONEY_TYPE + COMMA_SEP +
		" )";
	
	private static final String SQL_DELETE_ENTRIES =
		"DROP TABLE IF EXISTS " + BalanceEntry.TABLE_NAME;
	
	public BalanceSheetDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_ENTRIES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// for now, delete the entire database and start over on database upgrade
		db.execSQL(SQL_DELETE_ENTRIES);
		onCreate(db);
	}
	
	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onUpgrade(db, oldVersion, newVersion);
	}
}
