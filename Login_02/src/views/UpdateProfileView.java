package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.mysql.jdbc.StringUtils;

import controller.UpdateProfileController;
import controller.UserInfofromDb;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import models.UpdatedUserProfile;

/**
 * This class create an update view and allows the user to update their profile
 */
public class UpdateProfileView extends Application {

	File file;
	Scene scene;

	public UpdateProfileController updateProfileController;
	UserInfofromDb userInfofromDb;
	// stage window
	Stage window;

	public void addController(UpdateProfileController updateProfileController) {
		this.updateProfileController = updateProfileController;
	}

	public void addUserToUpdate(UserInfofromDb userInfofromDb) {
		this.userInfofromDb = userInfofromDb;
	}

	@Override
	public void start(Stage primaryStage) {

		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 600, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Text scenetitle = new Text("Update Your Profile");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		primaryStage.setScene(scene);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello to Chess Login");

		// Label and Text Field for Description
		Label description = new Label("Description:");
		grid.add(description, 0, 3);
		TextField descriptionTextField = new TextField();
		grid.add(descriptionTextField, 1, 3);

		// Label for Image
		Label image = new Label("Image:");
		grid.add(image, 0, 5);

		// Browse button for image selection
		Button ProfileBtn = new Button("Browse");
		HBox hbProfiltBtn = new HBox(10);
		hbProfiltBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbProfiltBtn.getChildren().add(ProfileBtn);
		grid.add(hbProfiltBtn, 1, 5);

		// Click to Update Button
		Button btnUpdate = new Button("Click to Update");
		HBox hbBtnUpdate = new HBox(10);
		hbBtnUpdate.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtnUpdate.getChildren().add(btnUpdate);
		grid.add(hbBtnUpdate, 1, 9);

		BorderPane layout = new BorderPane();
		final Text actiontarget = new Text();
		TextArea textArea = new TextArea();
		FileChooser fileChooser;
		fileChooser = new FileChooser();

		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
		// get the file form the desktop
		textArea.setFont(Font.font("SanSerif", 12));
		textArea.setPromptText("Path of Selected File or Files");
		textArea.setPrefSize(300, 50);
		textArea.setEditable(false);

		// FOR selecting IMAGE FILES using out browse button
		ProfileBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// object to aid us in the image view
				ImageView imageView = new ImageView();
				Image profileImage;
				file = fileChooser.showOpenDialog(primaryStage);

				if (file != null) {
					// desktop.open(file);
					textArea.setText(file.getAbsolutePath());
					// path, prefWidth, prefHeight, preserveRatio, smooth
					profileImage = new Image(file.toURI().toString(), 100, 150, true, true);
					imageView = new ImageView(profileImage);
					imageView.setFitWidth(100);
					imageView.setFitHeight(150);
					imageView.setPreserveRatio(true);
					layout.setCenter(imageView);
					BorderPane.setAlignment(imageView, Pos.TOP_LEFT);
					grid.add(imageView, 1, 5);
					grid.add(textArea, 1, 4);
				}
			}
		});

		// Update Button Handle
		btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					UpdatedUserProfile updatedUserProfile = new UpdatedUserProfile(descriptionTextField.getText(),
							file);
					if (file == null && StringUtils.isNullOrEmpty(updatedUserProfile.getDesc())) {
						throwError(grid, actiontarget);
					} else {
						UpdateProfileView.this.updateProfileController.updateRecord(userInfofromDb, updatedUserProfile);
						actiontarget.setFill(Color.GREEN);
						actiontarget.setText("Profile Updated");
						grid.add(actiontarget, 1, 7);
					}
				} catch (SQLException | FileNotFoundException | IllegalArgumentException e1) {
					throwError(grid, actiontarget);
				}

			}

			private void throwError(GridPane grid, final Text actiontarget) {
				actiontarget.setFill(Color.FIREBRICK);
				actiontarget.setText("Please enter all the fields");
				try {
					grid.add(actiontarget, 1, 7);
				} catch (IllegalArgumentException e) {

				}
			}
		});
		primaryStage.show();
	}
}
