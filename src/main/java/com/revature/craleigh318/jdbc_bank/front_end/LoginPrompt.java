package com.revature.craleigh318.jdbc_bank.front_end;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.craleigh318.jdbc_bank.dao.BankAccountQueries;
import com.revature.craleigh318.jdbc_bank.dao.UserQueries;
import com.revature.craleigh318.jdbc_bank.exceptions.IncorrectPasswordException;
import com.revature.craleigh318.jdbc_bank.model.User;
import com.revature.craleigh318.jdbc_bank.utils.InputOutput;

class LoginPrompt {
	
	static void begin() throws IOException {
		newOrExistingUserPrompt();
	}
	
	private static void newOrExistingUserPrompt() throws IOException {
		final String EXISTING_USER = "1";
		final String NEW_USER = "2";
		final String EXIT = "3";
		InputOutput.out().println(EXISTING_USER +") Log In as existing user\n" + NEW_USER + ") Create new account\n" + EXIT + ") Exit");
		String input = InputOutput.in().readLine();
		switch (input) {
		case EXISTING_USER:
			logIn();
			break;
		case NEW_USER:
			register();
			break;
		case EXIT:
			return;
		default:
			InputOutput.out().println("Please select a valid option.");
			newOrExistingUserPrompt();
		}
	}
	
	private static void logIn() throws IOException {
		User enteredUser = usernamePasswordPrompt();
		User actualUser = null;
		try {
			actualUser = UserQueries.verifyLogin(enteredUser);
		} catch (IncorrectPasswordException e) {
			InputOutput.out().println(IncorrectPasswordException.MESSAGE);
			newOrExistingUserPrompt();
			return;
		}
		boolean userExists = (actualUser != null);
		if (userExists) {
			AccountMaintenance.logIn(actualUser);
		} else {
			InputOutput.out().println("That username does not exist.");
			newOrExistingUserPrompt();
		}
	}
	
	private static void register() throws IOException {
		User registration = usernamePasswordPrompt();
		String username = registration.getUsername();
		boolean userAlreadyExists = UserQueries.userExists(username);
		if (userAlreadyExists) {
			InputOutput.out().println("Registration failed. That username is already taken.");
			newOrExistingUserPrompt();
			return;
		}
		try {
			int accountId = BankAccountQueries.createAccount();
			InputOutput.out().println("Account opened.");
			registration.setBankAccountId(accountId);
			UserQueries.createUser(registration);
			InputOutput.out().println("Registration successful.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		newOrExistingUserPrompt();
	}
	
	private static User usernamePasswordPrompt() {
		InputOutput.out().print("Username: ");
        String username = InputOutput.in().readLine();
        InputOutput.out().print("Password: ");
        char[] password = InputOutput.in().readPassword();
        return createLoginObject(username, password);
	}
	
	private static User createLoginObject(String username, char[] password) {
		String passwordString = new String(password);
		return new User(null, null, username, passwordString);
	}
	
	private LoginPrompt() { }
}
