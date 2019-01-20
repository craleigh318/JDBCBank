package com.revature.craleigh318.jdbc_bank.model;

import java.math.BigDecimal;

public class BankAccount {
	
	public static final int CENT_PRECISION = 2;
	
	private Integer id;
	private BigDecimal balance;
	
	public BankAccount(Integer id, BigDecimal balance) {
		this.id = id;
		this.balance = balance;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
