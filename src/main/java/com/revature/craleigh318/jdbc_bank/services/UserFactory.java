package com.revature.craleigh318.jdbc_bank.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.craleigh318.jdbc_bank.model.User;

public class UserFactory {
	
	private static final int USER_ID = 1;
	private static final int BANK_ACCOUNT_ID = 2;
	private static final int USERNAME = 3;
	private static final int USER_PASSWORD = 4;
	
	public User fromSQL(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt(USER_ID);
		int bankAccountId = resultSet.getInt(BANK_ACCOUNT_ID);
		String username = resultSet.getString(USERNAME);
		String password = resultSet.getString(USER_PASSWORD);
		return new User(id, bankAccountId, username, password);
	}
	
	private UserFactory() { }
}
