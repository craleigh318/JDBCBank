package com.revature.craleigh318.jdbc_bank.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccountQueries {
	
	public static int createAccount() throws SQLException, IOException {
		PreparedStatement stmt = SQLStatements.insertBankAccount(SQLQueries.connection());
		ResultSet rslts = stmt.executeQuery();
		rslts.next();
		return rslts.getInt(SQLStatements.BA_KEY);
	}
	
	private BankAccountQueries() { }
}
