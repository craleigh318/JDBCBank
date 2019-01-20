package com.revature.craleigh318.jdbc_bank.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.craleigh318.jdbc_bank.utils.DataHandler;

class SQLQueries {
	
	static ResultSet executeQuery(String sql) throws SQLException, IOException {
		return createStatement().executeQuery(sql);
	}
	
	private static Statement createStatement() throws SQLException, IOException {
		return DataHandler.handler().connection().createStatement();
	}
	
	private SQLQueries() { }
}
