package controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.stage.Stage;
import models.PlayerCardModel;
import views.PlayerCardView;
import views.YourStatsView;

public class PlayerCardController {

	private final PlayerCardModel playerCardModel;
	private PlayerCardView playerCardView;
	private YourStatsController statsController;

	public PlayerCardController() {
		this.playerCardModel = null;
		this.playerCardView = null;
		this.statsController = null;
	}

	public PlayerCardController(PlayerCardModel playerCardModel, YourStatsController statsController) {
		this.playerCardModel = playerCardModel;
		this.statsController = statsController;
	}

	public void consumePlayerRecord() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				PlayerCardController.this.playerCardView.start(new Stage());
			}
		});
	}

	public void setPlayerCardView(PlayerCardView playerCardView) {
		this.playerCardView = playerCardView;
		this.playerCardView.addController(this);
		this.statsController.setStatsView(new YourStatsView(playerCardView.getInfo()));
		consumePlayerRecord();

	}

	public void yourStatsView() throws FileNotFoundException, SQLException {
		this.statsController.yourStatsView();
	}

}
