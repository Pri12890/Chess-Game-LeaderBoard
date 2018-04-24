package controller;

import java.sql.SQLException;

import models.LoginModel;
import views.PlayerCardView;

/**
 * This class has the responsibility of doing login authentication for user.
 * Additionally, it can also talk to CreateNewAccountController and
 * PlayerCardController for creating their respective views.
 *
 */
public class LoginController {
	private final CreateNewAccountController createNewAccountController;
	private final LoginModel loginModel;
	private final PlayerCardController playerCardController;

	public LoginController(final CreateNewAccountController createNewAccountController, final LoginModel loginModel,
			final PlayerCardController playerCardController) {
		this.createNewAccountController = createNewAccountController;
		this.loginModel = loginModel;
		this.playerCardController = playerCardController;

	}

	public void createAccountView() {
		this.createNewAccountController.addLoginController(this);
		this.createNewAccountController.createAccountView();

	}

	public UserInfofromDb login(String userName, String password) throws SQLException {
		return this.loginModel.login(userName, password);
	}

	public void openPlayerCardView(UserInfofromDb userInfofromDb) {
		this.playerCardController.setPlayerCardView(new PlayerCardView(userInfofromDb));

	}
}
