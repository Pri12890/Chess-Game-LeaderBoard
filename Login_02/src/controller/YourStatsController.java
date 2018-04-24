package controller;

import javafx.stage.Stage;
import views.YourStatsView;

/**
 * This class has the responsibility of calling the Yourstatsview class to print
 * user statistics on LeaderBoard
 */
public class YourStatsController {

	private YourStatsView yourStatsView;

	public void setStatsView(YourStatsView yourStatsView) {
		this.yourStatsView = yourStatsView;
	}

	public void yourStatsView() {
		YourStatsController.this.yourStatsView.start(new Stage());
	}
}
