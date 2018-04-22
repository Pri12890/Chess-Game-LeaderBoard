package controller;

import javafx.application.Platform;
import javafx.stage.Stage;
import models.DeleteProfileModel;
import models.LeaderBoardModel;
import models.LoginModel;
import models.NewAccountModel;
import models.PlayerCardModel;
import models.UpdateProfileModel;
import views.AlertView;
import views.CreateNewAccountView;
import views.LeaderBoardView;
import views.LoginView;
import views.UpdateProfileView;

public class MainController {

	public static void main(String[] args) {
		final CreateNewAccountView createNewAccountview = new CreateNewAccountView();
		final NewAccountModel model = new NewAccountModel();

		final CreateNewAccountController createNewAccountcontroller = new CreateNewAccountController(model,
				createNewAccountview);
		createNewAccountview.addController(createNewAccountcontroller);

		final LoginView loginView = new LoginView();
		final LoginModel loginModel = new LoginModel();
		// final PlayerCardView playerCardView = new PlayerCardView();
		final PlayerCardModel playerCardModel = new PlayerCardModel();
		final YourStatsController statsController = new YourStatsController();
		final UpdateProfileModel updateProfileModel = new UpdateProfileModel();
		final UpdateProfileView updateProfileView = new UpdateProfileView();
		final DeleteProfileModel deleteProfileModel = new DeleteProfileModel();
		final AlertView alertView = new AlertView();
		final UpdateProfileController updateProfileController = new UpdateProfileController(updateProfileModel,
				updateProfileView);
		final DeleteProfileController deleteProfileController = new DeleteProfileController(deleteProfileModel,
				alertView);
		LeaderBoardView leaderBoardView = new LeaderBoardView();
		LeaderBoardModel leaderBoardModel = new LeaderBoardModel();
		final LeaderBoardController leaderBoardController = new LeaderBoardController(leaderBoardModel,
				leaderBoardView);
		final PlayerCardController playerCardController = new PlayerCardController(playerCardModel, statsController,
				leaderBoardController, updateProfileController, deleteProfileController);
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
