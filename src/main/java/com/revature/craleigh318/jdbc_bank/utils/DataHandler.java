package com.revature.craleigh318.jdbc_bank.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataHandler {
	
	private static final String PROPERTIES_FILENAME = "oracle_database.properties";
	private static final String DB_ENDPOINT = "endpoint";
	private static final String DB_PORT = "port";
	private static final String DB_NAME = "dbName";
	
	private static DataHandler dataHandler = null;
	
	public static DataHandler handler() {
		if (dataHandler == null) {
			dataHandler = new DataHandler();
		}
		return dataHandler;
	}
	
	public static void cleanUp() throws IOException {
		if (dataHandler != null) {
			dataHandler.cleanUpFileInputStream();
		}
	}
	
	private Connection connection = null;
	private InputStream propertiesInput = null;
	private Properties properties = null;
	private String jdbcUrl = null;
	
	private DataHandler() { }
	
	public Connection connection() throws SQLException, IOException {
		if (connection == null) {
			connection = DriverManager.getConnection(url(), properties());
		}
		return connection;
	}
	
	private String url() throws IOException {
		if (jdbcUrl == null) {
			Properties prop = properties();
			return prop.getProperty(DB_ENDPOINT) + ':' + prop.getProperty(DB_PORT) + ':' + prop.getProperty(DB_NAME);
		}
		return jdbcUrl;
	}
	
	private Properties properties() throws IOException {
		if (properties == null) {
			properties = new Properties();
			properties.load(input());
		}
		return properties;
	}
	
	private InputStream input() throws FileNotFoundException {
		if (propertiesInput == null) {
			propertiesInput = new FileInputStream(PROPERTIES_FILENAME);
		}
		return propertiesInput;
	}
	
	private void cleanUpFileInputStream() throws IOException {
		if (propertiesInput != null) {
			propertiesInput.close();
		}
	}
}
