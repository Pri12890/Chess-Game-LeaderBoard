package models;
import java.util.Random;

public class RandomScoreGenerator {
// This class generates random Scores, Wins, Losses for the new accounts. 
//
	
	Random random = new Random();

	public int generateScore() {
		int score = random.nextInt(1000); 
		return score;
		
	}
	
	public int generateWins() {
		int wins = random.nextInt(50); 
		return wins; 
	}
	
	public int generateLosses() {
		int losses = random.nextInt(50); 
		return losses; 
	}
}
