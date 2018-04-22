package views;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import controller.PlayerCardController;
import controller.UserInfofromDb;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlayerCardView extends Application {
	PlayerCardController pcc;

	final UserInfofromDb userInfofromDb1;

	// PlayerCardView playerCardView = new PlayerCardView();
	public PlayerCardView(UserInfofromDb userInfofromDb) {
		userInfofromDb1 = userInfofromDb;

	}

	public void addController(PlayerCardController pcc) {
		this.pcc = pcc;
	}

	public UserInfofromDb getInfo() {
		return this.userInfofromDb1;
	}

	@Override
	public void start(Stage primaryStage) {
		try {

			BorderPane root = new BorderPane();
			GridPane grid = new GridPane();

			Scene scene = new Scene(grid, 600, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));
			primaryStage.setScene(scene);
			// sets our title for our window
			primaryStage.setTitle("Hello to Chess Login");
			primaryStage.show();
			Text scenetitle = new Text("Welcome");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);

			// Grid Labels
			Label userId = new Label("User Id:");
			grid.add(userId, 0, 1);
			Label userName = new Label("UserName:");
			grid.add(userName, 0, 2);
			Label description = new Label("Description:");
			grid.add(description, 0, 3);
			Label image = new Label("Image:");
			grid.add(image, 0, 4);

			// Grid TextFields
			TextField userIdTextField = new TextField();
			TextField userNameTextField = new TextField();
			TextField descriptionTextField = new TextField();
			TextField imageTextField = new TextField();
			userIdTextField.setText(Integer.toString(userInfofromDb1.dbUserId));
			userNameTextField.setText(userInfofromDb1.dbUserName);
			descriptionTextField.setText(userInfofromDb1.dbDescription);
			// adding TextFields
			grid.add(userIdTextField, 1, 1);
			grid.add(userNameTextField, 1, 2);
			grid.add(descriptionTextField, 1, 3);
			grid.add(imageTextField, 1, 4);

			// Add "View Your Score" Button
			Button btnYourStats = new Button("View Your Score");
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_LEFT);
			hbBtn.getChildren().add(btnYourStats);
			grid.add(hbBtn, 0, 7);

			// Add "View Highest Score Button
			Button btnHighestScore = new Button("View Highest Score");
			HBox hbBtn1 = new HBox(10);
			hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn1.getChildren().add(btnHighestScore);
			grid.add(hbBtn1, 1, 7);

			// Add "View Highest Score Button
			Button btnUpdate = new Button("Update");
			HBox hbBtnUpdate = new HBox(10);
			hbBtn1.setAlignment(Pos.BOTTOM_LEFT);
			hbBtn1.getChildren().add(btnUpdate);
			grid.add(hbBtnUpdate, 1, 8);

			// Add "View Highest Score Button
			Button btnDelete = new Button("Delete");
			HBox hbBtnDelete = new HBox(10);
			hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn1.getChildren().add(btnDelete);
			grid.add(hbBtnDelete, 1, 9);

			btnYourStats.setOnAction(new EventHandler<ActionEvent>() {
				final Text actiontarget = new Text();

				@Override
				public void handle(ActionEvent e) {
					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("Sign in button pressed");
					try {
						PlayerCardView.this.pcc.yourStatsView();
					} catch (FileNotFoundException | SQLException e1) {
					}
				}
			});

			btnHighestScore.setOnAction((event) -> {
				try {
					PlayerCardView.this.pcc.viewHighestScore();
				} catch (FileNotFoundException | SQLException e1) {

					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});

			btnUpdate.setOnAction((event) -> {
				try {
					PlayerCardView.this.pcc.updateProfile(userInfofromDb1);
				} catch (FileNotFoundException | SQLException e1) {

					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});

			btnDelete.setOnAction((event) -> {

				try {
					PlayerCardView.this.pcc.deleteProfile(userInfofromDb1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
