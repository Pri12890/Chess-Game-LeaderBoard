package controller;

import java.math.BigDecimal;

import javafx.scene.image.Image;

public class UserInfofromDb{
	public final int dbUserId;
	public final String dbUserName; 
	public final String dbDescription; 
	public final Image image; 
	public final BigDecimal dbScore; 
	public final BigDecimal dbWins; 
	public final BigDecimal dbLosses; 
	/*
	 * Constructor 
	 */
	public UserInfofromDb(int dbUserId,
						  String dbUserName, 
						  String dbDescription, 
						  Image image, 
						  BigDecimal dbScore,
						  BigDecimal dbWins,
						  BigDecimal dbLosses) {
		this.dbUserId = dbUserId;
		this.dbUserName = dbUserName;
		this.dbDescription = dbDescription;
		this.image = image;
		this.dbScore = dbScore;
		this.dbWins = dbWins;
		this.dbLosses = dbLosses;
	}
	
}
