package com.revature.craleigh318.jdbc_bank.dao;

public class BankAccountQueries {
	
	private static final String TABLE = "BANK_ACCOUNTS";
	private static final String STATEMENT_INSERT_BANK_ACCOUNT = "INSERT INTO " + TABLE + " (SEQUENCE_BANK_ACCOUNT_ID.NEXTVAL, 0.00)";

	private BankAccountQueries() { }
}
