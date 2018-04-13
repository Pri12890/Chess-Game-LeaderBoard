package views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LeaderBoardView extends Application {
	public void start(Stage primaryStage) {
		try {

			BorderPane root = new BorderPane();
			GridPane grid = new GridPane();
			Text scenetitle = new Text("Welcome to LeaderBoard");
			Scene scene = new Scene(grid,400,400);
			Label userName = new Label("User Name");
			TextField userTextField = new TextField();
			//text field name and entrance area for username
			grid.add(userName, 0, 1);
			//grid.add(userTextField, 1, 1);

			//text field for Score
			Label score = new Label("Highest Score");
			grid.add(score, 2, 1);
			PasswordField scoreBox = new PasswordField();
			//grid.add(scoreBox, 1, 2);

			//			//test field for Wins
			//			Label wins = new Label("Wins:");
			//			grid.add(wins, 0, 3);
			//			PasswordField winsBox = new PasswordField();
			//			grid.add(winsBox, 1, 3);
			//			
			//			//test field for Wins
			//			Label losses = new Label("Losses:");
			//			grid.add(losses, 0, 4);
			//			PasswordField lossesBox = new PasswordField();
			//			grid.add(lossesBox, 1, 4);
			//			
			//			final Text actiontarget = new Text();

			//??????
			//Code to Handle an Event
			//make the button display the text message when the user presses it. 

			//sets the position of our objects to center
			grid.setAlignment(Pos.TOP_CENTER);
			grid.setHgap(10);
			grid.setVgap(10);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			grid.setPadding(new Insets(25, 25, 25, 25));

			//Add Text, Labels, and Text Fields
			//set our scene title it will appear in the center of our box
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);





			primaryStage.setScene(scene);
			//sets our title for our window
			primaryStage.setTitle("Hello to Chess Login");
			primaryStage.show();

			//Text control for displaying the message
			//grid.add(actiontarget, 1, 6);



		} catch(Exception e) {
			e.printStackTrace();
		}


	}
	public static void main(String[] args) {
		launch(args);
	}
}
