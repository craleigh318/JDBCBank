package com.revature.craleigh318.jdbc_bank.front_end;

public class LoginPrompt {
	
	private static LoginPrompt loginPrompt = null;
	
	public static LoginPrompt prompt() {
		if (loginPrompt == null) {
			loginPrompt = new LoginPrompt();
		}
		return loginPrompt;
	}
	
	private LoginPrompt() { }
}
