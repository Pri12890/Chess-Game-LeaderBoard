package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import models.LoginModel;
import views.PlayerCardView;

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

	public void createAccountView() throws FileNotFoundException, SQLException {
		this.createNewAccountController.createAccountView();
	}

	public UserInfofromDb login(String userName, String password) throws SQLException, IOException {
		return this.loginModel.login(userName, password);
	}

	public void openPlayerCardView(UserInfofromDb userInfofromDb) {
		this.playerCardController.setPlayerCardView(new PlayerCardView(userInfofromDb));

	}
}
