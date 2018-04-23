package controller;

import javafx.stage.Stage;
import views.YourStatsView;

public class YourStatsController {

	private YourStatsView yourStatsView;

	public void setStatsView(YourStatsView yourStatsView) {
		this.yourStatsView = yourStatsView;
	}

	public void yourStatsView() {
		YourStatsController.this.yourStatsView.start(new Stage());
	}
}
