package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.stage.Stage;
import models.PlayerCardModel;
import views.PlayerCardView;
import views.YourStatsView;

public class PlayerCardController {

	private final DeleteProfileController deleteProfileController;
	private final LeaderBoardController leaderBoardController;
	private final PlayerCardModel playerCardModel;
	private PlayerCardView playerCardView;
	private final YourStatsController statsController;
	private final UpdateProfileController updateProfileController;

	public PlayerCardController(PlayerCardModel playerCardModel, YourStatsController statsController,
			LeaderBoardController leaderBoardController, UpdateProfileController updateProfileController,
			DeleteProfileController deleteProfileController) {
		this.playerCardModel = playerCardModel;
		this.statsController = statsController;
		this.leaderBoardController = leaderBoardController;
		this.updateProfileController = updateProfileController;
		this.deleteProfileController = deleteProfileController;
	}

	public void consumePlayerRecord() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				PlayerCardController.this.playerCardView.start(new Stage());
			}
		});
	}

	public void deleteProfile(UserInfofromDb userInfofromDb) throws SQLException, FileNotFoundException {
		this.deleteProfileController.setUserInfo(userInfofromDb);
		this.deleteProfileController.alertView();
	}

	public void setPlayerCardView(PlayerCardView playerCardView) {
		this.playerCardView = playerCardView;
		this.playerCardView.addController(this);
		this.statsController.setStatsView(new YourStatsView(playerCardView.getInfo()));
		consumePlayerRecord();

	}

	public void updateProfile(UserInfofromDb userInfofromDb) throws FileNotFoundException, SQLException {
		this.updateProfileController.createUpdateView(userInfofromDb);
	}

	public void viewHighestScore() throws SQLException, IOException {
		this.leaderBoardController.viewHighestScores();
	}

	public void yourStatsView() throws FileNotFoundException, SQLException {
		this.statsController.yourStatsView();
	}

}
