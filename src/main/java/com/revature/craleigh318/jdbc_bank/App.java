package com.revature.craleigh318.jdbc_bank;

import com.revature.craleigh318.jdbc_bank.utils.InputOutput;

/**
 * Entry point.
 */
public class App 
{
    public static void main( String[] args )
    {
        InputOutput.out().print("Username: ");
        String username = InputOutput.in().readLine();
        InputOutput.out().print("\nPassword: ");
        char[] password = InputOutput.in().readPassword();
    }
}
