package models;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import views.PlayerCardView;
import views.PlayerView;

public class LoginModel {
	//checks if username and password are stored in the database ****
		//if not prompts them to create a account
	public ResultSet login(String userName, String password)  throws SQLException, IOException{
		Connection connect = null;
		try {
			// Execute a query
			
			System.out.println("Inserting records into the table...");
			 connect = DBConnect.connect();
			 Statement stmt = connect.createStatement();
			String sql = "Select * from leaderboard_tab where username = \""+ userName + "\" and password = \"" + password +"\"";
			ResultSet rs = stmt.executeQuery(sql);
			

			//new PlayerCardView.runView(rs); 
			new PlayerView().runView(rs);
			return rs; 
		}finally {
			if(connect != null) {
					connect.close();
			}
		}
	}
}
	

	





