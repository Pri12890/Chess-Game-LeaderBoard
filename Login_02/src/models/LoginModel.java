package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginModel {
	//checks if username and password are stored in the database
	//if not prompts them to create a account

	// check for username and password 

	// Declare DB Objects 
	DBConnect conn = new DBConnect();
	Statement stmt = null;
	public ResultSet retrieveRecords() throws SQLException { 

		ResultSet rs = null; 
		try {
			stmt = conn.connect().createStatement(); 
			String sql =  "select userId, username,description, image from leaderboard_tab";
			rs = stmt.executeQuery(sql); 
		}  
		finally {
			conn.connect().close(); 
		}return rs;
	}
}

//			try {
//				stmt = conn.connect().createStatement();
//			} catch (SQLException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			} 
//			 String sql =  "select userId, username,description, image from leaderboard_tab";
//			 
//			 try {
//				rs = stmt.executeQuery(sql);
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} 
//			 try {
//				conn.connect().close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//			 return rs; 
//			} 



