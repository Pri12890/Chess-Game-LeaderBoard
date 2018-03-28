package application;
import java.util.UUID;
/**
 * This class contains the Player Id, Player Name and Player Score for each player 
 */
public class PlayerScore extends ProfileCard implements Comparable<PlayerScore> {

	UUID playerId; 
	String playerName; 
	int playerScore;
	
/**
 * Constructor
 * @param playerId
 * @param playerName
 * @param playerScore
 */
	public PlayerScore(UUID playerId, String playerName, int playerScore) {	
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerScore = playerScore;
	}
	
/**
 * Getters and Setters
 */
	public UUID getPlayerId() {
		return playerId;
	}
	public void setPlayerId(UUID playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerScore() {
		return playerScore;
	}
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	@Override
	public int compareTo(PlayerScore arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
	
	
	
}
