package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerCardModel {
	//checks if username and password are stored in the database ****
	//if not prompts them to create a account
public ResultSet login(String userName, String password)  throws SQLException{
	Connection connect = null;
	try {
//		// Execute a query
		
		System.out.println("Fetching Player records from the table...");
		 connect = DBConnect.connect();
		 Statement stmt = connect.createStatement();
		String sql = "Select * from leaderboard_tab where username = \""+ userName + "\" and password = \"" + password +"\"";
		ResultSet rs = stmt.executeQuery(sql);
		//new LoanView().runView(rs);
		//System.out.println(rs);
		return rs; 
	}finally {
		if(connect != null) {
				connect.close();
		}
	}
}
}

	
	

