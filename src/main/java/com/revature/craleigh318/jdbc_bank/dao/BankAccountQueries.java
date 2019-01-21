package com.revature.craleigh318.jdbc_bank.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccountQueries {
	
	public static int createAccount() throws SQLException, IOException {
		int newId = nextId();
		PreparedStatement stmt = SQLStatements.insertBankAccount(SQLQueries.connection(), newId);
		stmt.execute();
		return newId;
	}
	
	private static int nextId() throws SQLException, IOException {
		PreparedStatement stmt = SQLStatements.selectNextBankAccountId(SQLQueries.connection());
		ResultSet rslts = stmt.executeQuery();
		rslts.next();
		return rslts.getInt(1);
	}
	
	private BankAccountQueries() { }
}
