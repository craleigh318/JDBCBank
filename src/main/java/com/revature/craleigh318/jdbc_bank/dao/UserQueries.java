package com.revature.craleigh318.jdbc_bank.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.craleigh318.jdbc_bank.exceptions.IncorrectPasswordException;
import com.revature.craleigh318.jdbc_bank.model.User;

public class UserQueries {
	
	public static boolean userExists(String username) {
		String foundPassword = findPassword(username);
		return foundPassword != null;
	}
	
	public static boolean verifyPassword(User user) throws IncorrectPasswordException {
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
			PreparedStatement stmt = SQLStatements.userSelectPassword(SQLQueries.connection(), username);
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
