package controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.stage.Stage;
import views.YourStatsView;

public class YourStatsController {

	private YourStatsView yourStatsView;

	public YourStatsController() {

	}

	public void setStatsView(YourStatsView yourStatsView) {
		this.yourStatsView = yourStatsView;
	}

	public void yourStatsView() throws SQLException, FileNotFoundException {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				YourStatsController.this.yourStatsView.start(new Stage());
			}
		});

	}
}
