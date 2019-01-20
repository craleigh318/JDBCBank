package com.revature.craleigh318.jdbc_bank.front_end;

import com.revature.craleigh318.jdbc_bank.model.User;
import com.revature.craleigh318.jdbc_bank.utils.InputOutput;

public class LoginPrompt {
	
	public static void logIn() {
		usernamePasswordPrompt();
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
