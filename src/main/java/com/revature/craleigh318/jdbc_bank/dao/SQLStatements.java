package com.revature.craleigh318.jdbc_bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.craleigh318.jdbc_bank.model.BankAccount;
import com.revature.craleigh318.jdbc_bank.model.User;

class SQLStatements {
	
	private static final String TABLE_BA = "BANK_ACCOUNTS";
	private static final String TABLE_U = "USERS";
	private static final String BA_KEY = "BANK_ACCOUNT_ID";
	private static final String BA_B = "BANK_ACCOUNT_BALANCE";
	private static final String U_KEY = "USER_ID";
	private static final String U_UN = "USERNAME";
	private static final String U_P = "USER_PASSWORD";
	private static final String SEQUENCE_BA = "SEQUENCE_BANK_ACCOUNT_ID";
	private static final String SEQUENCE_U = "SEQUENCE_USER_ID";
	private static final String SQL_INSERT_BA = "INSERT INTO " + TABLE_BA + " (" + SEQUENCE_BA + ".NEXTVAL, 0.00)";
	private static final String SQL_INSERT_U = "INSERT INTO " + TABLE_U + " (" + SEQUENCE_U + ".NEXTVAL, ?, ?, ?)";
	private static final String SQL_BA_SELECT_B = "SELECT " + BA_B + " FROM " + TABLE_BA + " WHERE " + BA_KEY + "=?";
	private static final String SQL_U_SELECT_P = "SELECT " + U_P + " FROM " + TABLE_U + " WHERE " + U_UN + "=?";
	private static final String SQL_BA_UPDATE_B = "UPDATE " + TABLE_BA + " SET " + BA_B + "=? WHERE " + BA_KEY + "=?";
	private static final String SQL_DELETE_BA = "DELETE FROM " + TABLE_BA + " WHERE " + BA_KEY + "=?";
	private static final String SQL_DELETE_U = "DELETE FROM " + TABLE_U + " WHERE " + U_KEY + "=?";
	
	static PreparedStatement insertBankAccount(Connection connection) throws SQLException {
		return connection.prepareStatement(SQL_INSERT_BA);
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
	
	private SQLStatements() { }
}
