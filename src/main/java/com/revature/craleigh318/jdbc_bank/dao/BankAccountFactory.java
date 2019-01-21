package com.revature.craleigh318.jdbc_bank.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.craleigh318.jdbc_bank.model.BankAccount;

public class BankAccountFactory {
	
	public static final int BANK_ACCOUNT_ID = 1;
	public static final int BANK_ACCOUNT_BALANCE = 2;
	
	public static BankAccount fromSQL(ResultSet resultSet) {
		Integer id;
		try {
			id = resultSet.getInt(BANK_ACCOUNT_ID);
		} catch (SQLException e) {
			e.printStackTrace();
			id = null;
		}
		BigDecimal balance;
		try {
			balance = resultSet.getBigDecimal(BANK_ACCOUNT_BALANCE);
			balance = balance.setScale(BankAccount.CENT_PRECISION);
		} catch (SQLException e) {
			e.printStackTrace();
			balance = null;
		}
		return new BankAccount(id, balance);
	}
	
	private BankAccountFactory() { }
}
