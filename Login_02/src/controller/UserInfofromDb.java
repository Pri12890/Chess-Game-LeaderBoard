package controller;

import java.math.BigDecimal;

import javafx.scene.image.Image;

/**
 * This class is a placeholder to pass the database information across different
 * controllers.
 */
public class UserInfofromDb {
	public final String dbDescription;
	public final BigDecimal dbLosses;
	public final BigDecimal dbScore;
	public final int dbUserId;
	public final String dbUserName;
	public final BigDecimal dbWins;
	public final Image image;

	/*
	 * Constructor
	 */
	public UserInfofromDb(int dbUserId, String dbUserName, String dbDescription, Image image, BigDecimal dbScore,
			BigDecimal dbWins, BigDecimal dbLosses) {
		this.dbUserId = dbUserId;
		this.dbUserName = dbUserName;
		this.dbDescription = dbDescription;
		this.image = image;
		this.dbScore = dbScore;
		this.dbWins = dbWins;
		this.dbLosses = dbLosses;
	}

}
