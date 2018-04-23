package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerCardModel {
	// checks if username and password are stored in the database ****
	// if not prompts them to create a account
	public ResultSet login(String userName, String password) throws SQLException {
		Connection connect = null;
		try {
			// // Execute a query

			System.out.println("Fetching Player records from the table...");
			connect = DBConnect.connect();
			Statement stmt = connect.createStatement();
			String sql = "Select * from leaderboard_tab1 where username = \"" + userName + "\" and password = \""
					+ password + "\"";
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} finally {
			if (connect != null) {
				connect.close();
			}
		}
	}
}
