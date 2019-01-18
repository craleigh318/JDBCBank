package com.revature.craleigh318.jdbc_bank.model;

public class BankAccount {
	
	private int id;
	private int balance;
	
	public BankAccount(int id, int balance) {
		this.id = id;
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
