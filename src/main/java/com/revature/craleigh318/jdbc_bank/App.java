package com.revature.craleigh318.jdbc_bank;

import java.io.IOException;

import com.revature.craleigh318.jdbc_bank.front_end.ConsoleView;
import com.revature.craleigh318.jdbc_bank.utils.DataHandler;
import com.revature.craleigh318.jdbc_bank.utils.InputOutput;

/**
 * Entry point.
 */
public class App 
{
    public static void main(String[] args)
    {
        try {
        	ConsoleView.show();
            cleanUp();
        } catch (IOException e) {
        	InputOutput.out().println("Connection failed.");
        }
    }
    
    private static void cleanUp() throws IOException {
    	DataHandler.cleanUp();
    	InputOutput.cleanUp();
    }
}
