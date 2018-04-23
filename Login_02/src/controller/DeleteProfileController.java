package controller;

import java.sql.SQLException;

import javafx.stage.Stage;
import models.DeleteProfileModel;
import views.AlertView;

public class DeleteProfileController {
	private final AlertView alertView;
	private final DeleteProfileModel deleteProfileModel;
	private PlayerCardController playerCardController;
	private UserInfofromDb userInfofromDB;

	public DeleteProfileController(DeleteProfileModel deleteProfileModel, AlertView alertView) {
		this.alertView = alertView;
		this.deleteProfileModel = deleteProfileModel;
		this.alertView.addController(this);
	}

	public void addPlayerController(PlayerCardController playerCardController) {
		this.playerCardController = playerCardController;
	}

	public void alertView() {
		DeleteProfileController.this.alertView.start(new Stage());
	}

	public void deleteProfile() throws SQLException {
		this.deleteProfileModel.deleteRecord(this.userInfofromDB);
	}

	public void playerView() {
		this.playerCardController.consumePlayerRecord();
	}

	public void setUserInfo(UserInfofromDb userInfofromDb) {
		this.userInfofromDB = userInfofromDb;
		System.out.println("set user .... ");
	}
}
