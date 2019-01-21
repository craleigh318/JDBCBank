package com.revature.craleigh318.jdbc_bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankAccountQueries {
	
	private static final String TABLE = "BANK_ACCOUNTS";
	private static final String SQL_INSERT_BANK_ACCOUNT = "INSERT INTO " + TABLE + " (SEQUENCE_BANK_ACCOUNT_ID.NEXTVAL, 0.00)";

	public static PreparedStatement insert(Connection connection) throws SQLException {
		return connection.prepareStatement(SQL_INSERT_BANK_ACCOUNT);
	}
	
	private BankAccountQueries() { }
}
