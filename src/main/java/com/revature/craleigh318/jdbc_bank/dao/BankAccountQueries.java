package com.revature.craleigh318.jdbc_bank.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.craleigh318.jdbc_bank.model.BankAccount;

public class BankAccountQueries {
	
	public static int createAccount() throws SQLException, IOException {
		int newId = nextId();
		PreparedStatement stmt = SQLStatements.insertBankAccount(SQLQueries.connection(), newId);
		stmt.execute();
		return newId;
	}
	
	public static BankAccount getBankAccount(int bankAccountId) throws SQLException, IOException {
		BigDecimal balance = getBalance(bankAccountId);
		balance = balance.setScale(BankAccount.CENT_PRECISION);
		return new BankAccount(bankAccountId, balance);
	}
	
	private static BigDecimal getBalance(int id) throws SQLException, IOException {
		PreparedStatement stmt = SQLStatements.bankAccountSelectBalance(SQLQueries.connection(), id);
		ResultSet rslts = stmt.executeQuery();
		rslts.next();
		return rslts.getBigDecimal(1);
	}
	
	private static int nextId() throws SQLException, IOException {
		PreparedStatement stmt = SQLStatements.selectNextBankAccountId(SQLQueries.connection());
		ResultSet rslts = stmt.executeQuery();
		rslts.next();
		return rslts.getInt(1);
	}
	
	private BankAccountQueries() { }
}
