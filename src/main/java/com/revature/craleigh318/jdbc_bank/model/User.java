package com.revature.craleigh318.jdbc_bank.model;

public class User {
	
	private Integer id;
	private Integer bankAccountId;
	private String username;
	private String password;
	
	public User(Integer id, Integer bankAccountId, String username, String password) {
		this.setId(id);
		this.setBankAccountId(bankAccountId);
		this.setUsername(username);
		this.setPassword(password);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Integer bankAccountId) {
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
