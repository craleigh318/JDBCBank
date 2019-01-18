package com.revature.craleigh318.jdbc_bank.model;

public class User {
	
	private int id;
	private int bankAccountId;
	private String username;
	private String password;
	
	public User(int id, int bankAccountId, String username, String password) {
		this.setId(id);
		this.setBankAccountId(bankAccountId);
		this.setUsername(username);
		this.setPassword(password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(int bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
