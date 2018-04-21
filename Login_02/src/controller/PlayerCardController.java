package controller;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.stage.Stage;
import models.PlayerCardModel;
import views.PlayerCardView;

public class PlayerCardController {

	private final PlayerCardModel playerCardModel;
	private PlayerCardView playerCardView;
	private YourStatsController statsController;
	
	
	public PlayerCardController(PlayerCardModel playerCardModel, 
							   YourStatsController statsController) {
		this.playerCardModel = playerCardModel;
		this.statsController = statsController;
	}
	
	
	
	
	
	
	
	public void setPlayerCardView(PlayerCardView playerCardView) {
		this.playerCardView = playerCardView; 
		this.playerCardView.addController(this); 
		consumePlayerRecord(); 
		
	}
	
	
	
	public void yourStatsView() throws FileNotFoundException, SQLException {
		this.statsController.yourStatsView();
	}
	//public void createAccountView() throws FileNotFoundException, SQLException {
	//	this.createNewAccountController.createAccountView();
	
	public PlayerCardController() {
		this.playerCardModel = null;
		this.playerCardView = null;
		this.statsController = null;
	}
	

	public void consumePlayerRecord() {
		Platform.runLater(new Runnable() {
		      @Override
		      public void run() {
		    	  PlayerCardController.this.playerCardView.start(new Stage());
		      }
		  });
	}
	
}
