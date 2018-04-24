package views;

import controller.UserInfofromDb;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class has the responsibility to create a view for the user where they
 * can view their score, their wins and losses.
 */
public class YourStatsView extends Application {

	final UserInfofromDb userInfofromDb1;

	public YourStatsView(UserInfofromDb userInfofromDb) {
		userInfofromDb1 = userInfofromDb;
	}

	@Override
	public void start(Stage primaryStage) {
		try {

			GridPane grid = new GridPane();

			// Messages in the View
			Text scenetitle = new Text("Welcome");
			Scene scene = new Scene(grid, 400, 400);
			primaryStage.setScene(scene);
			// sets our title for our window
			primaryStage.setTitle("Hello to Chess Login");
			primaryStage.show();
			// sets the position of our objects to center
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			grid.setPadding(new Insets(25, 25, 25, 25));
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);

			// Label and textField for UserName
			Label userName = new Label("User Name:");
			grid.add(userName, 0, 1);
			TextField userTextField = new TextField();
			grid.add(userTextField, 1, 1);
			userTextField.setText(userInfofromDb1.dbUserName);

			// Label and TextField for UserScore
			Label score = new Label("User Score:");
			grid.add(score, 0, 2);
			TextField scoreTextField = new TextField();
			grid.add(scoreTextField, 1, 2);
			scoreTextField.setText(userInfofromDb1.dbScore.toString());

			// Label and TextField for Wins
			Label wins = new Label("Wins:");
			grid.add(wins, 0, 3);
			TextField winsTextField = new TextField();
			grid.add(winsTextField, 1, 3);
			winsTextField.setText(userInfofromDb1.dbWins.toString());

			// Label and TextField for Losses
			Label losses = new Label("Losses:");
			grid.add(losses, 0, 4);
			TextField lossesTextField = new TextField();
			grid.add(lossesTextField, 1, 4);
			lossesTextField.setText(userInfofromDb1.dbLosses.toString());

			// Text control for displaying the message
			final Text actiontarget = new Text();
			grid.add(actiontarget, 1, 6);

		} catch (Exception e) {
			System.out.println("Stats view crashed " + e.getMessage());
		}

	}
}
