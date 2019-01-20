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
	
	private Scanner scannerSystemIn = null;
	
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
	
	void cleanUp() {
		if (scannerSystemIn != null) {
			scannerSystemIn.close();
		}
	}
	
	private Scanner scanner() {
		if (scannerSystemIn == null) {
			scannerSystemIn = new Scanner(System.in);
		}
		return scannerSystemIn;
	}
	
	private Console console() {
		return System.console();
	}
	
	private String standardReadLine() {
		return scanner().nextLine();
	}
}
