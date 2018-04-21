package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewAccountModel {
	/** This class generates random score, wins, losses for new user */
	final RandomScoreGenerator rs;

	public NewAccountModel() {
		this.rs = new RandomScoreGenerator();
		;
	}

	// Insert User's personal Details
	public void insertRecords(UserProfile userProfile) throws SQLException, FileNotFoundException {
		Connection connect = null;
		try {
			// // Execute a query
			System.out.println("Inserting records into the table...");
			connect = DBConnect.connect();
			String sql = "INSERT INTO leaderboard_tab(username, password, decription, image, score, wins, losses) "
					+ "VALUES (?,?,?,?,?,?,?)";

			PreparedStatement preparedStmt = connect.prepareStatement(sql);
			// inserting all user data (name, pwd, desc, image) into database table
			preparedStmt.setString(1, userProfile.getName());
			preparedStmt.setString(2, userProfile.getPwd());
			preparedStmt.setString(3, userProfile.getDesc());
			// TODO : PA - if setObject works for image
			preparedStmt.setBinaryStream(4, new FileInputStream(userProfile.getFile()),
					(int) userProfile.getFile().length());
			preparedStmt.setLong(5, userProfile.getScore());
			preparedStmt.setLong(6, userProfile.getWins());
			preparedStmt.setLong(7, userProfile.getLosses());

			preparedStmt.execute();

		} finally {
			if (connect != null) {
				connect.close();
			}
		}

	}
}
