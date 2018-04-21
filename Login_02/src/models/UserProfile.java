package models;

import java.io.File;

public class UserProfile {

	final String desc;
	final File file;
	final int losses;
	final String name;
	final String pwd;
	final int score;
	final int wins;

	public UserProfile(String name, String pwd, String desc, File file, int score, int wins, int losses) {
		this.name = name;
		this.pwd = pwd;
		this.desc = desc;
		this.file = file;
		this.score = score;
		this.wins = wins;
		this.losses = losses;
	}

	public String getDesc() {
		return desc;
	}

	public File getFile() {
		return file;
	}

	public int getLosses() {
		return losses;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public int getScore() {
		return score;
	}

	public int getWins() {
		return wins;
	}

}
