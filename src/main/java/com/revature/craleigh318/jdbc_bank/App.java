package com.revature.craleigh318.jdbc_bank;

import java.io.IOException;

import com.revature.craleigh318.jdbc_bank.front_end.LoginPrompt;
import com.revature.craleigh318.jdbc_bank.utils.DataHandler;
import com.revature.craleigh318.jdbc_bank.utils.InputOutput;

/**
 * Entry point.
 */
public class App 
{
    public static void main( String[] args )
    {
        LoginPrompt.prompt().logIn();
        cleanUp();
    }
    
    private static void cleanUp() {
    	try {
			DataHandler.cleanUp();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	InputOutput.cleanUp();
    }
}
