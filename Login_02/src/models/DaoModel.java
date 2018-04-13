package models;


import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Blob;
//import records.BankRecords;

public class DaoModel {
	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;

	// constructor
	public DaoModel() { // create db object instance
		conn = new DBConnect();
	}

	public void createTable() {

		try {
			// Open a connection
			System.out.println("Connecting to a selected database to createTable...");
			System.out.println("Connected database successfully...");

			// Execute create query
			System.out.println("Creating table in given database...");
			stmt = conn.connect().createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS leaderboard_tab  " + 
				"( userid INTEGER NOT NULL AUTO_INCREMENT , " + 
				" password VARCHAR(10), "
				+ " username VARCHAR(15), "
				+ " decription VARCHAR(100), "
				+ " score numeric(8,2), " 
				+ " wins numeric(8,2), " 
				+ " losses numeric(8,2), "
				+ " image blob, " 
				+ " PRIMARY KEY ( userid ))";
			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
			conn.connect().close(); // close db connection
		} catch (SQLException se) {

			// Handle errors for JDBC
			se.printStackTrace();

		}

	}

	// INSERT INTO METHOD

	/*	public void insertRecords(BankRecords[] robjs) { 
		try { 
	// Execute a query 
	System.out.println("Inserting records into the table..."); 
	stmt = conn.connect().createStatement(); 
	// Include all object data to the database table 
	for (int i = 0; i < robjs.length; ++i) { 
	// finish string assignment to insert all object data  
	// (pid, id, income, pep) into your database table 
	String sql = "INSERT INTO a_dama_tab(id,income, pep) " + 
	"VALUES (' "+robjs[i].getId()+"', ' "+robjs[i].getIncome()+"  ', ' "+robjs[i].getPep()+" ' )";  
	//test connection and output
	//System.out.println("Pep " + robjs[i].getPep());

	stmt.executeUpdate(sql); 
	} 
	conn.connect().close(); 
	} catch (SQLException se) { 
	se.printStackTrace(); 
	} 

	}*/

	/*	public ResultSet retrieveRecords() throws SQLException { 

		ResultSet rs = null; 
		stmt = conn.connect().createStatement(); 
		String sql =  "select pid, id,income, pep from a_dama_tab order by pep desc";

		rs = stmt.executeQuery(sql); 
		conn.connect().close(); 
		return rs; 
		} */
}
