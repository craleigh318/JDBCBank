package com.revature.craleigh318.jdbc_bank.utils;

import java.io.Console;
import java.util.Scanner;

public class Input {
	
	private static Input input = null;
	
	static Input input() {
		if (input == null) {
			input = new Input();
		}
		return input;
	}
	
	private Input() { }
	
	public String readLine() {
		Console cnsl = console();
		if (cnsl != null) {
			return cnsl.readLine();
		}
		return standardReadLine();
	}
	
	public char[] readPassword() {
		Console cnsl = console();
		if (cnsl != null) {
			return cnsl.readPassword();
		}
		return standardReadLine().toCharArray();
	}
	
	private Console console() {
		return System.console();
	}
	
	private String standardReadLine() {
		String ln = null;
		try (Scanner scnr = new Scanner(System.in)) {
			ln = scnr.nextLine();
		}
		return ln;
	}
}
