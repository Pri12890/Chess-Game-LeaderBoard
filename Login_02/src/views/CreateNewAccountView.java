package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.mysql.jdbc.StringUtils;

import controller.CreateNewAccountController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
import models.RandomScoreGenerator;
import models.UserProfile;

public class CreateNewAccountView extends Application {
	public CreateNewAccountController createNewAccountController;
	public File file;

	public void addController(CreateNewAccountController controller) {
		this.createNewAccountController = controller;
	}

	private void missingDetails(String error, GridPane grid) {
		final Text actiontarget = new Text();
		actiontarget.setFill(Color.FIREBRICK);
		actiontarget.setText("Please enter all the fields");
		try {
			grid.add(actiontarget, 0, 7);
		} catch (IllegalArgumentException e) {

		}
		System.out.println("Error in account creation: " + error);
	}

	@Override
	public void start(Stage primaryStage) {
		try {

			// Grid and Scene
			GridPane grid = new GridPane();
			Text scenetitle = new Text("Welcome");
			Scene scene = new Scene(grid, 400, 400);
			primaryStage.setScene(scene);

			// sets title for window
			primaryStage.setTitle("Hello to Chess Login");
			primaryStage.show();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			grid.setPadding(new Insets(25, 25, 25, 25));
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);

			// Label and TextField for UserName
			Label userName = new Label("Create User Name:");
			grid.add(userName, 0, 1);
			TextField userTextField = new TextField();
			grid.add(userTextField, 1, 1);

			// Label and Text field for password
			Label pw = new Label("Create Password:");
			grid.add(pw, 0, 2);
			PasswordField pwBox = new PasswordField();
			grid.add(pwBox, 1, 2);

			// Label and TextField for Description
			Label description = new Label("Description:");
			grid.add(description, 0, 3);
			TextField userTextField2 = new TextField();
			grid.add(userTextField2, 1, 3);

			// Label for Profile Image
			Label image = new Label("Select Profile Image:");
			grid.add(image, 0, 4);

			// Browse Button
			Button ProfileBtn = new Button("Browse");
			HBox hbProfiltBtn = new HBox(10);
			hbProfiltBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbProfiltBtn.getChildren().add(ProfileBtn);
			grid.add(hbProfiltBtn, 1, 4);

			// Create Account Button
			Button createAccountbtn = new Button("Create Account");
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(createAccountbtn);
			grid.add(hbBtn, 1, 6);

			// browse button handle
			ProfileBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					// object to aid us in the image view
					ImageView imageView = new ImageView();
					Image profileImage;
					BorderPane layout = new BorderPane();

					FileChooser fileChooser = new FileChooser();
					fileChooser.getExtensionFilters()
							.addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
					// get the file form the desktop
					// set the font of the file path

					// single file selection of images
					file = fileChooser.showOpenDialog(primaryStage);
					TextArea textArea = new TextArea();
					if (file != null) {
						// desktop.open(file);
						textArea.setPromptText("Path of Selected File or Files");
						textArea.setFont(Font.font("SanSerif", 12));
						textArea.setPrefSize(300, 50);
						textArea.setEditable(false);

						textArea.setText(file.getAbsolutePath());
						// path, prefWidth, prefHeight, preserveRatio, smooth
						profileImage = new Image(file.toURI().toString(), 100, 150, true, true);

						imageView = new ImageView(profileImage);
						imageView.setFitWidth(100);
						imageView.setFitHeight(150);
						imageView.setPreserveRatio(true);
						layout.setCenter(imageView);
						BorderPane.setAlignment(imageView, Pos.TOP_LEFT);
					}
					grid.add(imageView, 1, 5);
					grid.add(textArea, 1, 4);
				}
			});

			// Create Account Button Handle
			createAccountbtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					String userName = userTextField.getText();
					String userPwd = pwBox.getText();
					String description = userTextField2.getText();

					if (StringUtils.isNullOrEmpty(userPwd) || StringUtils.isNullOrEmpty(userPwd)
							|| StringUtils.isNullOrEmpty(userPwd) || file == null) {
						missingDetails("Missing info", grid);
					} else {
						UserProfile userProfile = new UserProfile(userName, userPwd, description, file,
								RandomScoreGenerator.generateScore(), RandomScoreGenerator.generateWins(),
								RandomScoreGenerator.generateLosses());

						try {
							if (CreateNewAccountView.this.createNewAccountController.doesUserExist(userProfile)) {
								final Text actiontarget1 = new Text();
								actiontarget1.setFill(Color.FIREBRICK);
								actiontarget1.setText("Account Already exists");
								grid.add(actiontarget1, 1, 7);
							} else {
								CreateNewAccountView.this.createNewAccountController.createAccount(userProfile);
								final Text actiontarget1 = new Text();
								actiontarget1.setFill(Color.GREEN);
								actiontarget1.setText("New Account Created");
								grid.add(actiontarget1, 1, 7);
							}
						} catch (SQLException | FileNotFoundException | NullPointerException
								| IllegalArgumentException e1) {
							missingDetails(e1.getMessage(), grid);
						}

					}
				}

			});

		} catch (Exception e) {
			System.out.println("Create Account view crashed " + e.getMessage());
		}
	}
}
