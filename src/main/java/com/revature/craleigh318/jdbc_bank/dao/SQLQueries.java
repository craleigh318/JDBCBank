package com.revature.craleigh318.jdbc_bank.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.craleigh318.jdbc_bank.utils.DataHandler;

class SQLQueries {
	
	static PreparedStatement prepareStatement(String sql) throws SQLException, IOException {
		return DataHandler.handler().connection().prepareStatement(sql);
	}
	
	private SQLQueries() { }
}
