package com.revature.craleigh318.jdbc_bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.craleigh318.jdbc_bank.model.User;

public class UserFactory {
	
	public static final int USER_ID = 1;
	public static final int BANK_ACCOUNT_ID = 2;
	public static final int USERNAME = 3;
	public static final int USER_PASSWORD = 4;
	
	public static User fromSql(ResultSet resultSet) {
		Integer id;
		try {
			id = resultSet.getInt(USER_ID);
		} catch (SQLException e) {
			e.printStackTrace();
			id = null;
		}
		Integer bankAccountId;
		try {
			bankAccountId = resultSet.getInt(BANK_ACCOUNT_ID);
		} catch (SQLException e) {
			e.printStackTrace();
			bankAccountId = null;
		}
		String username;
		try {
			username = resultSet.getString(USERNAME);
		} catch (SQLException e) {
			e.printStackTrace();
			username = null;
		}
		String password;
		try {
			password = resultSet.getString(USER_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			password = null;
		}
		return new User(id, bankAccountId, username, password);
	}
	
	private UserFactory() { }
}
