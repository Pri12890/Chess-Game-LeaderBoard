package application;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
/**
 * This class does the book-keeping of all the player scores in a map, 
 * sorted by value<Player Score>
 * Map would be a pair of < Key, Value> which stores <UUID, Player Score> 
 */
public class LeaderBoard extends ProfileCard {
	



Map<UUID, PlayerScore> map;

// constructor
LeaderBoard(Map<UUID, PlayerScore> map) {
	HighestScore<UUID, PlayerScore> highScoreManager ;
}

public PlayerScore getPlayerScore(UUID playerId) {
	return map.get(playerId);
}

public PlayerScore getHighestScorer() {
	 return map.values().stream().findFirst().orElse(null);
}

}