package models;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.UserInfofromDb;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import views.PlayerCardView;
import views.PlayerView;

public class LoginModel {
	
	 private final static int ID_INDEX = 1; // 
	 private final static int NAME_INDEX = 3;
	 private final static int DESC_INDEX = 4; 
	 private final static int SCORE_INDEX = 5; 
	 private final static int WINS_INDEX = 6; 
	 private final static int LOSSES_INDEX = 7; 
  // private final static int IMAGE_INDEX = 8; 
	
	//checks if username and password are stored in the database ****
		//if not prompts them to create a account
	public UserInfofromDb login(String userName, String password)  throws SQLException, IOException{
		Connection connect = null;
		
		try {
			// Execute a query
			
			System.out.println("Fetching records from the table...");
			 connect = DBConnect.connect();
			 Statement stmt = connect.createStatement();
			String sql = "Select * from leaderboard_tab where username = \""+ userName + "\" and password = \"" + password +"\"";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			return processResult(rs); 
		}finally {
			if(connect != null) {
					connect.close();
			}
		}
	}
	
	public UserInfofromDb processResult(final ResultSet rs) throws SQLException {
		
		//ResultSetMetaData metaData = rs.getMetaData();// column headers
		//int columns = metaData.getColumnCount(); // column count 
		int id = (int) rs.getObject(ID_INDEX);
		String name = (String) rs.getObject(NAME_INDEX);
		String desc = (String) rs.getObject(DESC_INDEX);
		
		//Image image = rs.getObject(IMAGE_INDEX);
		
		BigDecimal score = (BigDecimal) rs.getObject(SCORE_INDEX);
		BigDecimal wins = (BigDecimal) rs.getObject(WINS_INDEX);
		BigDecimal losses = (BigDecimal) rs.getObject(LOSSES_INDEX);
		Image image = null; 
		
		UserInfofromDb userInfofromDb = new UserInfofromDb(id, name, desc, image, score, wins, losses); 
		return userInfofromDb; 
	}
	
	
	
}
	

	





