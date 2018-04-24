package views;

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
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class has the responsibility to create a view where user can see their
 * profile. This class also provides buttons for the user to perform other
 * actions such as - 1. View user statistics 2. View Leader board 3. Update
 * Profile 4. Delete Profile
 */
public class PlayerCardView extends Application {
	PlayerCardController pcc;

	final UserInfofromDb userInfofromDb1;

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

			// Grid Label and TextField for User Id
			Label userId = new Label("User Id:");
			grid.add(userId, 0, 1);
			TextField userIdTextField = new TextField();
			grid.add(userIdTextField, 1, 1);
			userIdTextField.setText(Integer.toString(userInfofromDb1.dbUserId));

			// Grid Label and TextField for UserName
			Label userName = new Label("UserName:");
			grid.add(userName, 0, 2);
			TextField userNameTextField = new TextField();
			grid.add(userNameTextField, 1, 2);
			userNameTextField.setText(userInfofromDb1.dbUserName);

			// Grid Label and TextField for User Description
			Label description = new Label("Description:");
			grid.add(description, 0, 3);
			TextField descriptionTextField = new TextField();
			grid.add(descriptionTextField, 1, 3);
			descriptionTextField.setText(userInfofromDb1.dbDescription);
			Label image = new Label("Image:");
			grid.add(image, 0, 4);
			if (userInfofromDb1.image != null) {
				ImageView imageView = new ImageView(userInfofromDb1.image);
				imageView.setFitWidth(100);
				imageView.setFitHeight(150);
				imageView.setPreserveRatio(true);
				BorderPane layout = new BorderPane();
				layout.setCenter(imageView);
				BorderPane.setAlignment(imageView, Pos.TOP_LEFT);
				grid.add(layout, 1, 4);
			} else {
				// Grid Label and TextField for Image
				TextField imageTextField = new TextField();
				grid.add(imageTextField, 1, 4);
			}

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

			// Your_Stats button handle
			btnYourStats.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					PlayerCardView.this.pcc.yourStatsView();
				}
			});

			// Highest Score button handle
			btnHighestScore.setOnAction((event) -> {
				PlayerCardView.this.pcc.viewHighestScore();
			});

			// Update Button Handle
			btnUpdate.setOnAction((event) -> {
				PlayerCardView.this.pcc.updateProfile(userInfofromDb1);
			});

			// Delete Button Handle
			btnDelete.setOnAction((event) -> {
				PlayerCardView.this.pcc.deleteProfile(userInfofromDb1);
			});
		} catch (Exception e) {
			System.out.println("Player Card view crashed! " + e.getMessage());
		}
	}

}
