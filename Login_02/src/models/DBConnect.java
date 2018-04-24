package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class has the responsibility of establishing a connection to the
 * database.
 */
public class DBConnect {

	// Code database URL
	static final String DB_URL = "jdbc:mysql://www.papademas.net:3306/510labs?autoReconnect=true&useSSL=false";
	// Database credentials
	static final String USER = "db510", PASS = "510";

	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}
}
