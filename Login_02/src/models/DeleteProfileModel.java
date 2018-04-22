package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import controller.UserInfofromDb;

public class DeleteProfileModel {

	public void deleteRecord(UserInfofromDb userInfofromDb) throws SQLException {
		Connection connect = null;

		try {
			// Execute a query

			System.out.println("Deleting records from the table...");
			connect = DBConnect.connect();
			Statement stmt = connect.createStatement();
			String sql = "Delete from leaderboard_tab where userid = " + userInfofromDb.dbUserId;
			int rs = stmt.executeUpdate(sql);

		} finally {
			if (connect != null) {
				connect.close();
			}
		}

	}

}
