package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.stage.FileChooser;

public class NewAccountModel {
	
	/** This class generates random score, wins, losses for new user */
	final RandomScoreGenerator rs;
	
	public NewAccountModel() {
		this.rs =  new RandomScoreGenerator(); ;
	}

	
// Insert User's personal Details 
	public void insertRecords(UserProfile userProfile) throws SQLException {
		Connection connect = null;
		try {
//			// Execute a query
			System.out.println("Inserting records into the table...");
			 connect = DBConnect.connect();
			String sql = "INSERT INTO leaderboard_tab(username, password, decription, image) " +
					"VALUES (?,?,?,?)" ;

			PreparedStatement preparedStmt = connect.prepareStatement(sql);
			// inserting all user data (name, pwd, desc, image) into database table 
			preparedStmt.setString(1, userProfile.getName());
			preparedStmt.setString(2, userProfile.getPwd());
			preparedStmt.setString(3, userProfile.getDesc());
			// TODO : PA - if setObject works for image
			preparedStmt.setObject(4, userProfile.getImage());
			preparedStmt.execute();

		}finally {
			if(connect != null) {
				connect.close();
			}
		}
			
//	    FileChooser fileChooser; 
//	    FOR IMAGE FILES 
//		fileChooser = new FileChooser(); 
//		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("*.png", "*.jpg", "*.gif")); 

	}
}
