package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import controller.UserInfofromDb;

/**
 * This class runs the delete query to delete user record from the database.
 *
 */
public class DeleteProfileModel {

	public void deleteRecord(UserInfofromDb userInfofromDb) throws SQLException {
		Connection connect = null;

		try {
			// Execute a query
			System.out.println("Deleting records from the table...");
			connect = DBConnect.connect();
			Statement stmt = connect.createStatement();
			String sql = "Delete from leaderboard_tab1 where userid = " + userInfofromDb.dbUserId;
			stmt.executeUpdate(sql);
		} finally {
			if (connect != null) {
				connect.close();
			}
		}

	}

}
