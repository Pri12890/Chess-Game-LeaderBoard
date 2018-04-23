package controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.mysql.jdbc.StringUtils;

import javafx.stage.Stage;
import models.NewAccountModel;
import models.UserProfile;
import views.CreateNewAccountView;

public class CreateNewAccountController {

	private final CreateNewAccountView createNewAccountView;
	private LoginController loginController;
	private final NewAccountModel newAccountModel;

	public CreateNewAccountController(NewAccountModel newAccountModel, CreateNewAccountView createNewAccountView) {
		this.newAccountModel = newAccountModel;
		this.createNewAccountView = createNewAccountView;
	}

	public void addLoginController(LoginController loginController) {
		this.loginController = loginController;

	}

	public void createAccount(final UserProfile userProfile) throws SQLException, FileNotFoundException {
		this.newAccountModel.insertRecords(userProfile);
	}

	public void createAccountView() {
		CreateNewAccountController.this.createNewAccountView.start(new Stage());
	}

	public boolean doesUserExist(UserProfile profile) {
		try {
			UserInfofromDb login = this.loginController.login(profile.getName(), profile.getPwd());
			return login == null ? false : !StringUtils.isNullOrEmpty(login.dbUserName);
		} catch (SQLException e) {
			return false;
		}
	}

	public CreateNewAccountView getCreateNewAccountView() {
		return this.createNewAccountView;
	}

	public NewAccountModel getNewAccountModel() {
		return this.newAccountModel;
	}
}
