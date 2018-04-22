package controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.stage.Stage;
import models.UpdateProfileModel;
import models.UpdatedUserProfile;
import views.UpdateProfileView;

public class UpdateProfileController {

	private final UpdateProfileModel updateProfileModel;
	private final UpdateProfileView updateProfileView;

	public UpdateProfileController(UpdateProfileModel updateProfileModel, UpdateProfileView updateProfileView) {
		this.updateProfileView = updateProfileView;
		this.updateProfileModel = updateProfileModel;
	}

	public void createUpdateView() throws SQLException, FileNotFoundException {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					UpdateProfileController.this.updateProfileView.start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void createUpdateView(UserInfofromDb userInfofromDb) throws SQLException, FileNotFoundException {
		this.updateProfileView.addUserToUpdate(userInfofromDb);
		this.updateProfileView.addController(this);
		createUpdateView();
	}

	public void updateRecord(UserInfofromDb userInfofromDb, UpdatedUserProfile updatedUserProfile)
			throws SQLException, FileNotFoundException {
		this.updateProfileModel.updateRecord(userInfofromDb, updatedUserProfile);
	}
}
