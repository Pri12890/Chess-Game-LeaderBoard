package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.StringUtils;

import controller.UserInfofromDb;

/**
 * This class has the responsibility to Update the user records by running and
 * update query on the database
 */
public class UpdateProfileModel {

	public void updateRecord(UserInfofromDb userInfofromDb, UpdatedUserProfile updatedUserProfile)
			throws SQLException, FileNotFoundException {
		Connection connect = null;

		try {
			System.out.println("Updating records from the table...");
			connect = DBConnect.connect();
			if (!StringUtils.isNullOrEmpty(updatedUserProfile.getDesc()) && updatedUserProfile.getFile() != null) {

				String sql = "update leaderboard_tab1 set  image = ? , decription = ?  where userid = ? ";
				PreparedStatement preparedStmt = connect.prepareStatement(sql);
				preparedStmt.setBinaryStream(1, new FileInputStream(updatedUserProfile.getFile()),
						(int) updatedUserProfile.getFile().length());
				preparedStmt.setString(2, updatedUserProfile.getDesc());
				preparedStmt.setInt(3, userInfofromDb.dbUserId);
				preparedStmt.executeUpdate();
			} else if (StringUtils.isNullOrEmpty(updatedUserProfile.getDesc())) {
				String sql = "update leaderboard_tab1 set  image = ?  where userid = ? ";
				PreparedStatement preparedStmt = connect.prepareStatement(sql);
				preparedStmt.setBinaryStream(1, new FileInputStream(updatedUserProfile.getFile()),
						(int) updatedUserProfile.getFile().length());
				preparedStmt.setInt(2, userInfofromDb.dbUserId);
				preparedStmt.executeUpdate();
			} else {
				String sql = "update leaderboard_tab1 set decription = ?  where userid = ? ";
				PreparedStatement preparedStmt = connect.prepareStatement(sql);
				preparedStmt.setString(1, updatedUserProfile.getDesc());
				preparedStmt.setInt(2, userInfofromDb.dbUserId);
				preparedStmt.executeUpdate();
			}

		} finally {
			if (connect != null) {
				connect.close();
			}
		}

	}

}
