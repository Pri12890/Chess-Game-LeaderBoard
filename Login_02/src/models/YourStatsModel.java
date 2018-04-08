package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class YourStatsModel {
	//pull the stats for just the person
	DBConnect conn = new DBConnect();
	Statement stmt = null;
	public ResultSet retrieveRecords() throws SQLException { 

		ResultSet rs = null; 
		try {
			stmt = conn.connect().createStatement(); 
			String sql =  "select username,score, wins, losses from leaderboard_tab";
			rs = stmt.executeQuery(sql); 
		}  
		finally {
			conn.connect().close(); 
		}return rs;
	}
}
//userid INTEGER NOT NULL AUTO_INCREMENT , " + 
//" password VARCHAR(10), "
//+ " username VARCHAR(15), "
//+ " decription VARCHAR(50), "
//+ " score numeric(8,2), " 
//+ " wins numeric(8,2), " 
//+ " losses numeric(8,2), "
//+ " image blob, " 
