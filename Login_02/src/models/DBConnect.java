package models;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;

public class DBConnect {    // implements AutoCloseable ( will take care of Auto Close of connection to db each time.
	public static void main(String[] args) throws SQLException {

		connect(); 
	}
	// Code database URL
	static final String DB_URL = "jdbc:mysql://www.papademas.net:3306/510labs?autoReconnect=true&useSSL=false";
	// Database credentials
	static final String USER = "db510", PASS = "510";


	public static Connection connect() throws SQLException {

		return DriverManager.getConnection(DB_URL, USER, PASS);

	}

	/**
	 * Another Way to take care of closing db connection every time 
	 */
	//@Override
	//public void close() throws Exception {
	// TODO Auto-generated method stub
	//	connect().close();
}


