package com.griffincrane.personalfinance;

import android.provider.BaseColumns;

public final class BalanceSheetContract {
	// prevent from accidental instantiation
	// use empty constructor method
	public BalanceSheetContract() {}
	
	/* inner class that defines the table contents */
	public static abstract class BalanceEntry implements BaseColumns {
		public static final String TABLE_NAME = "balancesheet";
		public static final String COLUMN_NAME_ENTRY_ID = "entryid";
		public static final String COLUMN_NAME_TITLE = "title";
		public static final String COLUMN_NAME_AMOUNT = "amount";
	}
}
