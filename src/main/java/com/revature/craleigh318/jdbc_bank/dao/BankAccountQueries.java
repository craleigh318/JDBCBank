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
	
	public static void deleteAccount(int bankAccountId) throws SQLException, IOException {
		PreparedStatement stmt = SQLStatements.deleteBankAccount(SQLQueries.connection(), bankAccountId);
		stmt.execute();
	}
	
	public static BankAccount getBankAccount(int bankAccountId) throws SQLException, IOException {
		BigDecimal balance = getBalance(bankAccountId);
		balance = balance.setScale(BankAccount.CENT_PRECISION);
		return new BankAccount(bankAccountId, balance);
	}
	
	public static void updateBalance(BankAccount bankAccount) throws SQLException, IOException {
		PreparedStatement stmt = SQLStatements.bankAccountUpdateBalance(SQLQueries.connection(), bankAccount);
		stmt.execute();
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
