package controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javafx.stage.Stage;
import models.UpdateProfileModel;
import models.UpdatedUserProfile;
import views.UpdateProfileView;

/**
 * This class has the responsibility to update the user Profile This class calls
 * the UpdateProfileModel to complete the update Process.
 */
public class UpdateProfileController {

	private final UpdateProfileModel updateProfileModel;
	private final UpdateProfileView updateProfileView;

	public UpdateProfileController(UpdateProfileModel updateProfileModel, UpdateProfileView updateProfileView) {
		this.updateProfileView = updateProfileView;
		this.updateProfileModel = updateProfileModel;
	}

	public void createUpdateView() {
		UpdateProfileController.this.updateProfileView.start(new Stage());
	}

	public void createUpdateView(UserInfofromDb userInfofromDb) {
		this.updateProfileView.addUserToUpdate(userInfofromDb);
		this.updateProfileView.addController(this);
		createUpdateView();
	}

	public void updateRecord(UserInfofromDb userInfofromDb, UpdatedUserProfile updatedUserProfile)
			throws SQLException, FileNotFoundException {
		this.updateProfileModel.updateRecord(userInfofromDb, updatedUserProfile);
	}
}
