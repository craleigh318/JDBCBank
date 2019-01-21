package com.revature.craleigh318.jdbc_bank.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.craleigh318.jdbc_bank.exceptions.IncorrectPasswordException;
import com.revature.craleigh318.jdbc_bank.model.User;

public class UserQueries {
	
	public static boolean userExists(String username) throws IOException {
		String foundPassword = findPassword(username);
		return foundPassword != null;
	}
	
	public static boolean verifyPassword(User user) throws IncorrectPasswordException, IOException {
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
	
	public static void createUser(User user) throws SQLException, IOException {
		SQLStatements.insertUser(SQLQueries.connection(), user);
	}
	
	private static String findPassword(String username) throws IOException {
		try {
			PreparedStatement stmt = SQLStatements.userSelectPassword(SQLQueries.connection(), username);
			ResultSet rslts = stmt.executeQuery();
			if (rslts.next()) {
				return rslts.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
