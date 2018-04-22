package controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.stage.Stage;
import models.DeleteProfileModel;
import views.AlertView;

public class DeleteProfileController {
	private final AlertView alertView;
	private final DeleteProfileModel deleteProfileModel;
	private UserInfofromDb userInfofromDB;

	public DeleteProfileController(DeleteProfileModel deleteProfileModel, AlertView alertView) {
		this.alertView = alertView;
		this.deleteProfileModel = deleteProfileModel;
		this.alertView.addController(this);
	}

	public void alertView() throws SQLException, FileNotFoundException {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					DeleteProfileController.this.alertView.start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void deleteProfile() throws SQLException {
		// TODO Auto-generated method stub
		this.deleteProfileModel.deleteRecord(this.userInfofromDB);
	}

	public void setUserInfo(UserInfofromDb userInfofromDb) {
		this.userInfofromDB = userInfofromDb;
		System.out.println("set user .... ");
	}
}
