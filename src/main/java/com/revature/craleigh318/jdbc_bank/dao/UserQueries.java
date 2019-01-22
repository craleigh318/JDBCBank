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
	
	public static User verifyLogin(User login) throws IncorrectPasswordException, IOException {
		String username = login.getUsername();
		String password = login.getPassword();
		User foundUser = userFromUsername(username);
		if (foundUser == null) {
			return null;
		}
		String foundPassword = foundUser.getPassword();
		if (!password.equals(foundPassword)) {
			throw new IncorrectPasswordException();
		}
		return foundUser;
	}
	
	public static void createUser(User user) throws SQLException, IOException {
		SQLStatements.insertUser(SQLQueries.connection(), user).execute();
	}
	
	public static void deleteUser(int userId) throws SQLException, IOException {
		SQLStatements.deleteUser(SQLQueries.connection(), userId).execute();
	}
	
	public static User userFromUsername(String username) throws IOException {
		ResultSet rows = getUserRows(username);
		try {
			if ((rows != null) && rows.next()) {
				return UserFactory.fromSql(rows);
			}
		} catch (SQLException e) {
		}
		return null;
	}
	
	private static ResultSet getUserRows(String username) throws IOException {
		try {
			PreparedStatement stmt = SQLStatements.userSelect(SQLQueries.connection(), username);
			return stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
