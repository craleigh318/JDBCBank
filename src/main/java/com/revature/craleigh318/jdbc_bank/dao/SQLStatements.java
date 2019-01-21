package com.revature.craleigh318.jdbc_bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.craleigh318.jdbc_bank.model.BankAccount;
import com.revature.craleigh318.jdbc_bank.model.User;

class SQLStatements {
	
	static final String TABLE_BA = "BANK_ACCOUNTS";
	static final String TABLE_U = "USERS";
	static final String BA_KEY = "BANK_ACCOUNT_ID";
	static final String BA_B = "BANK_ACCOUNT_BALANCE";
	static final String U_KEY = "USER_ID";
	static final String U_UN = "USERNAME";
	static final String U_P = "USER_PASSWORD";
	static final String SEQUENCE_BA = "SEQUENCE_BANK_ACCOUNT_ID";
	static final String SEQUENCE_U = "SEQUENCE_USER_ID";
	private static final String SQL_INSERT_BA = "INSERT INTO " + TABLE_BA + " VALUES(?, 0.00)";
	private static final String SQL_INSERT_U = "INSERT INTO " + TABLE_U + " VALUES(" + SEQUENCE_U + ".NEXTVAL, ?, ?, ?)";
	private static final String SQL_BA_SELECT_B = "SELECT " + BA_B + " FROM " + TABLE_BA + " WHERE " + BA_KEY + "=?";
	private static final String SQL_U_SELECT = "SELECT * FROM " + TABLE_U + " WHERE " + U_UN + "=?";
	private static final String SQL_U_SELECT_P = "SELECT " + U_P + " FROM " + TABLE_U + " WHERE " + U_UN + "=?";
	private static final String SQL_BA_UPDATE_B = "UPDATE " + TABLE_BA + " SET " + BA_B + "=? WHERE " + BA_KEY + "=?";
	private static final String SQL_DELETE_BA = "DELETE FROM " + TABLE_BA + " WHERE " + BA_KEY + "=?";
	private static final String SQL_DELETE_U = "DELETE FROM " + TABLE_U + " WHERE " + U_KEY + "=?";
	private static final String SQL_SELECT_SEQUENCE_BA_NEXT = "SELECT " + SEQUENCE_BA + ".NEXTVAL FROM DUAL";
	
	static PreparedStatement insertBankAccount(Connection connection, int bankAccountId) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_BA);
		stmt.setInt(1, bankAccountId);
		return stmt;
	}
	
	static PreparedStatement insertUser(Connection connection, User user) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_U);
		stmt.setInt(1, user.getBankAccountId());
		stmt.setString(2, user.getUsername());
		stmt.setString(3, user.getPassword());
		return stmt;
	}
	
	static PreparedStatement bankAccountSelectBalance(Connection connection, int accountId) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(SQL_BA_SELECT_B);
		stmt.setInt(1, accountId);
		return stmt;
	}
	
	static PreparedStatement userSelect(Connection connection, String username) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(SQL_U_SELECT);
		stmt.setString(1, username);
		return stmt;
	}
	
	static PreparedStatement userSelectPassword(Connection connection, String username) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(SQL_U_SELECT_P);
		stmt.setString(1, username);
		return stmt;
	}
	
	static PreparedStatement bankAccountUpdateBalance(Connection connection, BankAccount account) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(SQL_BA_UPDATE_B);
		stmt.setBigDecimal(1, account.getBalance());
		stmt.setInt(2, account.getId());
		return stmt;
	}
	
	static PreparedStatement deleteBankAccount(Connection connection, int accountId) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(SQL_DELETE_BA);
		stmt.setInt(1, accountId);
		return stmt;
	}
	
	static PreparedStatement deleteUser(Connection connection, int userId) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(SQL_DELETE_U);
		stmt.setInt(1, userId);
		return stmt;
	}
	
	static PreparedStatement selectNextBankAccountId(Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_SEQUENCE_BA_NEXT);
		return stmt;
	}
	
	private SQLStatements() { }
}
