package models;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//pull the statistics from the leader board table,
// statistics are the user names and highest scores
public class LeaderBoardModel {

	public static class UserPartialInfo {
		final int id;

		final String name;

		final BigDecimal score;

		public UserPartialInfo(int id, String name, BigDecimal score) {
			this.id = id;
			this.name = name;
			this.score = score;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getScore() {
			return Optional.ofNullable(score).map(s -> s.toString()).orElse("");
		}

		@Override
		public String toString() {
			return "\t" + id + " \t\t\t\t " + name + "\t\t\t\t\t" + getScore();
		}

	}

	private final static int ID_INDEX = 1;
	private final static int NAME_INDEX = 2;

	private final static int SCORE_INDEX = 3;

	public List<UserPartialInfo> listSortedUsers() throws SQLException {
		Connection connect = null;

		try {
			// Execute a query
			System.out.println("Fetching records from the table for LeaderBoard...");
			connect = DBConnect.connect();
			Statement stmt = connect.createStatement();
			String sql = "select userId, username, score from leaderboard_tab1 order by score desc";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			return processResult(rs);
		} finally {
			if (connect != null) {
				connect.close();
			}
		}
	}

	public List<UserPartialInfo> processResult(final ResultSet rs) throws SQLException {

		List<UserPartialInfo> listOfUsers = new ArrayList<>();
		while (rs.next()) {
			int id = (int) rs.getObject(ID_INDEX);
			String name = (String) rs.getObject(NAME_INDEX);
			BigDecimal score = (BigDecimal) rs.getObject(SCORE_INDEX);

			UserPartialInfo userPatialInfo = new UserPartialInfo(id, name, score);
			listOfUsers.add(userPatialInfo);
		}

		return listOfUsers;
	}
}
