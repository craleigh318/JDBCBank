package com.revature.craleigh318.jdbc_bank.front_end;

import com.revature.craleigh318.jdbc_bank.utils.InputOutput;

public class LoginPrompt {
	
	private static LoginPrompt loginPrompt = null;
	
	public static LoginPrompt prompt() {
		if (loginPrompt == null) {
			loginPrompt = new LoginPrompt();
		}
		return loginPrompt;
	}
	
	public void logIn() {
		InputOutput.out().print("Username: ");
        String username = InputOutput.in().readLine();
        InputOutput.out().print("Password: ");
        char[] password = InputOutput.in().readPassword();
	}
	
	private LoginPrompt() { }
}
