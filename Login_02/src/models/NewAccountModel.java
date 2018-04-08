package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class NewAccountModel {
	//insert entries
	DBConnect conn = new DBConnect(); ;
	Statement stmt = null;
	// This class generates random score, wins, losses for new user 
	RandomScoreGenerator rs = new RandomScoreGenerator(); 
	
// Insert User's personal Details 
	public void insertRecords() {

		try {
			// Execute a query
			System.out.println("Inserting records into the table...");
			// Include all object data to the database table
			Connection connect = conn.connect();


			// inserting all object data (pid, id, income, pep) into database table 

			String sql = "INSERT INTO leaderboard_tab(password, username, description, image) " +
				"VALUES (?,?,?,?)" ;
			PreparedStatement preparedStmt = connect.prepareStatement(sql); 
			// Add prepared Statements for all records 

			preparedStmt.execute(); 
			//stmt.executeUpdate(sql);

			connect.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	
	

}
