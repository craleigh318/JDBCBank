package com.revature.craleigh318.jdbc_bank;

import com.revature.craleigh318.jdbc_bank.front_end.LoginPrompt;

/**
 * Entry point.
 */
public class App 
{
    public static void main( String[] args )
    {
        LoginPrompt.prompt().logIn();
    }
}
