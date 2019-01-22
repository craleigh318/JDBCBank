package com.revature.craleigh318.jdbc_bank.front_end;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import com.revature.craleigh318.jdbc_bank.dao.BankAccountQueries;
import com.revature.craleigh318.jdbc_bank.dao.UserQueries;
import com.revature.craleigh318.jdbc_bank.exceptions.OverdraftException;
import com.revature.craleigh318.jdbc_bank.model.BankAccount;
import com.revature.craleigh318.jdbc_bank.model.User;
import com.revature.craleigh318.jdbc_bank.utils.InputOutput;

class AccountMaintenance {

	static void logIn(User user) throws IOException {
		greeting(user);
		pullInfo(user);
	}
	
	private static void greeting(User user) {
		InputOutput.out().println("Hello, " + user.getUsername() + "!");
	}
	
	private static void pullInfo(User user) throws IOException {
		BankAccount ba;
		try {
			ba = getBa(user);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		printBalance(ba);
		prompt(user, ba);
	}
	
	private static BankAccount getBa(User user) throws SQLException, IOException {
		int baid = user.getBankAccountId();
		return BankAccountQueries.getBankAccount(baid);
	}
	
	private static void printBalance(BankAccount ba) {
		InputOutput.out().println("You current balance is: $" + ba.getBalance());
	}
	
	private static void prompt(User user, BankAccount ba) throws IOException {
		final String DEPOSIT = "1";
		final String WITHDRAW = "2";
		final String CLOSE = "3";
		final String LOG_OUT = "4";
		InputOutput.out().println("What would you like to do today?\n" + DEPOSIT + ") Deposit funds\n" + WITHDRAW +") Withdraw funds\n" + CLOSE + "Close account\n" + LOG_OUT + "Log Out");
		String input = InputOutput.in().readLine();
		switch (input) {
		case DEPOSIT:
			deposit(ba);
			break;
		case WITHDRAW:
			try {
				withdraw(ba);
			} catch (OverdraftException e) {
				InputOutput.out().println(OverdraftException.MESSAGE);
			}
			break;
		case CLOSE:
			close(user, ba);
			break;
		case LOG_OUT:
			return;
		default:
			InputOutput.out().println("Please select a valid option.");
		}
		pullInfo(user);
	}
	
	private static BigDecimal enterAmount() {
		InputOutput.out().println("Please enter an amount: $");
		String input = InputOutput.in().readLine();
		BigDecimal bdInput;
		try {
			bdInput = new BigDecimal(input);
		} catch (NumberFormatException e) {
			InputOutput.out().println("Invalid amount.");
			return null;
		}
		bdInput.setScale(BankAccount.CENT_PRECISION);
		return bdInput;
	}
	
	private static void deposit(BankAccount ba) throws IOException {
		BigDecimal balance = ba.getBalance();
		BigDecimal depositAmount = enterAmount();
		ba.setBalance(balance.add(depositAmount));
		try {
			BankAccountQueries.updateBalance(ba);
		} catch (SQLException e) {
			InputOutput.out().println("Depsoit failed.");
		}
	}
	
	private static void withdraw(BankAccount ba) throws OverdraftException, IOException {
		BigDecimal balance = ba.getBalance();
		BigDecimal withdrawalAmount = enterAmount();
		int comparison = balance.compareTo(withdrawalAmount);
		boolean overdraft = comparison < 0;
		if (overdraft) {
			throw new OverdraftException();
		}
		ba.setBalance(balance.subtract(withdrawalAmount));
		try {
			BankAccountQueries.updateBalance(ba);
		} catch (SQLException e) {
			InputOutput.out().println("Withdrawal failed.");
		}
	}
	
	private static void close(User user, BankAccount ba) throws IOException {
		BigDecimal balance = ba.getBalance();
		float fBalance = balance.floatValue();
		if (fBalance > 0.0f) {
			InputOutput.out().println("You must have a balance of $0.00 to close your account.");
			return;
		}
		try {
			UserQueries.deleteUser(user.getId());
			BankAccountQueries.deleteAccount(ba.getId());
		} catch (SQLException e) {
			InputOutput.out().println("Closure failed.");
		}
	}
	
	private AccountMaintenance() { }
}
