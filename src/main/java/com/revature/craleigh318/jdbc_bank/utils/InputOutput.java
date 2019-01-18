package com.revature.craleigh318.jdbc_bank.utils;

import java.io.PrintStream;

public class InputOutput {
	public static PrintStream out() {
		return System.out;
	}
	
	public static Input in() {
		return Input.input();
	}
	
	private InputOutput() { }
}
