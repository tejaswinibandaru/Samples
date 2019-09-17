package com.cg.brs.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.brs.exception.DBException;

public class DBUtil {

	private static Logger logger;
	private static Connection connection;
	static {

		Properties properties = System.getProperties();

		String userDir = properties.getProperty("user.dir") + "\\src\\main\\resources\\";

		System.out.println("Current working directory is " + userDir);
		PropertyConfigurator.configure(userDir + "log4j.properties");
		logger = Logger.getLogger("DBUtil.class");
	}

	public static Connection getConnection() throws DBException {

		String url, username, password;
		try {
			// creating properties and load the properties
			Properties property = DBUtil.loadProp();

			// get properties from file
			// driver = prop.getProperty("driver");
			url = property.getProperty("url");
			username = property.getProperty("user");
			password = property.getProperty("password");

			// loading and registering the driver
			// Class.forName(driver);

			// getConnection
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null)
				logger.info("connection Obtained! : " + connection);
			// System.out.println("connection Obtained!");
			else
				throw new DBException("sorry!!! Something went wrong" + " with the connection");
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}
		return connection;
	}// end of method
		// method for loading property file

	private static Properties loadProp() throws DBException {
		Properties properties = System.getProperties();

		String userDir = properties.getProperty("user.dir") + "\\src\\main\\resources\\";
		Properties myProp = new Properties();
		try (FileInputStream fis = new FileInputStream(userDir + "jdbc.properties")) {
			myProp.load(fis);
			logger.info("Property File loaded : ");
		} catch (Exception e) {
			logger.error("Property File Not loaded");
			throw new DBException(e.getMessage());
		}
		return myProp;
	}

//method for closing the connection
	public static void closeConnection() throws DBException {
		try {
			if (connection != null) {
				connection.close();
				logger.error("Closing Connection");
			} else
				logger.error("Connection already closed");
		} catch (Exception e) {
			logger.error("Connection already closed");
			throw new DBException(e.getMessage());
		}
	}

}
