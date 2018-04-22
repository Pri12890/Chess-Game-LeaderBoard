package views;

import java.sql.SQLException;

import controller.DeleteProfileController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlertView {
	public DeleteProfileController deleteProfileController;
	// PlayerCardView playerCardView = new PlayerCardView();
	Scene scene;
	Stage window;

	public void addController(DeleteProfileController deleteProfileController) {
		this.deleteProfileController = deleteProfileController;
	}

	// alert the user if the account needs to be deleted
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		GridPane grid = new GridPane();

		Scene scene = new Scene(grid, 550, 300);
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

		Label description = new Label("Are you sure you want to delete your Profile?");
		grid.add(description, 0, 3);

		// adding TextFields

		// Add "View Highest Score Button
		Button btnDelete = new Button("Click to Delete");
		HBox hbBtnDelete = new HBox(10);
		hbBtnDelete.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtnDelete.getChildren().add(btnDelete);
		grid.add(hbBtnDelete, 1, 9);

		final Text actiontarget = new Text();
		btnDelete.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.FIREBRICK);
				actiontarget.setText("Delete button pressed");
				try {
					AlertView.this.deleteProfileController.deleteProfile();
					actiontarget.setFill(Color.RED);
					actiontarget.setText("Profile Deleted");
					grid.add(actiontarget, 1, 7);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}
}