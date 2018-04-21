package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

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

	@Override
	public void start(Stage primaryStage) {
		try {

			BorderPane root = new BorderPane();
			GridPane grid = new GridPane();
			Text scenetitle = new Text("Welcome");
			Scene scene = new Scene(grid, 400, 400);
			Label userName = new Label("Create User Name:");
			TextField userTextField = new TextField();

			TextField userTextField1 = new TextField();
			grid.add(userTextField1, 1, 2);
			// text field for password
			Label pw = new Label("Create Password:");
			grid.add(pw, 0, 2);
			PasswordField pwBox = new PasswordField();
			grid.add(pwBox, 1, 2);

			Label description = new Label("Description:");
			grid.add(description, 0, 3);

			TextField userTextField2 = new TextField();
			grid.add(userTextField2, 1, 3);

			Label image = new Label("Select Profile Image:");
			grid.add(image, 0, 4);
			Button ProfileBtn = new Button("Browse");
			// Add our sign in Button
			HBox hbProfiltBtn = new HBox(10);
			hbProfiltBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbProfiltBtn.getChildren().add(ProfileBtn);
			grid.add(hbProfiltBtn, 1, 4);

			//

			// FOR selecting IMAGE FILES using out browse button
			ProfileBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					// object to aid us in the image view
					ImageView imageView = new ImageView();
					Image profileImage;
					// UserProfile userProfile = new UserProfile(userName, userPwd, description,
					// image);
					BorderPane layout = new BorderPane();

					TextArea textArea = new TextArea();
					FileChooser fileChooser;
					fileChooser = new FileChooser();

					fileChooser.getExtensionFilters()
							.addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
					// get the file form the desktop
					// set the font of the filepath
					textArea.setFont(Font.font("SanSerif", 12));
					textArea.setPromptText("Path of Selected File or Files");
					textArea.setPrefSize(300, 50);
					textArea.setEditable(false);

					// Maybe move outside of browse button
					// single file selection of images
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

					}

					grid.add(imageView, 1, 5);
					grid.add(textArea, 1, 4);

				}
			});

			Button btn = new Button("Create Account");

			final Text actiontarget = new Text();

			// Code to Handle an Event
			// make the button display the text message when the user presses it.
			btn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					String userName = userTextField.getText();
					String userPwd = pwBox.getText();
					String description = userTextField2.getText();

					UserProfile userProfile = new UserProfile(userName, userPwd, description, file,
							RandomScoreGenerator.generateScore(), RandomScoreGenerator.generateWins(),
							RandomScoreGenerator.generateLosses());
					try {
						CreateNewAccountView.this.createNewAccountController.createAccount(userProfile);
						actiontarget.setFill(Color.GREEN);
						actiontarget.setText("New Account Created");
					} catch (SQLException | FileNotFoundException | NullPointerException e1) {
						actiontarget.setFill(Color.FIREBRICK);
						actiontarget.setText("Please enter all the fields");
						System.out.println("Error in account creation: " + e1.getMessage());
					}

					// Text control for displaying the message
					grid.add(actiontarget, 1, 7);
				}
			});

			// sets the position of our objects to center
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			grid.setPadding(new Insets(25, 25, 25, 25));

			// Add Text, Labels, and Text Fields
			// set our scene title it will appear in the center of our box
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);

			// text field name and enterance area for username
			grid.add(userName, 0, 1);

			grid.add(userTextField, 1, 1);

			// Add our sign in Button
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(btn);
			grid.add(hbBtn, 1, 6);

			primaryStage.setScene(scene);
			// sets our title for our window
			primaryStage.setTitle("Hello to Chess Login");
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
