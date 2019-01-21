package com.revature.craleigh318.jdbc_bank.front_end;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.craleigh318.jdbc_bank.dao.BankAccountQueries;
import com.revature.craleigh318.jdbc_bank.model.BankAccount;
import com.revature.craleigh318.jdbc_bank.model.User;
import com.revature.craleigh318.jdbc_bank.utils.InputOutput;

class AccountMaintenance {

	static void logIn(User user) throws IOException {
		greeting(user);
		BankAccount ba;
		try {
			ba = getBa(user);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		printBalance(ba);
	}
	
	private static void greeting(User user) {
		InputOutput.out().println("Hello, " + user.getUsername() + "!");
	}
	
	private static BankAccount getBa(User user) throws SQLException, IOException {
		int baid = user.getBankAccountId();
		return BankAccountQueries.getBankAccount(baid);
	}
	
	private static void printBalance(BankAccount ba) {
		InputOutput.out().println("You current balance is: $" + ba.getBalance());
	}
	
	private AccountMaintenance() { }
}
