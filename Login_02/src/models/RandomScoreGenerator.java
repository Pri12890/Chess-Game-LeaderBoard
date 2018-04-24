package models;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This class has the responsibility to create random scores, wins and losses
 * for the users
 */
public class RandomScoreGenerator {
	// This class generates random Scores, Wins, Losses for the new accounts.
	private static ThreadLocalRandom random = ThreadLocalRandom.current();

	public static int generateLosses() {
		int losses = random.nextInt(10, 20);
		return losses;
	}

	public static int generateScore() {
		int score = random.nextInt(1000, 10000);
		return score;

	}

	public static int generateWins() {
		int wins = random.nextInt(20, 25);
		return wins;
	}
}
