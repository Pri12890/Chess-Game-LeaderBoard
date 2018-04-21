package models;

import java.util.Random;

public class RandomScoreGenerator {
	// This class generates random Scores, Wins, Losses for the new accounts.
	//

	private static Random random = new Random();

	public static int generateLosses() {
		int losses = random.nextInt(50);
		return losses;
	}

	public static int generateScore() {
		int score = random.nextInt(1000);
		return score;

	}

	public static int generateWins() {
		int wins = random.nextInt(50);
		return wins;
	}
}
