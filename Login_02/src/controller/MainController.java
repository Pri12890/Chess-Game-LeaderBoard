package controller;

import javafx.application.Platform;
import javafx.stage.Stage;
import models.LoginModel;
import models.NewAccountModel;
import models.PlayerCardModel;
import views.CreateNewAccountView;
import views.LoginView;
import views.YourStatsView;

public class MainController {

	public static void main(String[] args) {
		// int score = RandomScoreGenerator.getScore();
		final CreateNewAccountView createNewAccountview = new CreateNewAccountView();
		final NewAccountModel model = new NewAccountModel();

		final CreateNewAccountController createNewAccountcontroller = new CreateNewAccountController(model,
				createNewAccountview);
		createNewAccountview.addController(createNewAccountcontroller);

		final LoginView loginView = new LoginView();
		final LoginModel loginModel = new LoginModel();
		// final PlayerCardView playerCardView = new PlayerCardView();
		final PlayerCardModel playerCardModel = new PlayerCardModel();
		final YourStatsView yourStatsView = new YourStatsView(null);
		final YourStatsController statsController = new YourStatsController();
		final PlayerCardController playerCardController = new PlayerCardController(playerCardModel, statsController);
		final LoginController loginController = new LoginController(createNewAccountcontroller, loginModel,
				playerCardController);

		loginView.addController(loginController);

		// Error - This operation is permitted on the event thread only; currentThread =
		// main
		// create JavaFX runnable thread - to show view.
		Platform.startup(new Runnable() {
			@Override
			public void run() {
				// Application starts here with Login View
				loginView.start(new Stage());
			}
		});

	}

}
