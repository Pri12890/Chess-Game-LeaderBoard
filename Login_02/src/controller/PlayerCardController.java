package controller;

import java.sql.ResultSet;

import javafx.application.Platform;
import javafx.stage.Stage;
import models.PlayerCardModel;
import views.PlayerCardView;

public class PlayerCardController {

	private final PlayerCardModel playerCardModel;
	private final PlayerCardView playerCardView;
	
	public PlayerCardController(PlayerCardModel playerCardModel, PlayerCardView playerCardView) {
		this.playerCardModel = playerCardModel;
		this.playerCardView = playerCardView;
	}
	
	public PlayerCardController() {
		this.playerCardModel = null;
		this.playerCardView = null;
	}

	public void consumePlayerRecord(ResultSet rs) {
		Platform.runLater(new Runnable() {
		      @Override
		      public void run() {
		    	  PlayerCardController.this.playerCardView.start(new Stage());
		      }
		  });
	}
	
}
