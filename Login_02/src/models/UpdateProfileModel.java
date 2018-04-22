package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.UserInfofromDb;

public class UpdateProfileModel {

	public void updateRecord(UserInfofromDb userInfofromDb, UpdatedUserProfile updatedUserProfile)
			throws SQLException, FileNotFoundException {
		Connection connect = null;

		try {
			// Execute a query

			System.out.println("Deleting records from the table...");
			connect = DBConnect.connect();
			// and
			String sql = "update leaderboard_tab set  image = ? , decription = ?  where userid = ? ";
			// + userInfofromDb.dbUserId;
			PreparedStatement preparedStmt = connect.prepareStatement(sql);
			preparedStmt.setBinaryStream(1, new FileInputStream(updatedUserProfile.getFile()),
					(int) updatedUserProfile.getFile().length());
			preparedStmt.setString(2, updatedUserProfile.getDesc());
			preparedStmt.setInt(3, userInfofromDb.dbUserId);
			preparedStmt.executeUpdate();
			// Statement stmt = connect.createStatement();
			// int rs = stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("kyu phati hai " + e.getStackTrace());
		} finally {
			if (connect != null) {
				connect.close();
			}
		}

	}

}
