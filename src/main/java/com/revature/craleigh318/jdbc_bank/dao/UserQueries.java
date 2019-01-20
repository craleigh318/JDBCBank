package com.revature.craleigh318.jdbc_bank.dao;

import java.sql.ResultSet;

import com.revature.craleigh318.jdbc_bank.exceptions.IncorrectPasswordException;
import com.revature.craleigh318.jdbc_bank.model.User;

public class UserQueries {
	
	private static final String COLUMN_USERNAME = "USERNAME";
	private static final String COLUMN_PASSWORD = "USER_PASSWORD";
	private static final String TABLE = "USERS";
	
	public static boolean userExists(User user) throws IncorrectPasswordException {
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
		String sql = "SELECT " + COLUMN_PASSWORD + " FROM " + TABLE + " WHERE " + COLUMN_USERNAME + '=' + username + ';';
		try {
			ResultSet rslts = SQLQueries.executeQuery(sql);
			if (rslts.next()) {
				return rslts.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
