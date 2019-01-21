package com.revature.craleigh318.jdbc_bank.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.craleigh318.jdbc_bank.exceptions.IncorrectPasswordException;
import com.revature.craleigh318.jdbc_bank.model.User;

public class UserQueries {
	
	private static final String COLUMN_USERNAME = "USERNAME";
	private static final String COLUMN_PASSWORD = "USER_PASSWORD";
	private static final String TABLE = "USERS";
	private static final String STATEMENT_INSERT_USER = "INSERT INTO " + TABLE + " (SEQUENCE_USER_ID.NEXTVAL, ?, ?, ?)";
	private static final String STATEMENT_SELECT_PASSWORD = "SELECT " + COLUMN_PASSWORD + " FROM " + TABLE + " WHERE " + COLUMN_USERNAME + "=?";
	
	public static boolean userExists(String username) {
		String foundPassword = findPassword(username);
		return foundPassword != null;
	}
	
	public static boolean olduserExists(User user) throws IncorrectPasswordException {
		String username = user.getUsername();
		String password = user.getPassword();
		String foundPassword = findPassword(username);
		if (foundPassword == null) {
			return false;
		}
		if (!password.equals(foundPassword)) {
			throw new IncorrectPasswordException();
		}
		return true;
	}
	
	private static String findPassword(String username) {
		try {
			PreparedStatement stmt = SQLQueries.prepareStatement(STATEMENT_SELECT_PASSWORD);
			stmt.setString(1, username);
			ResultSet rslts = stmt.executeQuery();
			if (rslts.next()) {
				return rslts.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
