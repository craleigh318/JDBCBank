package com.revature.craleigh318.jdbc_bank.services;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.craleigh318.jdbc_bank.model.BankAccount;

public class BankAccountFactory {
	
	private static final int BANK_ACCOUNT_ID = 1;
	private static final int BANK_ACCOUNT_BALANCE = 2;
	
	public BankAccount fromSQL(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt(BANK_ACCOUNT_ID);
		BigDecimal balance = resultSet.getBigDecimal(BANK_ACCOUNT_BALANCE);
		balance = balance.setScale(BankAccount.CENT_PRECISION);
		return new BankAccount(id, balance);
	}
	
	private BankAccountFactory() { }
}
