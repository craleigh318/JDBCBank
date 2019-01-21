package com.revature.craleigh318.jdbc_bank.front_end;

import com.revature.craleigh318.jdbc_bank.dao.UserQueries;
import com.revature.craleigh318.jdbc_bank.exceptions.IncorrectPasswordException;
import com.revature.craleigh318.jdbc_bank.model.User;
import com.revature.craleigh318.jdbc_bank.utils.InputOutput;

class LoginPrompt {
	
	private static final String EXISTING_USER = "1";
	private static final String NEW_USER = "2";
	
	static void begin() {
		newOrExistingUserPrompt();
	}
	
	static void newOrExistingUserPrompt() {
		InputOutput.out().println(EXISTING_USER +") Log In as existing user\n" + NEW_USER + ") Create new account");
		String input = InputOutput.in().readLine();
		switch (input) {
		case EXISTING_USER:
			//logIn();
			break;
		case NEW_USER:
			register();
			break;
		default:
			InputOutput.out().println("Please select a valid option.");
			newOrExistingUserPrompt();
		}
	}
	
	/*public static void logIn() {
		User enteredUser = usernamePasswordPrompt();
		boolean userExists;
		try {
			userExists = UserQueries.userExists(enteredUser);
		} catch (IncorrectPasswordException e) {
			InputOutput.out().println(IncorrectPasswordException.MESSAGE);
			logIn();
			return;
		}
		if (userExists) {
			InputOutput.out().println("User exists.");
		} else {
			InputOutput.out().println("User does not exist.");
		}
	}*/
	
	private static void register() {
		User registration = usernamePasswordPrompt();
		String username = registration.getUsername();
		boolean userAlreadyExists = UserQueries.userExists(username);
		if (userAlreadyExists) {
			InputOutput.out().println("Registration failed. That username is already taken.");
			newOrExistingUserPrompt();
			return;
		}
		//create user
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
